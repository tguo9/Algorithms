
/* This is the driver for this program.
 * @author Tao Guo
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StockDriver {

	public static void main(String[] args) {

		StockDataBuilder builder = new StockDataBuilder();

		// Get input from users.
		Scanner in = new Scanner(System.in);
		System.out.print("Stock Symbol: ");
		String symbol = in.nextLine();
		symbol = symbol.toUpperCase().trim();

		LinkedList allData = new LinkedList();
		allData = builder.fileReader(symbol + ".csv");

		ListIterator it = allData.ListIterator();
		while (it.hasNext()) {
			it.next();
		}

		System.out.print("Starting date: ");
		String temp = in.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(temp);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		LinkedList oneYearData = new LinkedList();

		oneYearData = builder.getOneYearData(allData, date);

		if (oneYearData == null) {
			System.out.println("There is insufficient data for this period.");
			System.exit(0);
		} else {

			ListIterator it1 = oneYearData.ListIterator();
			while (it1.hasNext()) {
				it1.next();
			}
		}

		LinkedList outlierList = new LinkedList();

		outlierList = builder.getOutlier(oneYearData);

		ListIterator it2 = outlierList.ListIterator();
		System.out.println("Outliers for " + symbol + " " + (1900 + date.getYear()) + ": \n");

		while (it2.hasNext()) {
			StockData temp2 = (StockData) it2.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.printf("%s: %3.2f\n", dateFormat.format(temp2.getDate()), temp2.getClosePrice());
		}

	}

}