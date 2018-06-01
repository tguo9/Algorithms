
/*
 * This is a class that help to find the shortest path in graph.
 * Special Thanks:
 * 	In-person Source: Professor Brizan, Thomas Oropeza, Noah King
 * 	Online Source: StackOverflow, GeeksforGeeks, Java API, Google
 * 	Reference from Professor Galles note, class note and Dijkstra’s algorithm.
 * @author Tao Guo
 */

import java.util.*;

public class PathFinder {

	public LinkedList<String> bfs(String actor1, String actor2, HashMap<String, Set<String>> maps) {

		Queue<String> q = new LinkedList<String>();
		Set<String> visited = new HashSet<>();
		HashMap<String, String> actors = new HashMap<>();

		q.add(actor1);

		while (!q.isEmpty()) {

			String actor = q.remove();

			if (actor.equals(actor2)) {

				LinkedList<String> list = new LinkedList<>();

				while (!actor.equals(actor1)) {

					list.addFirst(actor);
					actor = actors.get(actor);
				}

				list.addFirst(actor);

				return list;
			}

			Set<String> set = maps.get(actor);

			for (String s : set) {

				if (!visited.contains(s)) {

					actors.put(s, actor);
					q.add(s);
					visited.add(s);
				}
			}
		}

		return null;
	}

	public void quitter(String name, boolean looper) {

		if (name.equals("quit") || name.equals("exit") || name.equals("q")) {

			looper = false;
			System.exit(0);

		}
	}

	public void pathPrinter(LinkedList<String> path, String actor1, String actor2) {

		if (path == null) {

			System.out.println("No path between " + actor1 + "and " + actor2);

		} else {

			System.out.print("Path between " + actor1 + " and  " + actor2 + ": " + path.get(0));

			for (int i = 1; i < path.size(); i++) {

				System.out.print(" --> " + path.get(i));

			}

			System.out.println();
		}
	}

	public void inputAsker(HashMap<String, Set<String>> map) {

		Scanner scan = new Scanner(System.in);

		boolean looper = true;

		while (looper) {

			System.out.print("Actor 1 name: ");
			String actor1 = scan.nextLine();

			quitter(actor1, looper);

			if (!map.containsKey(actor1)) {

				System.out.println("No such actor.");
				continue;
			}

			System.out.print("Actor 2 name: ");
			String actor2 = scan.nextLine();

			quitter(actor2, looper);

			if (!map.containsKey(actor2)) {

				System.out.println("No such actor.");
				continue;
			}

			LinkedList<String> path = bfs(actor1, actor2, map);

			pathPrinter(path, actor1, actor2);
		}
	}

}