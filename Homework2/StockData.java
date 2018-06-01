
/* This is a class of StockData object.
 * @author Tao Guo
 */

import java.util.Date;

public class StockData {

	// Data members.
	private Date date;
	private int volume;
	private double openPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;

	// Constructor.
	public StockData(Date date, int volume, double openPrice, double closePrice, double highPrice, double lowPrice) {
		this.date = date;
		this.volume = volume;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
	}

	// Methods for the StockData object, can be called from outside class.
	public Date getDate() {
		return date;
	}

	public int getVolume() {
		return volume;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public String toSting() {
		return this.date + ": " + this.closePrice;
	}

}
