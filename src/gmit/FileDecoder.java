package gmit;

/*	this class parser an encoded text file into a List of words (each word is an integer)
 * 	these integers are then iterated through,
 * 	each integer is used as a key in the decodeBook to find its relating words
 * 	this word is then added to another list "decodedWords"
 * 	once complete this new list is sent to the writer
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileDecoder {
	public void decodeFile(FileParser parser, DecodeBook decoder, CodeWriter writer) throws Exception{
		String fileToDecode = "encodedFile.txt";

		Collection<String> words = parser.parseNum(fileToDecode);
		List<String> decodedWords = new ArrayList<String>();
		int wordCount = 0;

		for(String word : words){
			decodedWords.add(decoder.getCode(Integer.parseInt(word)));
			wordCount++;
		}

		writer.saveStr(decodedWords, "decodedFile.txt");
		System.out.printf("\n%d words saved to file \"decodedFile.txt\".\n", wordCount);
	} // decodeFile
}
