package gmit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/* this class takes in a file, reads each line, splits it into an array of strings, converts it to lower case,
 * gets rid of punctuation and adds it to a collection. It then returns this collection back to the calling method.
 */

public class FileParser {
	private static final int CHAR_MIN = 97; //(lower case a)
	private static final int CHAR_MAX = 122; // lower case z

	public Collection<String> parse (String file) throws Exception{
		Collection<String> col = new ArrayList<String>();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		while((line = br.readLine())!=null){
			String[] words = line.split(" ");
		
			for(int i = 0; i < words.length; i++){
		
				String next = process(words[i].trim());
				
				if(next != null && next.length() >= 1)
				{
					col.add(next);
					//System.out.printf("%s\n", next);
				}
			}
		}
		br.close();
		
		return col; // collection
	}
	
	private String process(String s){
		String word = s.trim().toLowerCase();
		StringBuffer buf = new StringBuffer();
		// try out string builder
	
		for(int i = 0; i < word.length();i++){
			if(word.charAt(i) >=CHAR_MIN && word.charAt(i) <= CHAR_MAX)
			{
				buf.append(word.charAt(i));
			}
			/*else if(buf.length() == 0){
				buf.append("-unknown-");
			}*/
		}
		
		return buf.toString();
	}

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
			}
		}
		br.close();
		
		return col; // collection		
	}
}
