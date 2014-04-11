package gmit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class is Serializable which means it can be written as an object to a file, then it's state can be loaded later
 * it takes in a word and a number, 
 */

public class CodeBook implements Serializable{
	private Map<String, Set<Integer>> coder = new HashMap<String, Set<Integer>>(); // string from fileParser class // HashMap gives average constant time with collosiong, TreeMap LogN time gauranteed, default HashMap
	// maps in the exam, HASHMAP == average constant time
	// treeMap = Log(n) , HashMap better
	// study Big O, times
	
	// should run in under 1 second.
	// not our job to encode
	
	// codeGen job to call this
	public void addCode(String word, int number){
		Set<Integer> numbers = coder.get(word); //coder == map
		
		if(numbers == null){
			numbers = new TreeSet<Integer>();
		}
		numbers.add(number); // add one int
		coder.put(word, numbers);
		// hash set uses a hashmap, tree set uses a tree 
		// hash constant, tree logN
	}
	
	public Set<Integer> getCodes(String word){
		return coder.get(word);
	}
	
	public void delete(String word){
		coder.remove(word);
	}
	
	public int size(){
		return coder.size();
	}
	
}
