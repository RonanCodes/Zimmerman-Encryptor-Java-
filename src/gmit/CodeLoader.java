package gmit;

//	this class is responsible for reading(de-serializing/loading) the codebook/decodebook from a file to an object

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CodeLoader {
	// O(n) - Must iterate through each element
	public CodeBook loadCodeBook() throws ClassNotFoundException, IOException{
		@SuppressWarnings("resource")
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream("CodeBookSer"));
		CodeBook coder = (CodeBook) reader.readObject();

		return coder;
	}
	
	// O(n) - Must iterate through each element
	public DecodeBook loadDecodeBook() throws ClassNotFoundException, IOException{
		@SuppressWarnings("resource")
		ObjectInputStream reader = new ObjectInputStream(new FileInputStream("DecodeBookSer"));
		DecodeBook decoder = (DecodeBook) reader.readObject();

		return decoder;
	}
}

