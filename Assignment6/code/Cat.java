
/**
 * @author Alperen Ozkaya 
 * Student ID: 041901003
 * @since 07.01.2021
 * Cat Class
 */

import java.awt.Color;

public class Cat {
	// data fields
	private int x;
	private int y;
	private Color color;
	private int foodCount;

	// constructor of Cat
	public Cat(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	// no-arg constructor
	public Cat() {

	}

	/**
	 * basic draw method to draw a point representing a cat
	 */
	public void draw() {
		StdDraw.point(x, y);
		StdDraw.pause(1); // the lowest value to get the results as fast as it is possible
	}

	/**
	 * @return the x 
	 * a getter method to get the x value of Cat object in main code
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set a 
	 * setter method to set the x value of Cat object in main code
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y 
	 * a getter method to get the y value of Cat object in main code
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set 
	 * a setter method to set the y value of Cat object in main code
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the color 
	 * a getter method to get the color of Cat object in main code
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set 
	 * a setter method to set the color of Cat object in main code
	 */
	public void setColor() {
		this.color = StdDraw.ORANGE;
	}

	/**
	 * @return the foodCount 
	 * to get the value of foodCount data field of Cat class in main code
	 */
	public int getFoodCount() {
		return foodCount;
	}

	/**
	 * @param foodCount the foodCount to set 
	 * to set the value of foodCount data field of Cat class in main code
	 */
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

}
