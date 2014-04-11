package gmit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DecodeBook implements Serializable{
	private Map<Integer, String> decoder = new HashMap<Integer, String>();
	
	public String decode(int number){
		return decoder.get(number);
	}
	// coderGenerator calling us
	public void addCode(int code, String word){
		decoder.put(code, word);
	}
	
	public String getCode(int code){
		return decoder.get(code);
	}
}
