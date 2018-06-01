
/*
 * This is the driver for the movie graph driver.
 * @author Tao Guo
 */

import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("usage: java MovieDriver <filename>");
			System.exit(1);
		}

		GraphBuilder gb = new GraphBuilder();

		gb.fileReader(args[0]);
		// gb.fileReader("/Users/Tao/Downloads/tmdb-5000-movie-dataset/tmdb_5000_credits.csv");

		PathFinder pf = new PathFinder();

		HashMap<String, Set<String>> map = gb.getMap();

		pf.inputAsker(map);

	}

}
