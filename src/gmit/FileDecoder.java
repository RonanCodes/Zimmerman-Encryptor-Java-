package gmit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileDecoder {
	public void decodeFile(FileParser parser, String wordFile, DecodeBook decoder, CodeWriter writer) throws Exception{
		Collection<String> words = parser.parseNum(wordFile);
		List<String> decodedWords = new ArrayList<String>();

		for(String word : words){
			decodedWords.add(decoder.getCode(Integer.parseInt(word)));
		}

		writer.saveStr(decodedWords, "decodedFile.txt");
	}
}
