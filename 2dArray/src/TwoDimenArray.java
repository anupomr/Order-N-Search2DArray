import java.util.Random;
import java.util.Scanner;

/**
 * @author Anupom Roy 
 * Title: Ordering, Searching, and Calculations on Arrays of Numbers
 * 
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
		int headernumber =magicNumber + 40;
		
		headerBar(headernumber);
		headerText();
		headerBar(headernumber);

		mainMenuOption = mainMenuText();
		
		// Validate main menu selection 
		while(!(mainMenuOption==1 || mainMenuOption==2)) {
			System.out.println("Invalid menu selection! Try again.");
			mainMenuOption = mainMenuText();
		}
		// Create and populate the 2D-array
		int rowLenArray=promptNumArray();
		int colLenArray=promptArrayLength();
		int [][] my2DArray= new int[rowLenArray][colLenArray];
		switch(mainMenuOption) {
		case 1:
			// TODO CODE: code that manually populates the array values by prompting the
			// user to input the values
			menuallyPopulated(my2DArray);
			pretty2DArray(my2DArray);
			break;
		case 2:
			// TODO CODE: code that automatically populates the array elements with random
			// values in the range of 0 to 100 inclusive
			autoPopulated(my2DArray);
			pretty2DArray(my2DArray);
			break;
		default:
				System.out.println("Somthing weird happend.. exiting program.");
				System.exit(mainMenuOption);
		}
		
	} //End Main

	/**
	 * This method prints out the 2D-array in a nice table
	 * @param arrayRefVar
	 */
	private static void pretty2DArray(int[][]arrayRefVar) {
		System.out.printf(" My2D Array has %d row with %d elements in each row\n", arrayRefVar.length,
				arrayRefVar[0].length);
		System.out.println("The 2D array values are: \n");
		for (int i = 0; i < arrayRefVar.length; i++) {
			for (int j = 0; j < arrayRefVar[i].length; j++) {
				System.out.printf("%4d",arrayRefVar[i][j]);
			}
			System.out.println();
		}

	}
	
	/**
	 * @param tdArray
	 */
	public static void menuallyPopulated(int[][] tdArray) {
		// TODO 
		for (int i = 0; i < tdArray.length; i++) {
			for (int j = 0; j < tdArray[i].length; j++) {
				System.out.println("Enter a new number");
				tdArray[i][j]=userInput.nextInt();
			}
		}
		

	}
	
	/**
	 * This method will auto populated a 2d-array
	 * @param tdArray
	 */
	public static void autoPopulated(int[][] tdArray) {
		for (int i = 0; i < tdArray.length; i++) {
			for (int j = 0; j < tdArray[i].length; j++) {
				tdArray[i][j]= new Random().nextInt(100);
			}
		}

	}	
	
	/**
	 *  This method prompts the user for the number of 1D-arrays to create
	 * 
	 * @param void
	 * @return integer 
	 */
	public static int promptNumArray() {
		// TODO 
		System.out.println("Enter the number of 1D-array to create: ");
		int value = userInput.nextInt();
		System.out.println();// advance to the next line to keep things pretty
		return value;
	}
	/**
	 * This method prompts the user for the fixed length of the 1D-array to create.
	 * 
	 * @param void
	 * @return integer 
	 */
	public static int promptArrayLength() {
		// TODO 
		System.out.println("Enter the number of elements each 1D-array should have: ");
		int value = userInput.nextInt();
		System.out.println();// advance to the next line to keep things pretty
		return value;

	}
	/**
	 *  * This method prints the required menu text to the console
	 * 
	 * @param void
	 * @return integer value - the main menu option requested
	 */
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
