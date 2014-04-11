package gmit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* this class contains the codeBook map and has some very important basic methods
 * this class is also Serializable which means it can be written as an object to be loaded later
 */

public class CodeBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6886360696907287612L;
	private Map<String, List<Integer>> coder = new HashMap<String, List<Integer>>();

	public void addCode(String word, int number){
		List<Integer> numbers = coder.get(word);

		if(numbers == null){
			numbers = new ArrayList<Integer>();
		}
		numbers.add(number);
		coder.put(word, numbers);
	}

	public List<Integer> getCodes(String word){
		return coder.get(word);
	}

	public void delete(String word){
		coder.remove(word);
	}

	public int size(){
		return coder.size();
	}
}
