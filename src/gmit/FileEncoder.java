package gmit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FileEncoder {
	public static void encodeFile(FileParser parser, String wordFile, DecodeBook decoder, CodeWriter writer, CodeBook coder, Set<Integer> used, Random random) throws Exception {
		Collection<String> words = parser.parse(wordFile);
		List<Integer> encodedWords = new ArrayList<Integer>();

		int wordAdd=0, wordNew=0, numCount=0;
		
		for(String word : words){
			Set<Integer> codes = coder.getCodes(word);

			if(codes == null){ // if word is not in codeBook then add it (6 digits for new word, 30 different codes to each new word)
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
			}

			if(codes != null){	// if I have the word in the code book, take a random int from it, then add encoded word to encodedFileList
				Object[] codeArray = codes.toArray();
				int size = codeArray.length;
				int randItem = new Random().nextInt(size);
				int randCode = (Integer)codeArray[randItem];

				encodedWords.add(randCode);
				//decoder.addCode(randCode, word);
				//System.out.printf("Code: %d\n", randCode);

				wordAdd++;
			}
		} // for

		writer.saveInt(encodedWords, "encodedFile.txt");

		System.out.printf("\nWords Added to file: %d\nNew words added to codeBooks: %d\nNew Numbers added to codeBooks: %d\n",wordAdd, wordNew, numCount);		
	}
}
