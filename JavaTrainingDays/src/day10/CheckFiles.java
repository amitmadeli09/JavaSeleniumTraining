package day10;

import java.io.File;

public class CheckFiles {

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\Gme\\Desktop\\Wipro\\File2.txt";
		
		File file = new File(filePath);
		
		if(file.exists()) {
			System.out.println("File Exists");
		}else {
			System.out.println("File Unavailable");
		}
		
	}

}
