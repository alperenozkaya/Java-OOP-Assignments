
/**
 * @author Alperen Ozkaya	 
 * Student ID: 041901003
 * @since  07.12.2020
 * A program to animate dropping balls using Ball and Platform classes.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alperen_Ozkaya {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {

		// canvas size, x and y scales are assigned
		StdDraw.setCanvasSize(1000, 600);
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(0, 600);
		// speeding up drawing
		StdDraw.enableDoubleBuffering();

		// Reads files and store information about platforms in an ArrayList
		System.out.print("Enter File Name('platforms1.txt' etc.): ");
		String userInput = in.nextLine();
		File platformsTxt = new File(userInput);
		ArrayList<Platform> platforms = readPlatforms(platformsTxt);

		// ArrayList of ball are initialized
		ArrayList<Ball> balls = new ArrayList<>();
		// infinite while loop to draw platforms and balls
		while (true) {
			for (Platform platform21312 : platforms) // for each loop to draw platforms
				platform21312.draw();
			StdDraw.clear();
			StdDraw.pause(10); // pauses for 10 ms
			balls.add(new Ball(Math.random() * 1000, 600, 6, 5)); // creates a ball object with random x value
			// and constant y, radius and speed values
			
			// drawing and moving part for balls
			label: for (int i = 0; i < balls.size(); i++) {

				balls.get(i).draw();
				// checks whether balls touch platforms or not.
				for (Platform platform : platforms)
					if (platform.touches(balls.get(i)))
						continue label; // a label is used to skip moving the ball and continuing the outer loop

				balls.get(i).move();

			}
			StdDraw.show();

		}

	}

	/**
	 * 
	 * @param txt
	 * @return
	 * @throws FileNotFoundException this method is used to read x, y , width,
	 *                               height values of platforms from txt file
	 */

	public static ArrayList<Platform> readPlatforms(File txt) throws FileNotFoundException {

		Scanner inputFilePlatforms = new Scanner(txt);
		ArrayList<Platform> platforms = new ArrayList<>();

		while (inputFilePlatforms.hasNextLine()) {
			int i = 0;
			String lineStr = inputFilePlatforms.nextLine();
			String[] parts = lineStr.split(",");
			int x = Integer.parseInt(parts[i]); // name is a String
			i++;
			int y = Integer.parseInt(parts[i]);
			i++;
			int width = Integer.parseInt(parts[i]);
			i++;
			int height = Integer.parseInt(parts[i]);
			i++;

			// as long as integers and strings are found they are being added to ArrayLists.
			platforms.add(new Platform(x, y, width, height));

		}
		return platforms;

	}

}