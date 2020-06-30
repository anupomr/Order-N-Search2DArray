import java.util.Scanner;

/**
 * @author Anupom Roy 
 * For java Doc => Alt+Shift+J
 * Add a Javadoc comment to the active field/method/class. 
 * 
 */

public class TwoDimenArray {


	public static Scanner userInput = new Scanner(System.in); // static class scope field accessible to all methods in the
															// class
	public static final String username = "Anupom"; // TODO CODE: change static field to your username
	public static final String stdNumber = "300853516"; // TODO CODE: change static field to your student number

	public static void main(String[] args) {
		int mainMenuOption = 0; // declare and init a mainMenu option
		String latTwoChar = stdNumber.substring(stdNumber.length() - 2);
		int magicNumber = Integer.parseInt(latTwoChar);
		int headernumber =0;
		headernumber = (magicNumber + 40) > 60 ? headernumber = 60 : headernumber + 40;
		headerBar(headernumber);
		headerText();
		headerBar(headernumber);

		mainMenuOption = mainMenuText();
		
		
		
	} //End Main
	
	
	public static int mainMenuText() {
		System.out.println("\n Select a menu option : \n"
				+"\t1 - Manually create arrays for processing\n"
				+"\t2 - Automatically create arrays for processing\n");
		int retValue=userInput.nextInt();
		return retValue;
	}
	/**
	 * This overloaded method prints between 40 and 60 '*' characters to the console
	 * as a separate line for formatted output. It defaults to 40 "*" characters if
	 * argument provide is not in the range of 40 to 60 inclusive
	 * 
	 * @param count - integer value giving the number of '*' characters to print
	 * @return void
	 */
	public static void headerBar(int count) {
		if (count > 40 && count <= 60) {
			for (int i = 0; i < count; i++)
				System.out.print("*");

			System.out.println();
			return;
		} else {
			headerBar();
			return;
		}

	}
	/**
	 * This method prints 40 '*' characters to the console as a separate line for
	 * formatted output
	 * 
	 * @param void
	 * @return void
	 */
	public static void headerBar() {
		for (int i = 0; i < 40; i++)
			System.out.print("*");

		System.out.println();
	}

	/**
	 * This method prints the require output header text to the console
	 * 
	 * @param void
	 * @return void
	 */
	public static void headerText() {
		System.out.printf("ES1036 LAb 04 P3\n" + "Username: %s\n" + "Std. Number: %s\n"
				+ "Title: Ordering, Searching, and Calculations on Arrays of Numbers\n", username, stdNumber);
	}

	
	

}
