/**
 * @author Alperen Ozkaya 
 * Student ID: 041901003
 * @since 07.12.2020 
 * Ball Class
 */

public class Ball {
	// data fields
	public double x;
	public double y;
	public double radius;
	public double speed;
	public Boolean stopped;

	// constructor of Ball
	public Ball(double x, double y, double radius, double speed) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.speed = speed;
	}

	/**
	 * A method to make basic drawings of filled circles
	 */
	public void draw() {

		StdDraw.setPenColor(StdDraw.GRAY); // set the color for drawing the ball
		StdDraw.filledCircle(x, y, radius); // draw the ball as a filled circle

	}

	/**
	 * A method to move filled circles
	 */

	public void move() {
		while (true) {
			if (y > radius) {
				y = y - speed;
				StdDraw.pause(1); // pause for a short time (20 ms)

				stopped = false;
			} else
				stopped = true;
			break;
		}

	}

}
