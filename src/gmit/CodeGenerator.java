package gmit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class creates all the other classes and links them together.
 * The testRunner class will use this class process the data
 */

public class CodeGenerator {
	private CodeBook coder = new CodeBook(); // we can serialize this object
	private DecodeBook decoder = new DecodeBook(); // we can serialize this object
	private FileParser parser = new FileParser();
	private CodeWriter writer = new CodeWriter();
	private FileDecoder fileDecoder = new FileDecoder();
	// SaveCodeBook
	// LoadCodeBook
	
	private Random random = new Random(); // seeds from time automatically (uses System.currtime.millis)
	private static final int MAX_RANGE = 75000;
	private Set<Integer> used = new HashSet<Integer>();
	private int numCount;
	
	// the following method generates the initial 900 word codeBook, and the initial 75000 number decodeBook
	// more words/numbers can be added to the codeBooks when reading in a file
	public void generateCodeBooks(String wordFile) throws Exception{
		Collection<String> words = parser.parse(wordFile); // now we have a collection of words
		
		int count = 0;
		
		// the following for loop iterates through each word in the words String array
		for(String word: words){
			int numCodes = computeFreq(count); // this method checks frequency
			int next = 0;
			count++;

			// the following inner for loop adds a set number of integers to a word depending on that words computed frequency
			for(int i = 0; i < numCodes; i++){
				boolean unique;
				
				// the following inner inner (do/while) loop makes sure that the random number selected hasn't already being used
				do{
					next = random.nextInt(100000 - 10000) + 10000; // make sure it's 5 digits
					unique = used.add(next);
				}while(unique == false);
				
				numCount++;
				coder.addCode(word, next);
				decoder.addCode(next, word);
			} // while
		} // for
		System.out.printf("\n%d numbers added to %d words in the initial codeBook generation.\n", numCount, count);
	}
	
	public void encodeFile(String wordFile) throws Exception{
		FileEncoder.encodeFile(parser, wordFile, decoder, writer, coder, used, random);
	}

	public void decodeFile(String wordFile) throws Exception{
		fileDecoder.decodeFile(parser, wordFile, decoder, writer);
	}
	
	public CodeBook getCodeBook(){
		return this.coder;
	}
	
	public DecodeBook getDecodeBook(){
		return this.decoder;
	}
	
	public int computeFreq(int count){
		int freq = 0;
		
		if(count < 25){			// first 25 words get 1 third of the numbers
			freq = (MAX_RANGE / 3) / 25;
		}
		else if(count < 100){	// next 75 words gets 17% third of the numbers (half of a third)
			freq = MAX_RANGE / 3 / 2 / 75;
		}
		else if(count < 300){	// next 200 words gets 15% of the numbers
			freq = (int) (MAX_RANGE * 0.15) / 200 ;
		}
		else{					// remainder (600 words) gets 35% of numbers
			freq = (int) (MAX_RANGE * .35) / 600;
		}
		
		return freq;
	}
}
