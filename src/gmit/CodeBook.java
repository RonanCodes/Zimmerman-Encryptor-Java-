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

	// O(n) (MAXIMUM) - linear time, we need to iterate through the HashMap with a key to find the value(List), if the key doesn't exist then we will have gone through n iterations 
	// O(1) Average
	public void addCode(String word, int number){
		List<Integer> numbers = coder.get(word);

		if(numbers == null){
			numbers = new ArrayList<Integer>();
		}
		numbers.add(number);
		coder.put(word, numbers);
	}
	
	// O(n) (MAXIMUM)- linear time, we need to iterate through the HashMap with the key to find the value(List)
	// O(1) Average
	public List<Integer> getCodes(String word){
		return coder.get(word);
	}

	// O(1) (MAXIMUM)- constant time, we need to iterate through the HashMap until we find the matching key
	// O(1) Average
	public void delete(String word){
		coder.remove(word);
	}

	// O(1) (MAXIMUM)- constant time, we need to iterate through the HashMap in order to count each element	
	// O(1) Average
	public int size(){
		return coder.size();
	}
}
