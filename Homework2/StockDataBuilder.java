
/* This is a class used to read from the file, and store them to the LinkedList.
 * @author Tao Guo
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StockDataBuilder {

	// Read the whole list and add them to the LinkList.
	// The TA said assume the csv file in the same folder with the file.
	// So I didn't use the absolute path.
	public LinkedList fileReader(String filename) {

		LinkedList ll = new LinkedList();

		File inputFile = new File(filename);

		try (Scanner input = new Scanner(inputFile)) {
			input.useDelimiter(",|\n");
			input.nextLine();

			while (input.hasNext()) {
				String temp = input.next();
				// Using Date object to read the date in the file.
				Date date = null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(temp);
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}
				double open = input.nextDouble();
				double high = input.nextDouble();
				double low = input.nextDouble();
				double close = input.nextDouble();
				input.next();
				int vol = input.nextInt();

				ll.add(new StockData(date, vol, open, close, high, low));

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		return ll;
	}

	// Get most one year of the data.
	public LinkedList getOneYearData(LinkedList all, Date date) {

		LinkedList oneYear = new LinkedList();

		// Add one year to the date.
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);

		// Get the last date in the list.
		int lastIndex = all.size() - 1;
		Date endDate = ((StockData) all.get(lastIndex)).getDate();

		// Compare them, if equals or greater, noting will be in the list
		if (!date.before(endDate)) {
			return null;
		}

		// Go though the list.
		ListIterator it = all.ListIterator();

		while (it.hasNext()) {

			StockData temp = (StockData) it.next();
			Date tempDate = temp.getDate();

			if ((tempDate.after(date) && tempDate.before(cal.getTime())) || tempDate.equals(date)) {
				oneYear.add(temp);
			}
		}

		return oneYear;
	}

	// Get the outlier based on the one year data.
	public LinkedList getOutlier(LinkedList oneYear) {

		LinkedList outlierList = new LinkedList();
		ListIterator it = oneYear.ListIterator();

		int x = 0;
		int sumXSqure = 0;
		double y = 0;
		int n = 0;
		double xy = 0;

		while (it.hasNext()) {

			StockData temp = (StockData) it.next();
			int num = n;
			double price = temp.getClosePrice();
			x += num;
			sumXSqure += Math.pow(n, 2);
			y += price;
			xy += (n * price);
			n++;
		}

		double a = ((y * sumXSqure) - (x * xy)) / (((n) * sumXSqure) - (x * x));
		double b = (((n) * xy) - (x * y)) / (((n) * sumXSqure) - (x * x));
		double sd = getStandardDeviation(oneYear, a, b);

		ListIterator it1 = oneYear.ListIterator();
		int count = 0;
		while (it1.hasNext()) {

			StockData temp1 = (StockData) it1.next();

			double realPrice = temp1.getClosePrice();
			double ePrice = a + (b * count);

			if ((Math.abs(realPrice - ePrice)) > (Math.sqrt(sd))) {
				outlierList.add(temp1);
			}
			count++;
		}

		return outlierList;
	}

	// Helper methods for calculate the Standard Deviation.
	private double getStandardDeviation(LinkedList oneYear, double a, double b) {

		ListIterator it = oneYear.ListIterator();
		int n = 0;
		double sd = 0;
		while (it.hasNext()) {

			StockData temp = (StockData) it.next();
			double realPrice = temp.getClosePrice();
			double ePrice = a + (b * n);
			sd += Math.pow((realPrice - ePrice), 2);
			n++;
		}
		sd = sd / (n - 2);
		return sd;
	}

}
