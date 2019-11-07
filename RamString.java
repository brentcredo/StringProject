

package cmsc256;
/*
 * CMSC 256 Fall 2019
 * Project 2
 * Credo, Brent
 */


/**
 * This is an interface for a simple class that represents a string, defined
 * as a sequence of characters.
 */
public class RamString implements WackyStringInterface{
	
	/*
	 * main method
	 * used to test the methods
	 * 
	 */
	
	public static void main(String[]args) {

		RamString proj = new RamString();
		RamString cash = new RamString("V00123856");
		RamString coin = new RamString("fdbsfuBUY6BO9UYFEbhbifd5367946587");

		System.out.println(proj.getFirstMiddleLast());
		System.out.println(proj.getEveryThirdCharacter());
		System.out.println(coin.countEvenDigits());
		System.out.println(cash.isValidEID());
		
	}
	/*
	 * declaring a String called str to be used by the methods
	 */
	private String str;
	
	/*
	 * setting str equal to "Rodney the Ram"
	 */
	public RamString() {
		
		str = "Rodney the Ram";
	}
	/*
	 * tests if the str is null and returns a null string
	 * is not it sends str to setWackyString
	 */
	
	public RamString(String str) {
		if(str == null) {
			throw new NullPointerException("null string");
		}
		
		setWackyString(str);
	}
	
	/**
	 * Sets the value of the current string.
	 * @param string	The value to be set
	 * tests if there is an empty string and prints empty string if it is empty
	 * refers to the class instance variable
	 */
	@Override
	public void setWackyString(String str) {
		if(str == null) throw new IllegalArgumentException("Empty string");{
			
		this.str = str;
	}
	}

	/**
	 * Returns the current string
	 * @return Current string
	 */
	@Override
	public String getWackyString() {
		return str;
	}

	
	/**
	 * Returns a string that consists of only the characters
	 * in the first, middle and last positions in
	 * the current string, in the same order and with the same case as
	 * in the current string. The first character in the string is
	 * considered to be in Position 1.
	 *
	 * @return String 	made of characters in first, middle and last 
	 * 					positions in the current string
	 */
	@Override
	public String getFirstMiddleLast() {
		/*
		 * empty strings to be filled later in the method
		 */
		String first = "";
		String middle = "";
		String last = "";
		/*
		 * returns str if empty
		 */
		if(str.length() == 0) {
			return str;
		}
		/*
		 * once determined not empty, goes through the algorithm
		 * sets first equal to first char
		 * sets last to the last char
		 * sets middle to the middle if odd number or the one to the left if odd number
		 * adds together the string
		 */
		
		first = str.substring(0, 1);
		last = str.substring((str.length())-1,(str.length()));
		
		if (str.length() % 2 == 0) {
			middle = str.substring((str.length()/2)-1, (str.length()/2));
		}else {
			middle = str.substring(((str.length()/2)), (str.length()/2)+1);
		}
		
		return first + middle + last;
	}

	
	/**
	 * Returns a string that consists of all and only the characters
	 * in the "every third" positions (i.e., third, sixth, ninth and so on)
	 * current string, in the same order and with the same case as in
	 *  in the current string. The first character in the string is
	 * considered to be in Position 1.
	 *
	 * @return String 	made of characters in every third position 
	 * 					in the current string
	 */
	@Override
	public String getEveryThirdCharacter() {
		/*
		 * skips straight to the third char and counts every third
		 */
		
		String ch = "";
		for (int i = 2; i < str.length(); i += 3) {
			ch = ch + str.charAt(i);
		}
		return ch;
	}

	/**
	 * Returns the number of characters that are even digits
	 *  in the current string
	 * @return Number of even digits in the current string
	 */
	@Override
	public int countEvenDigits() {
		/*
		 * put into a char array
		 * determines if the number is a digit
		 * determines if it has a remainder
		 * if it does it adds to the count
		 */
		
		int count = 0;
		char[]nums = str.toCharArray();

		
		for(int i = 0; i < nums.length; i++) {
			if(Character.isDigit(nums[i])) {
				if(nums[i] % 2 == 0) {
					count ++;
				}
			}
			
		}
		return count;
	}
	
	/**
	 * Returns true if the current string has a capital V as it's first 
	 * character, followed by two zero characters (00), and then 
    * 6 additional digits. 
	 *	For example, V00123456 a valid VCU eID.
	 *
	 * @return true 	if current string is formated as valid VCU eID,
	 * 					false otherwise.
	 */
	
	@Override
	public boolean isValidEID() {
		/*
		 * ensures that the V is followed by two zeros and a length of 9
		 */
		if ((str.charAt(0) == 'V') && (str.charAt(1) == '0') && (str.charAt(2)=='0')&&(str.length() == 9)) {
			return true;
			}
		else {
			return false;
		}
	}

	
	/**
	 * Replace the _individual_ digits in the current string, between
	 * startPosition and endPosition (included), with the corresponding
	 * word. The first character in the string is
	 * considered to be in Position 1. Digits are converted individually,
	 * even if contiguous, and digit "0" is not converted (e.g., 460 is
	 * converted to foursix0). This method changes the instance variable.
	 *
	 * @param startPosition		Position of the first character to consider
	 * @param endPosition		Position of the last character to consider
	 * @throws MyIndexOutOfBoundsException
	 *            	If either "startPosition" or "endPosition" are out of bounds
	 *             	(i.e., either less than 1 or greater than the length of the string)
	 * @throws IllegalArgumentException
	 *            If "startPosition" > "endPosition" (but both are within bounds)
	 */
	@Override
	public void convertDigitsToWordsInSubstring(int startPosition, int endPosition) {
		/*
		 * exceptions if startPosition/endPosition is not possible
		 */
		String wordNums = "";
		if ((startPosition < 1) || (endPosition < 1)) {
			throw new MyIndexOutOfBoundsException("Index out of bounds");
		}
		if(startPosition > endPosition) {
			throw new IllegalArgumentException("Illegal argument");
		}
		if((startPosition) > (str.length()) || (endPosition > str.length())) {
			throw new MyIndexOutOfBoundsException("Index out of bounds");
		}
/*
 * for loop that goes through the string and matches the number to the word
 */
		for (int i = (startPosition-1); i < endPosition; i ++) {
			if(str.charAt(i) == '1') {
				wordNums += "ONE";
			}
			else if(str.charAt(i) == '2') {
				wordNums += "TWO";
			}
			else if(str.charAt(i) == '3') {
				wordNums += "THREE";
			}
			else if(str.charAt(i) == '4') {
				wordNums += "FOUR";
			}
			else if(str.charAt(i) == '5') {
				wordNums += "FIVE";
			}
			else if(str.charAt(i) == '6') {
				wordNums += "SIX";
			}
			else if(str.charAt(i) == '7') {
				wordNums += "SEVEN";
			}
			else if(str.charAt(i) == '8') {
				wordNums += "EIGHT";
			}
			else if(str.charAt(i) == '9') {
				wordNums += "NINE";
			}
			else {
				wordNums += str.charAt(i);
			}
		}
		/*
		 * sets empty string to the front and end
		 * adds the total string
		 */
		String strFrt = str.substring(0,(startPosition-1));
		String strEnd = str.substring(endPosition, str.length());
		str = strFrt + wordNums + strEnd;
		}
	}