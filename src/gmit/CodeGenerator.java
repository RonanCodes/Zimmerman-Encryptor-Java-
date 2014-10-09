package gmit;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * This class creates all the other classes and links them together.
 * The testRunner class will use this class to process the data
 */

public class CodeGenerator {
	private CodeBook coder = new CodeBook(); // we can serialize this object
	private DecodeBook decoder = new DecodeBook(); // we can serialize this object
	private FileParser parser = new FileParser();
	private CodeWriter writer = new CodeWriter();
	private FileDecoder fileDecoder = new FileDecoder();
	private CodeSaver saver = new CodeSaver();
	private CodeLoader loader = new CodeLoader();

	private Random random = new Random(); // seeds from time automatically (uses System.currtime.millis)
	private static final int MAX_RANGE = 75000;
	private Set<Integer> used = new HashSet<Integer>();
	private int numCount;

	// the following method generates the initial 900 word codeBook, and the initial 75000 number decodeBook
	// more words/numbers can be added to the codeBooks when reading in a file
	
	// O(N^2) possibly O(N^3) if all the random numbers were being used up, unlikely
	public void generateCodeBooks(String wordFile) throws Exception{
		Collection<String> words = parser.parseStr(wordFile); // now we have a collection of words

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
	} // generateCodeBooks

	// O(N^2) - must iterate through each element, possibly O(N^3) if many unique numbers are taken
	public void encodeFile(String wordFile) throws Exception{
		FileEncoder.encodeFile(parser, wordFile, decoder, writer, coder, used, random);
	}

	// O(N) - must iterate through each element
	public void decodeFile() throws Exception{
		fileDecoder.decodeFile(parser, decoder, writer);
	}

	// Average O(1), Maximum O(n)
	public CodeBook getCodeBook(){
		return this.coder;
	}
	
	// Average O(1), Maximum O(n)
	public DecodeBook getDecodeBook(){
		return this.decoder;
	}

	// O(1) - constant/ linear time (no looping/iterations)
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
	} // computeFreq

	// O(n) - Must iterate through each element
	public void saveCodeBooks(){
		try {
			saver.saveCodeBook(coder);
			System.out.println("\nCodeBook saved successfully.");
		} catch (Exception e) {
			System.out.println("Could not save CodeBook, file not found.");
		}

		try {
			saver.saveDecodeBook(decoder);
			System.out.println("DecodeBook saved successfully.");
		} catch (Exception e) {
			System.out.println("Could not save DecodeBook, file not found.\n");
		}
	} // saveCodeBooks

	// O(n) - Must iterate through each element
	public void loadCodeBooks(){
		try {
			coder = loader.loadCodeBook();
			System.out.println("CodeBook loaded successfully.");
		} catch (Exception e) {
			System.out.println("Could not load CodeBook, file not found.");
		}

		try {
			decoder = loader.loadDecodeBook();
			System.out.println("DecodeBook loaded successfully.");
		} catch (Exception e) {
			System.out.println("Could not load DecodeBook, file not found.");
		}
	} // loadCodeBooks
}