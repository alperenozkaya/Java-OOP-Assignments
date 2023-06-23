/**
 * @author Alperen Ozkaya	 
 * Student ID: 041901003
 * @since  18.11.2020
 * A program to simulate particular metro lines
 * in Istanbul
 */

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alperen_Ozkaya {

	public static Scanner inputUser = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {

		int canvas_width = 900;
		int canvas_height = 900;
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0, 1200);
		StdDraw.setYscale(0, 1200);

		File metroRoutes = new File("metro.txt");

		Scanner inputFileRoutes = new Scanner(metroRoutes);

		// 2 ArrayLists for names of brands and prices of products separately.
		ArrayList<String> lines = new ArrayList<>();
		ArrayList<String> stations = new ArrayList<>();
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();

		// Read data from a file
		while (inputFileRoutes.hasNextLine()) {
			int i = 0;
			String lineStr = inputFileRoutes.nextLine();
			String[] parts = lineStr.split(";");
			String line = parts[i]; // name is a String
			i++;
			String station = parts[i];
			i++;
			int xx = Integer.parseInt(parts[i]);
			i++;
			int yy = Integer.parseInt(parts[i]);
			i++;

			// as long as integers and strings are found they are being added to ArrayLists.
			lines.add(line);
			stations.add(station);
			x.add(xx);
			y.add(yy);

		}
		System.out.println("Enter starting station:");
		String s = inputUser.nextLine();
		System.out.println("Enter destination station");
		String d = inputUser.nextLine();

	// 2 methods are called to draw the lines
		plotProducts(x, y, stations, lines);
		plotProducts(x, y, lines, stations, s, d);

	}
/**
 * a method to draw the metro lines using input stored in arrays.
 * @param x
 * @param y
 * @param stations
 * @param lines
 * 
 */
	public static void plotProducts(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<String> stations,
			ArrayList<String> lines) {

		for (int i = 0; i < x.size() - 1; i++) {
// if statements to draw the lines in different colors
			if (lines.get(i).equals("M4"))
				StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			else if (lines.get(i).equals("Marmaray"))
				StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			else if (lines.get(i).equals("M5"))
				StdDraw.setPenColor(StdDraw.MAGENTA);
			else if (lines.get(i).equals("M1"))
				StdDraw.setPenColor(StdDraw.BLUE);
			else
				StdDraw.setPenColor(StdDraw.GREEN);

			StdDraw.setPenRadius(0.02);
			StdDraw.point(x.get(i), y.get(i));
			StdDraw.setPenRadius(0.004);
// to draw lines
			if (lines.get(i).equals(lines.get(i + 1))) {
				StdDraw.line(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));
			}
// to print the names of metro stations on canvas
			Font font = new Font("Arial", Font.PLAIN, 12);
			StdDraw.setFont(font);
			StdDraw.text(x.get(i) + 20, y.get(i) + 15, stations.get(i));

		}
	}

	/**
	 * This overloaded method is used to draw the route that user prompts. And outputs that show the route is included in
	 * that method.
	 * @param x
	 * @param y
	 * @param lines
	 * @param stations
	 * @param s
	 * @param d
	 */
	public static void plotProducts(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<String> lines,
			ArrayList<String> stations, String s, String d) {

		StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.004);

		boolean sameLine = lines.get(stations.indexOf(s)).equals(lines.get(stations.indexOf(d))); // a boolean variable to check whether the stations are same or not
// two different statements: one of them the starting station's index is lower, the other one destination's index is lower
		if (stations.contains(s) && stations.contains(d) && stations.indexOf(s) < stations.indexOf(d) && (sameLine)) {
// new arraylists to store specific metro line
			ArrayList<String> stationsUser = new ArrayList<String>(
					stations.subList(stations.indexOf(s), stations.indexOf(d) + 1));
			ArrayList<Integer> xUser = new ArrayList<Integer>(x.subList(stations.indexOf(s), stations.indexOf(d) + 1));
			ArrayList<Integer> yUser = new ArrayList<Integer>(y.subList(stations.indexOf(s), stations.indexOf(d) + 1));
			ArrayList<String> linesUser = new ArrayList<String>(
					lines.subList(stations.indexOf(s), stations.indexOf(d) + 1));

			for (int i = 0; i < stationsUser.indexOf(d); i++) {
				
					StdDraw.line(xUser.get(i), yUser.get(i), xUser.get(i + 1), yUser.get(i + 1));
			}
			System.out.println("Start:" + s + "  Metrolines: " + linesUser.get(stationsUser.indexOf(s)));
			System.out.println("Destination:" + d + "  Metrolines: " + linesUser.get(stationsUser.indexOf(d)));
			System.out.println("Metroline: " + linesUser.get(stationsUser.indexOf(s)));
			
			for (int i = 0; i < stationsUser.size() - 1; i++) {
			  System.out.println("Route: " + stationsUser.get(i) + "-> " + stationsUser.get(i+1));
			}

		} else if (stations.contains(s) && stations.contains(d) && stations.indexOf(d) < stations.indexOf(s) && (sameLine)) {

			ArrayList<String> stationsUser = new ArrayList<String>(stations.subList(stations.indexOf(d), stations.indexOf(s) + 1));
			ArrayList<Integer> xUser = new ArrayList<Integer>(x.subList(stations.indexOf(d), stations.indexOf(s) + 1));
			ArrayList<Integer> yUser = new ArrayList<Integer>(y.subList(stations.indexOf(d), stations.indexOf(s) + 1));
			ArrayList<String> linesUser = new ArrayList<String>(lines.subList(stations.indexOf(d), stations.indexOf(s) + 1));

			for (int i = stationsUser.indexOf(s) - 1; i >= 0; i--) {
				
					StdDraw.line(xUser.get(i + 1), yUser.get(i + 1), xUser.get(i), yUser.get(i));
			}
			System.out.println("Start:" + s + "  Metrolines: " + linesUser.get(stationsUser.indexOf(s)));
			System.out.println("Destination:" + d + "  Metrolines: " + linesUser.get(stationsUser.indexOf(d)));
			System.out.println("Metroline: " + linesUser.get(stationsUser.indexOf(s)));
			
			for (int i = 0; i < stationsUser.size() - 1; i++) {
			  System.out.println("Route: " + stationsUser.get(i) + "<- " + stationsUser.get(i+1));
			
			}
		
		} else if (!sameLine)
			System.out.println(s + " and " + d + " are not on the same metro line!");

		else if (s.equals(d))
			System.out.println("Start and destination stations are the same!");
		else
			System.out.println(s + " or " + d + " is not on any metro lines.");

	}
}

