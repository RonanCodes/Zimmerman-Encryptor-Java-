package gmit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Set;

/*
 * This class takes in a set of integers and a fileName,
 * if the code list is not empty it goes ahead,
 * It then writes each code to a file, 10 codes per line
 */

public class CodeWriter {
	public void saveInt(List<Integer> codes, String file) throws Exception{		// could pass it in a socket stream
		if(codes == null || codes.size() == 0){
			throw new Exception("Yikes....");
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
		// buffered writer is more efficient

		int counter = 1;

		for(Integer i : codes){
			//System.out.println(i);
			out.write(i + "");

			if(counter % 10 == 0){
				out.write("\n");
			}
			else{
				out.write(" ");
			}

			counter++;
		}

		out.flush();
		out.close();
	} // save

	public void saveStr(List<String> codes, String file) throws Exception{		// could pass it in a socket stream
		if(codes == null || codes.size() == 0){
			throw new Exception("Yikes....");
		}
		
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
		// buffered writer is more efficient

		int counter = 1;

		for(String i : codes){

			//System.out.println(i);
			out.write(i + "");

			if(counter % 10 == 0){
				out.write("\n");
			}
			else{
				out.write("\t");
			}

			counter++;
		}

		out.flush();
		out.close();
	} // save
}
