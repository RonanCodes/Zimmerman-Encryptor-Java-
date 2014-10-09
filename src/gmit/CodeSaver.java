package gmit;

// this class is responsible for writing(Serializing) the codeBook/decodeBook(objects) to a file

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CodeSaver {
	
	// O(n) - Must iterate through each element
	public void saveCodeBook(CodeBook coder) throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CodeBookSer"));
		out.writeObject(coder);
		out.close();
	}
	
	// O(n) - Must iterate through each element
	public void saveDecodeBook(DecodeBook decoder) throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DecodeBookSer"));
		out.writeObject(decoder);
		out.close();		
	}
}
