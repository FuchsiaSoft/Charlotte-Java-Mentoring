/**
 * 
 */
package org.test.resultsgenerator;

import java.util.Scanner;

/**
 * @author Chris
 *
 */
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Requirements specified maximum input of 100 so need for more
		String[] homeTeams 	= new String[100];
		String[] awayTeams 	= new String[100];
		int[] homeScores 	= new int[100];
		int[] awayScores 	= new int[100];
		
		int totalMatches 	= 0;
		int totalHomeScores = 0;
		int totalAwayScores = 0;
		int totalDraws 		= 0;
		int highestHome 	= 0;
		
		int nextIndex = 0; //to synchronise the arrays and keep track of where we are adding to
		
		Scanner scanner = new Scanner("Leeds : Manchester : 1 : 2");
		scanner.useDelimiter(" : ");
		scanner.next();
		scanner.next();
		scanner.next();
		scanner.next();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter \"manual\" for manual input mode, or \"file\" for file input mode:");
		String mode = scan.nextLine();
		
		if (mode.equalsIgnoreCase("manual")) {
			
			System.out.println("Please enter in the format 'Home team : Away team : Home score : Away score'");
			scan = new Scanner(System.in);
			
			boolean programStop = false;
			
			while (!programStop) {
				
				String line = scan.nextLine();
				
				if (line.equalsIgnoreCase("stop")) {
					programStop = true;
					break; //quit processing if told to stop
				}
				
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(" : ");
				
				homeTeams[nextIndex] = lineScanner.next();
				awayTeams[nextIndex] = lineScanner.next();
				homeScores[nextIndex] = lineScanner.nextInt();
				awayScores[nextIndex] = lineScanner.nextInt();
				
				totalHomeScores += homeScores[nextIndex];
				totalAwayScores += awayScores[nextIndex];
				
				if (homeScores[nextIndex] == awayScores[nextIndex]) {
					totalDraws++;
				}
				
				if(homeScores[nextIndex] > highestHome) {
					highestHome = homeScores[nextIndex];
				}
				
				nextIndex++; //advance our marker
				totalMatches++;
				
				lineScanner.close();	
			}
			
			for (int i = 0; i < nextIndex; i++) {
				System.out.println(homeTeams[i] + " [" + homeScores[i] + "] | " + awayTeams[i] + " [" + awayScores[i] + "]");
			}
			
			System.out.println("Total number of matches played: 	" + totalMatches);
			System.out.println("Total home scores of all matches: 	" + totalHomeScores);
			System.out.println("Total away scores of all matches: 	" + totalAwayScores);
			System.out.println("Total number of draw scores:	 	" + totalDraws);
			System.out.println("Highest home score:			" + highestHome);
			
		
			
			
		} else if (mode.equalsIgnoreCase("file")) {
			
			//do file input mode
			
		} else {
			
			System.out.println("Please run program again and enter either manual or file");
			
		}
		

	}
	

}
