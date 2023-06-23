
/**  
 * @author Alperen Ozkaya	 
 * Student ID: 041901003
 * @since  18/10/2020
 *  A program to draw circles using user inputs.                                  
 */

import java.util.Arrays;
import java.util.Scanner;

public class Alperen_Ozkaya {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrayTemp = new int[10000]; // an appropriate value(10000) to initialize the array.
		int count = 0;

		System.out.println("Enter integers as circle radii(enter between 1-9, enter 0 to execute):"); // waiting input from user
	
		for (int i = 0; i <= Integer.MAX_VALUE; i++) { /*
														 * a loop to count the number of integers that user entered and
														 * store them in a temporary array.
														 */
			int num = in.nextInt();
			if (num == 0) {
				break; // executes the loop when 0 (sentinel) is entered.
			} else
				count++;

			arrayTemp[count - 1] = num; // temporary array that stores the numbers using initialized range(10000).

		}

		if (count < 10000) { /*
								 * an if statement to run a loop which creates a new array that stores the
								 * amount of numbers as user entered
								 */
			int[] array = Arrays.copyOf(arrayTemp, count); // new array with proper length.
			
			{
				
				StdDraw.setCanvasSize(800, 800);  // canvas size set to 800-800
				
				// x and y scale are set to 0-100 
				StdDraw.setXscale(0, 100);
				StdDraw.setYscale(0, 100);

				// the largest circle radius  is set as integer using maxRadius method.
				int largestCircle = maxRadius(array);

				for (int i = 0; i < array.length; i++) {   // a for loop which includes two conditions to draw circles.

					if (array[i] == largestCircle) {    // first condition which the radius/radii is/are the largest.
						
						// random x and y coordination components to set the coordinates of the circles inside the canvas.
						double a = ((Math.random() * (100 - (2 * array[i]))) + array[i]);
						double b = ((Math.random() * (100 - (2 * array[i]))) + array[i]);

						StdDraw.text(a, b, Integer.toString(array[i]));    // shows the radii of circles in center.

						// draws blue circles
						StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);    
						StdDraw.setPenRadius(0.005);
						StdDraw.circle(a, b, array[i]);

						// center points of circles are plotted.
						StdDraw.setPenRadius(0.008);
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.point(a, b);

						StdDraw.setPenColor(StdDraw.BLACK);  // this resets the pen color for next iteration.

						StdDraw.show();  // show the drawing by copying off screen canvas to on screen
					} else {   // second condition which the radius/radii is/are not the largest.
						
						// random x and y coordination components to set the coordinates of the circles inside the canvas.
						double a = ((Math.random() * (100 - (2 * array[i]))) + array[i]);
						double b = ((Math.random() * (100 - (2 * array[i]))) + array[i]);
						
						StdDraw.text(a, b, Integer.toString(array[i]));   // shows the radii of circles
						
						// draws black circles
						StdDraw.setPenRadius(0.005);
						StdDraw.circle(a, b, array[i]);

						// center points of circles are plotted.
						StdDraw.setPenRadius(0.008);
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.point(a, b);

						StdDraw.setPenColor(StdDraw.BLACK);  // this resets the pen color for next iteration.
						
						StdDraw.show();   // show the drawing by copying off screen canvas to on screen
					}
				}
			}
		}
	}
	
// a basic method to find the greatest integer in an array.
	public static int maxRadius(int[] array) {

		int max = array[0];   // first element of array is initialized as maximum number
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];        
			}
		}
		return max;
	}
}
