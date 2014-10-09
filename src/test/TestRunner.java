package test;

import gmit.CodeGenerator;

/* 	this class is a test class that show-cases each of the essential methods in this program
 *	it presents the running times for each method and also an overall running time
 */

public class TestRunner {
	public static void main(String [] args){
		CodeGenerator codeGen = new CodeGenerator();

		String dictionary = "comWords.txt";
		String fileToEncode = "war&peace.txt";

		// timers
		long overallTime, loadBookTime, genBookTime, encodeFileTime, decodeFileTime, saveBookTime;

		System.out.println("Ronan Connolly - 11th April 2014");
		System.out.println("Data Structures - Zimmerman Encoder Project");
		System.out.println("===========================================\n");

		System.out.printf("Using the %s dictionary for initial codeBooks words\n", dictionary);
		System.out.printf("Encoding file: %s\n\n", fileToEncode);

		try {
			overallTime = System.nanoTime();

			loadBookTime = System.nanoTime();
			codeGen.loadCodeBooks();
			System.out.printf("Time to load books:\t\t%d seconds\n", (System.nanoTime() - loadBookTime )/ 1000000000);

			genBookTime = System.nanoTime();
			codeGen.generateCodeBooks(dictionary);
			System.out.printf("Time to generate books:\t\t%d seconds\n", (System.nanoTime() - genBookTime )/ 1000000000);

			encodeFileTime = System.nanoTime();
			codeGen.encodeFile(fileToEncode);
			System.out.printf("Time to encode file:\t\t%d seconds\n", (System.nanoTime() - encodeFileTime )/ 1000000000);

			decodeFileTime = System.nanoTime();
			codeGen.decodeFile();
			System.out.printf("Time to decode file:\t\t%d seconds\n", (System.nanoTime() - decodeFileTime )/ 1000000000);

			saveBookTime = System.nanoTime();
			codeGen.saveCodeBooks();
			System.out.printf("Time to save books:\t\t%d seconds\n", (System.nanoTime() - saveBookTime )/ 1000000000);

			System.out.printf("\nOverall Time to encode:\t\t%d seconds\n", (System.nanoTime() - overallTime )/ 1000000000);
		} catch (Exception e) {
			System.out.println("Woops....");
			e.printStackTrace();
		}

	}
}
