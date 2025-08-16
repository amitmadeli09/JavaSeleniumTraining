package day11;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterProbelm {

	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("C:\\Users\\Gme\\Desktop\\Wipro\\File4.txt");
			
			writer.write("Hello World !\n");
			writer.write("My Name is Amit\n");
			
			writer.close();
			
			System.out.println("Data written to file successfully");
		}catch(IOException e) {
			System.out.println("An Error Occured in writing the files");
			e.printStackTrace();
		}
	}

}
