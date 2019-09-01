package application;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class Controller {
	//Class variables
	static int guessesleft = 4; 
	static int wins = 0; 
	static int tokens = 0; 
	static int prizeTabOpen = 0; 

	static void makeguess() {
		Random r = new Random(); 
		//Gets the int guess from the getGuess function
		int guess = BoxPane1.getGuess(); 
		//Target between 1 and 50
		int target = r.nextInt(50) + 1; 
		String text = ""; 
		
		//Target and guess for testing
		System.out.println(target);
		System.out.println(guess);
		//Deincrements the guesses left
		guessesleft -= 1; 
		
		//Checks how many attempts are left, sets and checks if you won, calls setinfo function
		if(guessesleft <= 0) {
			text = "Game over, press reset to try again";
		}
		else if(guess == target) {
			wins += 1;
			if(wins == 5) tokens += 3;
			else tokens += 2;  
			guessesleft = 4; 
			text = "You won! Your streak: " + wins + " \n You have " + tokens + " prize tokens"; 
		}
		else {
			text = "Try again"; 
		}
		BoxPane1.setInfo(target, guessesleft, text);
	}
	
	//Restarts the game, resetting variables
	static void resetGame() {
		guessesleft = 4; 
		wins = 0; 
		tokens = 0; 
		BoxPane1.setInfo("Make a guess");
	}

	//Quits
	static void quitGame() {
		System.exit(0);
	}
	
	//Lottery game, takes the users guess list as an argument 
	public static void lottery(ArrayList<Integer> gl) {
		int correctGuesses = 0; 
		Random r = new Random(); 
		ArrayList<Integer> targets = new ArrayList<Integer>(5); 
		
		//Adds a list of 5 random numbers to the array Targets
		for(int i = 0; i < 5; i++) {
			targets.add(i, r.nextInt(20) + 1);  
		}
		
		//Prints the list for testing
		System.out.println("Targets" + targets);
		
		//Checks if the users guesses and targets match
		for(Integer x : gl) {
			for(Integer y : targets) {
				if(y == x) {
					correctGuesses += 1; 
				}
			}
		}
		
		//Checks how many correct guesses the user got
		Vbox1.setInfo("You guessed " + correctGuesses + " correctly"); 
		if(correctGuesses == 4) {
			tokens += 4;
		}
		else if(correctGuesses == 5) {
			tokens += 5; 
		}
		Vbox1.setInfo(Vbox1.getInfo() + "\n You have " + tokens + " Tokens"); 
	}
	
	//Adds the prize tab of the user has 2 or more tokens
	public static void addPrizeTab() {
		if(tokens > 1 && prizeTabOpen == 0) {
			Main.tp.getTabs().add ( new prizeTab()); 
			prizeTabOpen = 1;  
		}
		else {
			mainTab.setInfo("You havn't collected enough tokens yet");
		}
	}
}
