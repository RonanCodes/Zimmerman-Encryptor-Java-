package gmit;

/*	this class takes in a list of parsed words (lower case letters)
 * 	iterates through each word
 * 	if word is not in the codeBook then it adds that word along with a list of randomly generated integers
 * 	an integer is randomly selected from said integer list
 * 	this integer is added to a new "encodedWords" list where it can then be send to the writer
 */	

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FileEncoder {
	// O(N^2) - must iterate through each element, possibly O(N^3) if many unique numbers are taken
	public static void encodeFile(FileParser parser, String wordFile, DecodeBook decoder, CodeWriter writer, CodeBook coder, Set<Integer> used, Random random) throws Exception {
		Collection<String> words = parser.parseStr(wordFile);
		List<Integer> encodedWords = new ArrayList<Integer>();

		int wordAdd, wordNew, numCount;
		wordAdd = wordNew = numCount = 0;

		for(String word : words){
			List<Integer> codes = coder.getCodes(word);

			// if word is not in codeBook then add it (6 digits for new word, 30 different codes to each new word)
			if(codes == null){ 
				int next = 0;
				for(int i = 0; i < 30; i++){
					boolean unique;

					do{
						next = random.nextInt(1000000 - 100000) + 100000; // make sure it's 6 digits
						unique = used.add(next);
					}while(unique == false);

					numCount++;
					coder.addCode(word, next);
					decoder.addCode(next, word);

				} // for
				wordNew++;

				codes = coder.getCodes(word);				
			} // for

			// if I have the word in the code book, take a random int from it, then add encoded word to encodedFileList
			if(codes != null){	
				Object[] codeArray = codes.toArray();
				int size = codeArray.length;
				int randItem = new Random().nextInt(size);
				int randCode = (Integer)codeArray[randItem];

				encodedWords.add(randCode);

				wordAdd++;
			} // if
		} // for

		writer.saveInt(encodedWords, "encodedFile.txt");

		System.out.printf("\nWords Added to file: %d\nNew words added to codeBooks: %d\nNew Numbers added to codeBooks: %d\n",wordAdd, wordNew, numCount);		
	} // encodeFile
}
