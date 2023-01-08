/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20F
 * Professor: Piyush Jangam
 * Student ID: 41017324
 * Student Email: laba0038@algonquinlive.com
 * Practical Assessment 1
 */

import java.util.Scanner;
import java.util.Random;

public class Game {
	private String playerName;
	private int player;
	static Scanner input = new Scanner(System.in);
	private Random rand;
	File pdf = new File();
	File docx = new File();
	File xlsx = new File();
	File java = new File();
	
	public void Game() {
		input = new Scanner(System.in);
		rand = new Random();
		player = 1;
		int num;
		
		System.out.println("Welcome to the Game!");
		System.out.println("Please pick a file type then select how many files you wish to remove.");
		System.out.print("Enter your name: "); //user input name
		playerName = input.nextLine();
		System.out.println();
		
		do {
			num = rand.nextInt(9);//generate random number below 9
		} while (num<3);//randomize another number if not above 3
				
		if (num%2==0) {//increase random number if even, to make odd
			num++;
		}

		pdf.File(num);//initialize files based on random number
		docx.File(num + 2);
		xlsx.File(num + 4);
		java.File(num + 6);		
	}
	
	public void playGame() {
		File selectedFile = null;
		int numFilesToRemove = 0;
		int fileType;

		System.out.println("Current game status:");
		displayGame();//display game status
				
		if (player==1) {//if end user's turn
			do {
				do { 
					System.out.println(playerName + ", select a file type:");
					System.out.println("Press 1 for PDF");
					System.out.println("Press 2 for DOCX");
					System.out.println("Press 3 for XLSX");
					System.out.println("Press 4 for JAVA");
					System.out.print("Your selection: ");
					fileType = input.nextInt();
				
					if(fileType==1) {//initialize File object based on user input
						selectedFile = pdf;
					} else if(fileType==2) {
						selectedFile = docx;
					} else if(fileType==3) {
						selectedFile = xlsx;
					} else if(fileType==4) {
						selectedFile = java;
					} else {
						System.out.println("Sorry, that is not a valid response. Choose again.");
						System.out.println();
					}
				}while (selectedFile==null);
			} while (selectedFile.isEmpty()==true);
			
			System.out.println();
			System.out.print("Enter number of files to remove: ");	
			numFilesToRemove = input.nextInt();	
			System.out.println();
				
		} else if (player==2){//if computer's turn
			System.out.print("Computer, select a file type: "); //get random input from computer
			int randFileType;
			
			do {
				randFileType = rand.nextInt(3);
				if (randFileType==0) {
					selectedFile = pdf;
				} else if(randFileType==1) {
					selectedFile = docx;
				} else if (randFileType==2) {
					selectedFile = xlsx;
				} else selectedFile = java;
			} while (selectedFile.isEmpty()==true);
			
			System.out.print(randFileType+1);
			System.out.println();
			
			System.out.print("Computer, enter a number of files to remove: ");
			if(selectedFile.getNumFiles()==1) {
				numFilesToRemove = 1;
			} else {
				numFilesToRemove = rand.nextInt(selectedFile.getNumFiles()/2)+1;
			}
		System.out.println(numFilesToRemove);//output number of files to remove
		System.out.println();
	    }
		boolean itWorked = selectedFile.removeFiles(numFilesToRemove);//if removing files was successful, toggle player
		if (itWorked == true) {
			if(player ==1) {
				player =2;
			} else if(player ==2) {
				player = 1;
			}
		}
	}
	
	public void displayGame() {
		System.out.println("PDF   DOCX   XLSX   JAVA");
		System.out.println(pdf.getNumFiles()+"      "+docx.getNumFiles()+"      "+xlsx.getNumFiles()+"     "+java.getNumFiles());
		System.out.println();
	}
	
	public int determineWinner() {
		int winner = 0;
		int allFiles = pdf.getNumFiles() + docx.getNumFiles() + xlsx.getNumFiles() + java.getNumFiles();
		
		if (allFiles == 0) {//check if all files are empty
			winner = player;
		}
		
		if (winner == 1) {//output winner's name
			System.out.println(playerName + " wins!");
		} else if (winner == 2) {
			System.out.println("Computer wins!");
		}
		return winner;
	}

	
	public static void main(String[] args) {
		Game game = new Game();//create Game object
		game.Game();
		do {
			game.playGame();
		} while (game.determineWinner()==0);//while no winner is determined
		
		System.out.println("Thanks for playing!");
	}


}
