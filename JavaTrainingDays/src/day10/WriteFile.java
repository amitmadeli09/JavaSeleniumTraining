package day10;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {

	public static void main(String[] args) {
		
		 String filePath = "C:\\Users\\Gme\\Desktop\\Wipro\\File1.txt";
		 try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			 writer.write("Line 1 : First Line");
			 writer.newLine();
			 writer.write("Line 2 : Second Line");
			 writer.close();
			 System.out.println("File Written Successfully");
		 }catch(IOException e) {
			 System.out.println("Error Writing Files :"+e.getMessage());
		 }
	}

}
