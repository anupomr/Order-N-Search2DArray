import java.util.Random;
import java.util.Scanner;

/**
 * @author Anupom Roy Title: Ordering, Searching, and Calculations on Arrays of
 *         Numbers
 * 
 *         For java Doc => Alt+Shift+J Add a Javadoc comment to the active
 *         field/method/class.
 * 
 */

public class TwoDimenArray {

	public static Scanner userInput = new Scanner(System.in); // static class scope field accessible to all methods in
																// the
																// class
	public static final String username = "Anupom"; // TODO CODE: change static field to your username
	public static final String stdNumber = "300853516"; // TODO CODE: change static field to your student number

	public static void main(String[] args) throws InterruptedException {
		int mainMenuOption = 0; // declare and init a mainMenu option
		String latTwoChar = stdNumber.substring(stdNumber.length() - 2);
		int magicNumber = Integer.parseInt(latTwoChar);
		int headernumber = magicNumber + 40;

		headerBar(headernumber);
		headerText();
		headerBar(headernumber);

		mainMenuOption = mainMenuText();

		// Validate main menu selection
		while (!(mainMenuOption == 1 || mainMenuOption == 2)) {
			System.out.println("Invalid menu selection! Try again.");
			mainMenuOption = mainMenuText();
		}
		// Create and populate the 2D-array
		int rowLenArray = promptNumArray();
		int colLenArray = promptArrayLength();
		int[][] my2DArray = new int[rowLenArray][colLenArray];
		switch (mainMenuOption) {
		case 1:
			// TODO CODE: code that manually populates the array values by prompting the
			// user to input the values
			menuallyPopulated(my2DArray);
			
			break;
		case 2:
			// TODO CODE: code that automatically populates the array elements with random
			// values in the range of 0 to 100 inclusive
			autoPopulated(my2DArray);		
			break;
		default:
			System.out.println("Error: Something weird happened...exiting program.");
			System.exit(mainMenuOption);
		}

		mainMenuOption = functionMenuText();

		// Validate main menu selection
		while (!(mainMenuOption >= 1 && mainMenuOption <= 6)) {
			System.out.println("Invalid menu selection! Try again.");
			mainMenuOption = functionMenuText();
		}
		switch (mainMenuOption) {
		case 1:
			// TODO CODE: 1 - Addtion of Matrix
			autoPopulated(my2DArray);
			int [][] aNewArray={ { 1 }, { 0 } };
			/*aNewArray = new int[rowLenArray][colLenArray];
			aNewArray=autoPopulated(aNewArray);*/
			pretty2DArray(add2Matrix(my2DArray, aNewArray));
			break;
		case 2:
			// TODO CODE: 2 - Search in Matrix

			break;
		case 3:
			// TODO CODE: 3 - Sort the Matrix
			int[][] newSA = bubbleSort(my2DArray);
			pretty2DArray(newSA);
			break;

		case 4:
			// TODO CODE: 4 - Multiplication of Matrix
			menuallyPopulated(my2DArray);

			break;
		case 5:
			// TODO CODE: 5 - Display the matrix
			pretty2DArray(my2DArray);
			break;
		case 6:
			// TODO CODE: 6 - Summary of of Matrix

			break;
		default:
			System.out.println("Error: Something weird happened...exiting program.");
			System.exit(mainMenuOption);
		}

	} // End Main
	
	public static int linearSearch(int[][]a, int num) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if(a[i][j]==num)
					return 1;
			}
		}
		return -1;
	}
	
	public static int[][] mulMatrix(int[][]a, int[][] b){
		int[][] product = { { 0 }, { 0 } };
		if (a.length == b.length && a[0].length == b[0].length) {
			product = new int[a.length][a[0].length];
			for (int i = 0; i < product.length; i++) {
				for (int j = 0; j < product[0].length; j++) {
					product[i][j]=a[i][j]*b[i][j];
				}
			}
			return product;
		}		
		else {			
			System.out.println(" both matrix are not in same dimention ");
			return product;
		}
		
	}

	public static int[][] add2Matrix(int[][] a, int[][] b) throws InterruptedException {

		int[][] sum = { { 0 }, { 0 } };
		if (a.length == b.length && a[0].length == b[0].length) {
			sum = new int[a.length][a[0].length];
			for (int i = 0; i < sum.length; i++) {
				for (int j = 0; j < sum[0].length; j++) {
					sum[i][j]=a[i][j]+b[i][j];
				}
			}
			return sum;
		}		
		else {
			Thread.sleep(1000);
			System.out.println(" both matrix are not in same dimention ");
			return sum;
		}
	}

	public static int functionMenuText() {
		System.out.println("\n Select a menu for processing : \n" + "\t1 - Addtion of Matrix \n"
				+ "\t2 - Search in Matrix \n" + "\t3 - Sort the Matrix \n" + "\t4 - Multiplication of Matrix \n"
				+ "\t5 - Display the matrix \n" + "\t6 - Summary of of Matrix \n");
		int retValue = userInput.nextInt();
		return retValue;
	}

	public static int[][] bubbleSort(int[][] tdArray) {
		for (int i = 0; i < tdArray.length; i++) {
			for (int j = 0; j < tdArray[i].length; j++) {
				for (int j2 = 0; j2 < tdArray[i].length - j - 1; j2++) {
					if (tdArray[i][j2] > tdArray[i][j2 + 1]) {
						int temp = tdArray[i][j2];
						tdArray[i][j2] = tdArray[i][j2 + 1];
						tdArray[i][j2 + 1] = temp;
					}
				}
			}
		}
		return tdArray;
	}

	/**
	 * This method prints out the 2D-array in a nice table
	 * 
	 * @param arrayRefVar
	 */
	private static void pretty2DArray(int[][] arrayRefVar) {
		System.out.printf(" My2D Array has %d row with %d elements in each row\n", arrayRefVar.length,
				arrayRefVar[0].length);
		System.out.println("The 2D array values are: \n");
		for (int i = 0; i < arrayRefVar.length; i++) {
			for (int j = 0; j < arrayRefVar[i].length; j++) {
				System.out.printf("%4d", arrayRefVar[i][j]);
			}
			System.out.println();
		}

	}

	/**
	 * @param tdArray
	 */
	public static int[][] menuallyPopulated(int[][] tdArray) {
		// TODO
		for (int i = 0; i < tdArray.length; i++) {
			for (int j = 0; j < tdArray[i].length; j++) {
				System.out.println("Enter a new number");
				tdArray[i][j] = userInput.nextInt();
			}
		}
		return tdArray;
	}

	/**
	 * This method will auto populated a 2d-array
	 * 
	 * @param tdArray
	 */
	public static int[][] autoPopulated(int[][] tdArray) {
		for (int i = 0; i < tdArray.length; i++) {
			for (int j = 0; j < tdArray[i].length; j++) {
				tdArray[i][j] = new Random().nextInt(100);
			}
		}
		return tdArray;
	}

	/**
	 * This method prompts the user for the number of 1D-arrays to create
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
	 * * This method prints the required menu text to the console
	 * 
	 * @param void
	 * @return integer value - the main menu option requested
	 */
	public static int mainMenuText() {
		System.out.println("\n Select a menu option : \n" + "\t1 - Manually create arrays for processing\n"
				+ "\t2 - Automatically create arrays for processing\n");
		int retValue = userInput.nextInt();
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
