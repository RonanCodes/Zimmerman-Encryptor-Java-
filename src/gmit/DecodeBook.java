package gmit;

/* this class contains the decodeBook map and has some very important basic methods
 * this class is also Serializable which means it can be written as an object to be loaded later
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DecodeBook implements Serializable{
	private static final long serialVersionUID = 7865719976460627259L;
	private Map<Integer, String> decoder = new HashMap<Integer, String>();

	// Average O(1), Maximum O(n)
	public String decode(int number){
		return decoder.get(number);
	}

	// Average O(1), Maximum O(n)
	public void addCode(int code, String word){
		decoder.put(code, word);
	}

	// Average O(1), Maximum O(n)
	public String getCode(int code){
		return decoder.get(code);
	}
}
