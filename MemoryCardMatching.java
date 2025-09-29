package GameProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemoryCardMatching {
	
	static {
		System.out.println("\n======= MEMORY CARD MATCHING GAME =======\n");
		System.out.println("\n-----------------------------------------\n");
		System.out.println("Instructions: \n ->Numbers (0-7) show card positions. \n ->Enter two numbers to flip cards. \n ->If they match, they stay revealed. \n ->Goal: Match all pairs in fewest moves.");
		System.out.println("\n-----------------------------------------\n");
	}
	
	static int moves = 0;
	static int oneTurn = 2;
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		//1. List for storing hidden card values and shuffle them
		ArrayList<Character> hiddenCards = new ArrayList<>();
		hiddenCards.add('A'); hiddenCards.add('A');
		hiddenCards.add('B'); hiddenCards.add('B');
		hiddenCards.add('C'); hiddenCards.add('C');
		hiddenCards.add('D'); hiddenCards.add('D');
		
		Collections.shuffle(hiddenCards);
		
		
		//2. List displayed to the user
		ArrayList<Character> displayedCards = new ArrayList<>(hiddenCards.size());
		displayedCards.add('0'); displayedCards.add('1');
		displayedCards.add('2'); displayedCards.add('3');
		displayedCards.add('4'); displayedCards.add('5');
		displayedCards.add('6'); displayedCards.add('7');
		
		
		while(oneTurn>0) {
			System.out.println(displayedCards);
			moves++;
			System.out.print("\nEnter the numbers of two cards you want to flip: \n");
			byte userChoice1 = userInput.nextByte();
			byte userChoice2 = userInput.nextByte();
			System.out.println();
			Character c1 = hiddenCards.get(userChoice1);
			System.out.println("1st Card: "+c1);
			oneTurn--;
			
			Character c2 = hiddenCards.get(userChoice2);
			System.out.println("2nd Card: "+c2);
			oneTurn--;
			
			if(c1==c2) {
				displayedCards.set(userChoice1, c1);
				displayedCards.set(userChoice2, c2);
				System.out.println(displayedCards);
			}
			else {
				System.out.println("\nUnmatched cards, Try again\n");
			}
			oneTurn =2;
			if(displayedCards.equals(hiddenCards)) {
				oneTurn=0;
				System.out.println("\n---------------------------------\n");
				System.out.println("🎉 Congratulations! You matched all pairs!");
			    System.out.println("Total moves: " + moves);
			    System.out.println("Thanks for playing Memory Match Game!");
			    System.out.println("\n---------------------------------\n");
			}
		};
	}

}
