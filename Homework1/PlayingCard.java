
/**
	A class that represents cards.
	@author Tao Guo
**/

public class PlayingCard implements Comparable<PlayingCard>{

	protected int value;
	protected String suit;
	protected String color;

	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit = suit;
		this.color = color;
	}


	public int getValue() {
		return this.value;
	}

	public String getSuit() {
		return this.suit;
	}

	public String getColor() {
		return this.color;
	}

	public String toString() {
		
		if(value == 1) {
			return "Value: Ace" + "\n" + "Suit: " + suit + "\n" + "Color: " + color + "\n";
		} else if(value == 11) {
			return "Value: Jack" + "\n" + "Suit: " + suit + "\n" + "Color: " + color + "\n";
		} else if(value == 12) {
			return "Value: Queen" + "\n" + "Suit: " + suit + "\n" + "Color: " + color + "\n";
		} else if(value == 13) {
			return "Value: King" + "\n" + "Suit: " + suit + "\n" + "Color: " + color + "\n";
		} else {
			return "Value: " + value + "\n" + "Suit: " + suit + "\n" + "Color: " + color + "\n";
		}
		
	}

	public int compareTo(PlayingCard other) {

		int returnVal = this.value - (other.getValue());
		int returnSuit = this.suit.compareTo(other.getSuit());

		if(returnVal == 0 && returnSuit == 0) {
			
			return 0;

		} else if ((((returnVal) < 0) 
						|| (returnVal == 0)) 
							&& (returnSuit > 0)) {
			
			return returnSuit;

		} else {
			
			return returnVal;

		}
		
	}

}
