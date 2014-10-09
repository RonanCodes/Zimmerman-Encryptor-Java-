package gmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/* this class takes in a file, reads each line, splits it into an array of strings, converts each to lower case,
 * removes punctuation and adds it to a collection.
 * It then returns this collection back to the calling method.
 */

public class FileParser {
	private static final int CHAR_MIN = 97; // lower case a
	private static final int CHAR_MAX = 122; // lower case z

	// O(N^3) - a for loop is called on each line read, this for loop calls the process method which contains a for loop
	public Collection<String> parseStr (String file) throws Exception{
		Collection<String> col = new ArrayList<String>();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		while((line = br.readLine())!=null){
			String[] words = line.split(" ");

			for(int i = 0; i < words.length; i++){
				String next = process(words[i].trim());

				if(next.length() >= 1)
				{
					col.add(next);
				}
			} // for
		} // while
		br.close();

		return col; // collection
	} // parseStr

	public Collection<String> parseNum (String file) throws Exception{
		Collection<String> col = new ArrayList<String>();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

		while((line = br.readLine())!=null){
			String[] words = line.split(" ");

			for(int i = 0; i < words.length; i++){

				String next = words[i].trim();

				if(next != null)
				{
					col.add(next);
				}
			} // for
		} // while
		br.close();

		return col; // collection		
	} // parseNum
	
	private String process(String s){
		String word = s.trim().toLowerCase();
		StringBuilder buf = new StringBuilder();

		for(int i = 0; i < word.length();i++){
			if(word.charAt(i) >=CHAR_MIN && word.charAt(i) <= CHAR_MAX)
			{
				buf.append(word.charAt(i));
			}
		} // for

		return buf.toString();
	} // process
}
