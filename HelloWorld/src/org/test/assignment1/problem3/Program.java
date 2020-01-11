package org.test.assignment1.problem3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		File file = new File("C:\\TestFiles\\input.txt");
		
		try {
			Scanner scan = new Scanner(file);
			
			//captures whitespace of one or more characters
			scan.useDelimiter("\\s+");
			
			System.out.println("Output:");
			System.out.println("=======");
			
			//.hasNextInt() checks whether there is an int remaining
			//to be read without advancing the scanner position
			while (scan.hasNextInt()) {
				
				System.out.println(scan.nextInt());
				
			}
			
			//scanner must be disposed of
			scan.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
