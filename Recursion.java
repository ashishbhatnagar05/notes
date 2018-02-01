package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class Recursion {
	private BufferedReader in = null;

	@Ignore
	@Test
	public void testadd_factorial() {
		System.out.println(add(10));
		System.out.println(factorial(5));
	}

	@Ignore
	@Test
	public void testIterateFile() throws IOException {
		String root = "Gists";
		String trimCharacter = ":";
		getRootFromReader(root, trimCharacter, reader("C:\\test\\temp.txt"));
	}

	public void getRootFromReader(String root, String trimCharacter, Reader reader) throws IOException {
		List<String> list = new ArrayList<String>();
		BufferedReader in = (BufferedReader) reader;
		String line = in.readLine();

		while (!(line == null) && !line.equals("")) {
			if (line.trim().contains(root)) {
				line = trimString(line.trim(), trimCharacter);
				break;
			} else {
				line = in.readLine();
			}

		}
		System.out.println(line);
	}

	@Test
	public void testRecusionFile() throws IOException {
		String root = "Gists";
		String trimCharacter = ":";
		in = reader("C:\\test\\temp.txt");
		List<String> list = getRootFromReaderRecursion(root, trimCharacter, "");
		System.out.println("Final list:" + list);
	}

	public List<String> getRootFromReaderRecursion(String root, String trimCharacter, String line) throws IOException {

		List<String> list = new ArrayList<String>();
		if (in != null && line != null) {
			if (line.trim().contains(root)) {
				line = trimString(line.trim(), trimCharacter);
				list.add(line);
				System.out.println("Line added to List: " + line);
				System.out.println("List in recursive function:" + list);
				return list;
			} else {
				list = getRootFromReaderRecursion(root, trimCharacter, in.readLine());
			}

		}
		return list;

	}

	public String trimString(String str, String trimCharacter) {
		str = str.substring(str.indexOf(trimCharacter) + 1, str.length()).trim();
		return str;
	}

	public BufferedReader reader(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return bufferedReader;
	}

	/*
	 * 
	 * Dummy Code
	 * 
	 * 
	 */

	public int add(int n) {
		if (n == 0) {
			return 0;
		}

		return n + add(--n);

	}

	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}

		return n * factorial(--n);

	}

}


/*
#%RAML 1.0
title: GitHub API
version: v3
baseUri: https://api.github.com
mediaType:  application/json
securitySchemes:
  oauth_2_0: !include securitySchemes/oauth_2_0.raml
types:
  Gist:  !include types/gist.raml
  Gists: !include types/gists.raml
resourceTypes:
  collection: !include types/collection.raml
traits:
securedBy: [ oauth_2_0 ]
/search:
  /code:
    type: collection
    get:
*/