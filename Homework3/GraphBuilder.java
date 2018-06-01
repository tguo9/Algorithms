
/*
 * This is the class read the file and add actors to the graph.
 * Special Thanks:
 * 	In-person Source: Professor Brizan, Thomas Oropeza, Noah King
 * 	Online Source: StackOverflow, GeeksforGeeks, Java API, Google
 * 	Reference from Professor Galles note, class note and Professor Rollins sample
 *	Additional library:
 *	Using JSON.org library to handle the JSON format in the file.
 *	Link: https://www.json.org/
 *	Source Code on GitHub: https://github.com/stleary/JSON-java
 *	Download .zip file on GitHub and import to this assessment.
 *	The package of this additional library named org.json
 *
 * @author Tao Guo
 */

import java.io.File;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

public class GraphBuilder {

	private HashMap<String, Set<String>> maps = new HashMap<>(1000);

	public void fileReader(String fileName) {

		File inFile = new File(fileName);
		String inString = "";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inFile));
			inString = reader.readLine();
			while ((inString = reader.readLine()) != null) {

				int startIndex = inString.indexOf('[');
				int endIndex = inString.indexOf("}]");
				if (startIndex > -1 && endIndex > -1) {
					String temp = inString.substring(startIndex + 1, endIndex);
					if (!temp.isEmpty()) {

						String[] strs = temp.split("},");
						addToMap(strs);

					}

				}

			}
			reader.close();
		} catch (IOException ex) {
			System.out.println("Cannot find file!");
		}
	}

	private void addToMap(String[] strs) {

		for (int i = 0; i < strs.length; i++) {

			String tmp = stringManipulator(strs[i]);

			if (tmp.startsWith("{")) {

				JSONObject dataJson = new JSONObject(tmp);

				String nameOut = dataJson.getString("name");
				// nameOut = nameOut.toLowerCase();

				for (int j = 0; j < strs.length; j++) {

					String innerTemp = stringManipulator(strs[j]);

					if (innerTemp.startsWith("{")) {

						if (i != j) {
							JSONObject data = new JSONObject(innerTemp);

							String name = data.getString("name");
							// name = name.toLowerCase();

							if (maps.containsKey(name)) {
								Set<String> set = maps.get(name);
								set.add(nameOut);
							} else {
								Set<String> set = new HashSet<>(10);
								set.add(nameOut);
								maps.put(name, set);

							}
						}

					}

				}

			}

		}
	}

	private String stringManipulator(String str) {

		String returnVal = (str + '}').trim().replaceAll("}}", "}");
		returnVal = returnVal.replaceAll("\"\"", "\"");

		return returnVal;

	}

	public HashMap<String, Set<String>> getMap() {

		return maps;
	}
}
