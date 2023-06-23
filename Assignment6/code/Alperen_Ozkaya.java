
/**
 * @author Alperen Ozkaya	 
 * Student ID: 041901003
 * @since  07.01.2021
 * A program to animate a randomly moving cat in a world
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alperen_Ozkaya {

	public static void main(String[] args) throws FileNotFoundException {

		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);

		File world = new File("world.txt"); // a text file that includes the number of columns and rows, walls, seas,  foods
		Scanner inputFileWorld = new Scanner(world);
		ArrayList<Integer> blocks = new ArrayList<>(); // an ArrayList to store the numbers representing walls, seas and foods
		// this reads the first line of the text file to get the number of columns and rows
		String matrix = inputFileWorld.nextLine();
		String[] rowsColumns = matrix.split(" ");
		// numbers of rows and columns are assigned
		int rows = Integer.parseInt(rowsColumns[0]);
		int columns = Integer.parseInt(rowsColumns[1]);

		int lengthSquare = 800 / rows; // or columns as they are same (square)

		// a while loop to read numbers representing walls, seas and foods from a text file
		// and store them in an array called "blocks"
		while (inputFileWorld.hasNextLine()) {

			String lineStr = inputFileWorld.nextLine();
			if (!(lineStr.contains(";")))
				continue;

			String[] parts = lineStr.split(";");
			int a = 0;
			while (a < parts.length) {

				int block = Integer.parseInt(parts[a]);
				blocks.add(block);
				a++;
			}
		}
		// two ArrayLists to store the x and y coordinates of all blocks
		ArrayList<Integer> xCoordinates = new ArrayList<Integer>();
		ArrayList<Integer> yCoordinates = new ArrayList<Integer>();
		// all x and y values are assigned
		for (int k = 0; k < 40; k++) {
			int y = 790;
			y = y - 20 * k;
			int l = 0;
			for (; l < 40; l++) {
				int x = 10;
				x = x + 20 * l;

				xCoordinates.add(x);
				yCoordinates.add(y);

			}
		}

		ArrayList<Integer> watersAndWalls = new ArrayList<Integer>(); // an ArrayList to store sea and wall blocks
		ArrayList<Integer> watersAndWallsX = new ArrayList<Integer>(); // stores the x coordinates of sea and wall blocks
		ArrayList<Integer> watersAndWallsY = new ArrayList<Integer>(); // stores the y coordinates of sea and wall blocks
		ArrayList<Integer> foods = new ArrayList<>(); // an ArrayList to store blocks that include foods
		ArrayList<Integer> foodsX = new ArrayList<>(); // stores the x coordinates of foods
		ArrayList<Integer> foodsY = new ArrayList<>(); // stores the y coordinates of foods

		int countBlock = 0;
		int countFood = 0;
		int i = 0;
		// a nested while loop to draw 40X40 matrix of blocks
		// if-else if statements provide to draw the blocks in appropriate colors
		// the x and y coordinates of blocks are stored in related ArrayLists
		while (i < rows) {
			int j = 0;
			while (j < columns) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.square(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
				if (blocks.get(countBlock) == 1) {
					StdDraw.setPenColor(StdDraw.GRAY); // color of walls
					StdDraw.filledSquare(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					watersAndWalls.add(countBlock);
					watersAndWallsX.add(xCoordinates.get(countBlock));
					watersAndWallsY.add(yCoordinates.get(countBlock));
				} else if (blocks.get(countBlock) == 2) {
					StdDraw.setPenColor(StdDraw.BLUE); // color of seas
					StdDraw.filledSquare(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					watersAndWalls.add(countBlock);
					watersAndWallsX.add(xCoordinates.get(countBlock));
					watersAndWallsY.add(yCoordinates.get(countBlock));
				} else if (blocks.get(countBlock) == 3) {
					StdDraw.setPenColor(StdDraw.MAGENTA); // color of foods
					StdDraw.filledSquare(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.square(xCoordinates.get(countBlock), yCoordinates.get(countBlock), lengthSquare / 2);
					foods.add(countBlock);
					foodsX.add(xCoordinates.get(countBlock));
					foodsY.add(yCoordinates.get(countBlock));
					countFood++;
				}
				j++;
				countBlock++;
			}
			i++;
		}

		Cat myCat = new Cat(210, 210, StdDraw.ORANGE); // cat object is created
		

		boolean foodPassed[] = new boolean[countFood]; // boolean array to check whether foods exist or not
		myCat.setFoodCount(0); // foundCount is initialized
		int iterationCount = 0; // to count iterations occurred
		boolean closeIfState = true; // boolean variable to end printing the iterations needed to eat all foods
     
		for (int j = 0; j < foodPassed.length; j++) {
			foodPassed[j] = true;
		}
		// main movement loop
		while (true) {

			StdDraw.setPenColor(myCat.getColor());
			// if and else if statements check whether there is a food in one of the four directions
			// if there is, chooses the specific direction that directs to food
			if ((checkValid(myCat.getX() + 20, myCat.getY(), foodsX, foodsY))
					&& (foodPassed[findIndex(myCat.getX() + 20, myCat.getY(), foodsX, foodsY)])
					&& findIndex(myCat.getX() + 20, myCat.getY(), foodsX, foodsY) != -1) {
				
				foodPassed[findIndex(myCat.getX() + 20, myCat.getY(), foodsX, foodsY)] = false;
				myCat.setX(myCat.getX() + 20);
				myCat.setFoodCount(myCat.getFoodCount() + 1);

			} else if ((checkValid(myCat.getX() - 20, myCat.getY(), foodsX, foodsY))
					&& (foodPassed[findIndex(myCat.getX() - 20, myCat.getY(), foodsX, foodsY)])
					&& findIndex(myCat.getX() - 20, myCat.getY(), foodsX, foodsY) != -1) {
				
				foodPassed[findIndex(myCat.getX() - 20, myCat.getY(), foodsX, foodsY)] = false;
				myCat.setX(myCat.getX() - 20);
				myCat.setFoodCount(myCat.getFoodCount() + 1);

			} else if ((checkValid(myCat.getX(), myCat.getY() + 20, foodsX, foodsY))
					&& (foodPassed[findIndex(myCat.getX(), myCat.getY() + 20, foodsX, foodsY)])
					&& findIndex(myCat.getX(), myCat.getY() + 20, foodsX, foodsY) != -1) {
				
				foodPassed[findIndex(myCat.getX(), myCat.getY() + 20, foodsX, foodsY)] = false;
				myCat.setY(myCat.getY() + 20);
				myCat.setFoodCount(myCat.getFoodCount() + 1);

			} else if ((checkValid(myCat.getX(), myCat.getY() - 20, foodsX, foodsY))
					&& (foodPassed[findIndex(myCat.getX(), myCat.getY() - 20, foodsX, foodsY)])
					&& findIndex(myCat.getX(), myCat.getY() - 20, foodsX, foodsY) != -1) {
				
				foodPassed[findIndex(myCat.getX(), myCat.getY() - 20, foodsX, foodsY)] = false;
				myCat.setY(myCat.getY() - 20);
				myCat.setFoodCount(myCat.getFoodCount() + 1);
				// this else part controls the regular movement; moves the cat up, down, right
				// or left randomly
				// also a method (checkValid) is used to check if there is a wall or a sea in the direction
				// if there is, cat doesn't move and continues to loop until it finds a valid direction
			} else {
				StdDraw.setPenColor(myCat.getColor());

				double rand = Math.random();
				if (rand < 0.25) {
					myCat.setX(myCat.getX() + 20);
					if (checkValid(myCat.getX(), myCat.getY(), watersAndWallsX, watersAndWallsY)) {
						myCat.setX(myCat.getX() - 20);
						continue;
					}
				} else if (rand >= 0.25 && rand < 0.50) {
					myCat.setX(myCat.getX() - 20);
					if (checkValid(myCat.getX(), myCat.getY(), watersAndWallsX, watersAndWallsY)) {
						myCat.setX(myCat.getX() + 20);
						continue;
					}
				} else if (rand >= 0.50 && rand < 0.75) {
					myCat.setY(myCat.getY() + 20);
					if (checkValid(myCat.getX(), myCat.getY(), watersAndWallsX, watersAndWallsY)) {
						myCat.setY(myCat.getY() - 20);
						continue;
					}

				} else {
					myCat.setY(myCat.getY() - 20);
					if (checkValid(myCat.getX(), myCat.getY(), watersAndWallsX, watersAndWallsY)) {
						myCat.setY(myCat.getY() + 20);
						continue;
					}
				}
			}
			// drawing part of cat
			StdDraw.setPenRadius(0.03);
			myCat.draw(); // uses cat class' draw method
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.setPenRadius(0.003);
			StdDraw.filledSquare(myCat.getX(), myCat.getY(), lengthSquare / 2); // this draws a new white circle on the
																				// orange circle to ignore the old position of the cat 
			                                                                    // in order to show that it moves
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.square(myCat.getX(), myCat.getY(), lengthSquare / 2); // restructures the blocks
			iterationCount++; // this counts how many iterations occurred
			// prints the number of foods eaten and how many are left in every 1000 iterations
			if (iterationCount % 1000 == 0 && foods.size() - myCat.getFoodCount() != 0)
				System.out.println("in " + iterationCount + " iterations " + 
			                        myCat.getFoodCount() + " foods are eaten and there are "+ (foods.size() - myCat.getFoodCount()) + " foods left");
			// this prints how many iterations occur until cat eats all the foods
			if (myCat.getFoodCount() == foods.size() && (closeIfState)) {
				System.out.println(iterationCount + " iterations are needed to eat all foods");
				closeIfState = false;
			}
			// if statement to get the required results to use in report
//			if(iterationCount == 20000) {
//				StdDraw.setPenRadius(0.03);
//				StdDraw.setPenColor(myCat.getColor());
//				myCat.draw();
//				break;
//				
//		}
		}
	}

	/**
	 * 
	 * @param x represents the value of x coordination
	 * @param y represents the value of y coordination
	 * @param X represents the ArrayList that stores the x coordinate values
	 * @param Y represents the ArrayList that stores the y coordinate values
	 * @return This method is used to check if the x and y coordinates represent a
	 *         wall or sea, returns true if they do
	 */
	public static boolean checkValid(int x, int y, ArrayList<Integer> X, ArrayList<Integer> Y) {

		for (int j = 0; j < X.size(); j++) {
			if (x == X.get(j) && y == Y.get(j))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * @param x represents the value of x coordination
	 * @param y represents the value of y coordination
	 * @param X represents the ArrayList that stores the x coordinate values
	 * @param Y represents the ArrayList that stores the y coordinate values
	 * @return index This method is used to find the index of something(food in this
	 *         program) using its x and y coordinates
	 */
	public static int findIndex(int x, int y, ArrayList<Integer> X, ArrayList<Integer> Y) {

		int index = -1;

		for (int j = 0; j < X.size(); j++) {
			if (x == X.get(j) && y == Y.get(j))
				index = j;
		}
		return index;
	}
}
