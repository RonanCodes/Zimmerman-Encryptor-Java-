Ronan Connolly - 11th April 2014
Data Structures - Zimmerman Encoder Project
===========================================

Main Features/Methods:

CodeBook:
 * This class contains the codeBook map and has some very important basic methods
 * This class is also Serializable which means it can be written as an object to be loaded later

CodeGenerator:
 * This class creates all the other classes and links them together.
 * The testRunner class will use this class to process the data

CodeLoader:
 * This class is responsible for reading(de-serializing/loading) the codebook/decodebook from a file to an object

CodeSaver:
 * This class is responsible for writing(Serializing) the codeBook/decodeBook(objects) to a file

CodeWriter:
 * This class takes in a set of integers and a fileName,
 * If the code list is not empty it goes ahead,
 * It then writes each code to a file, 10 codes per line

DecodeBook:
 * This class contains the decodeBook map and has some very important basic methods
 * This class is also Serializable which means it can be written as an object to be loaded later

FileDecoder:
 *	This class parser an encoded text file into a List of words (each word is an integer)
 * 	these integers are then iterated through,
 * 	each integer is used as a key in the decodeBook to find its relating words
 * 	this word is then added to another list "decodedWords"
 * 	once complete this new list is sent to the writer

FileEncoder:
 *	This class takes in a list of parsed words (lower case letters)
 * 	iterates through each word
 * 	if word is not in the codeBook then it adds that word along with a list of randomly generated integers
 * 	an integer is randomly selected from said integer list
 * 	this integer is added to a new "encodedWords" list where it can then be send to the writer
 
FileParser:
 * This class takes in a file, reads each line, splits it into an array of strings, converts each to lower case,
 * removes punctuation and adds it to a collection.
 * It then returns this collection back to the calling method.

TestRunner:
 * 	This class is a test class that show-cases each of the essential methods in this program
 *	it presents the running times for each method and also an overall running time

=======================================

Instructions for running the program:
 * You can call the load codebooks method if you are loading from a serialized codebook object
 * You need to call the Generate Codebook method to create the initial codebooks
 * You then call the encode method to encode the file
 * You call the decode method to decode the file
 * You call the save codebook method to serialize the codebooks
 
 * The test runner method goes through each of these methods.
 * You can use these methods as you like to create you own program with a switch, do while to have a menu where you choose what you want to do

