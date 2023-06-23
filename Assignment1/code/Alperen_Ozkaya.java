
/**  
 * @author Alperen Ozkaya	 
 * Student ID: 041901003
 * @since  2020-10-10
 *  A program to calculate the average of all integers that are less than or equal to 10 in a sequence .                                   
 */
                        
import java.util.Arrays;
import java.util.Scanner;

public class Alperen_Ozkaya {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrayTemp = new int[10000]; // an appropriate value(10000) to initialize the array.
		int count = 0;
		
		System.out.println("Enter integers to store them in an array (enter 0 to execute):"); // waiting input from user
		
		for (int i = 0; i <= Integer.MAX_VALUE; i++) { /* a loop to count the amount of numbers that user entered and
			                                              store them in a temporary array.  */
			int num = in.nextInt();
			if (num == 0) {
				break;   // executes the loop when 0 (sentinel) is entered.
			} else
				count++;

			arrayTemp[count - 1] = num; // temporary array that stores the numbers using initialized range(2000).

		}

		if (count < 10000) { /* an if statement to run a loop which creates a new array that stores the
			                  amount of numbers as user entered */

			int[] array = Arrays.copyOf(arrayTemp, count); // new array with proper length.

			System.out.println("Input sequence that user entered: ");
			for (int i = 0; i < array.length; i++) {

				System.out.print(array[i] + " "); // prints the input sequence excluding 0.
			}
			
			{
				int[] arraySmallTemp = new int[array.length]; // new array is initialized using the main Array's length.
				int counter = 0;
				for (int a = 0; a < array.length; a++) { /* a for loop to check numbers in "Array" whether they are
					                                        greater than 10 or not.  */
					if (array[a] <= 10) {
						counter++;

						arraySmallTemp[counter - 1] = array[a]; /* new array with the numbers less than or equal to 10
																(still has some free slots in it if there are numbers
																greater than 10 in "Array")  */														 
					}
				}

				if (counter <= array.length) {

					int[] arraySmall = Arrays.copyOf(arraySmallTemp, counter); /* a new array with proper length (only numbers
					                                                        less than or equal to 10 in it)  */

					if (arraySmall.length <= 0) {       /* an if statement to check the situation which doesn't include any
						                             numbers less than or equal to 10.  */
						System.out.println("\n\nThere are no integers less than or equal to 10 in the input sequence");
					
					} else {

						System.out.println("\n\nIntegers that are less than or equal to 10: ");
						
						for (int i = 0; i < arraySmall.length; i++) {
							System.out.print(arraySmall[i] + " "); // prints the Integers that are less than or equal to 10 
							                                            
						}
						
						System.out.println("\n\nThe average is: " + computeAverage(arraySmall)); /* prints the average of integers that are less than
						                                                                            or equal to 10 using "computeAverage" method.  */                                                                  
					}
				}
			}
		}
	}

	public static double computeAverage(int[] array) { /* a method to calculate the average of integers that are less than 
	                                                      or equal to 10.   */
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {   // a for loop to calculate the sum of integers and numbers of integers in an array.
			if (array[i] <= 10) {    // an if statement to ignore integers greater than 10.

				sum += array[i];
				count++;
			}
		}

		double average = (double) sum / count;  // basic calculation to obtain average, double cast is used to get the number as decimal.
		
		return ((double) ((int)(average * 100)) / 100);   /* the number is multiplied by 100, casted into integer to get rid of decimal parts.
		                                                     and divided by 100 (double cast is used) to get it as double  with 2 decimal parts.  */
	}
}




