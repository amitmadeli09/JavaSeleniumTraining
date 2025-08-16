package day12;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("C:\\Users\\Gme\\Desktop\\Wipro\\New folder\\File.txt");
			writer.write("This is a new example");
			System.out.println("File Written Successfully");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
