/**
 * @author Alperen Ozkaya 
 * Student ID: 041901003
 * @since 07.12.2020 
 * Platform class
 */

public class Platform {
	// data fields
	public double x;
	public double y;
	public double width;
	public double height;

	// constructor of Platform
	public Platform(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	/**
	 * A method to make basic drawings of rectangle shaped platforms
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.filledRectangle(x, y, width / 2, height / 2);
		StdDraw.show();
	}

	/**
	 * 
	 * @param ball
	 * @return true or false a method to check whether the ball touches any platform
	 *         or not
	 */
	public boolean touches(Ball ball) {
		if (ball.x >= x - width / 2 && ball.x <= x + width / 2 && ball.y - ball.radius <= y + (height / 2))
			return true;
		else
			return false;

	}
}
