package gmit;

public class TestRunner {
	public static void main(String [] args){
		CodeGenerator codeGen = new CodeGenerator();
		
		String dictionary = "comWords.txt";
		String fileToEncode = "testFile5.txt";
		String fileToDecode = "encodedFile.txt";
		
		try {
			long timer = System.nanoTime();
			//codeGen.loadCodeBook();
			codeGen.generateCodeBooks(dictionary);
			codeGen.encodeFile(fileToEncode);
			codeGen.decodeFile(fileToDecode);
			//codeGen.saveCodeBook();
			System.out.printf("\nTime to encode:\t\t%d seconds\n", (System.nanoTime() - timer )/ 1000000000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
