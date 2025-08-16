package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TextException {

	public static void main(String[] args) {
		File file1 = new File("C:\\Users\\Gme\\Desktop\\Wipro\\HelloWorld.txt");
		try {
			BufferedReader read1 = new BufferedReader(new FileReader(file1));
			String line = read1.readLine();
			
			while(line != null) {
				System.out.println("File Content :"+line);
				line = read1.readLine();
			}
			read1.close();
			
		}catch(FileNotFoundException e){
			System.out.println("File Not Found Error");

		}catch(IOException e) {
			System.out.println("IO Occured in reading the File");
		}finally {
			System.out.println("This is Complete Execution");
		}
		
	}

}
