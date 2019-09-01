package application;



import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 
import javafx.scene.control.TextArea;

public class BoxPane1 extends Tab {
	//Public variables to access the guess and info fields
    static TextField guess = new TextField(); 
    static TextArea info = new TextArea("Make a guess between 1 and 50"); 

   public BoxPane1() {
	  setText("Guessing Game");
	  VBox  vb = new VBox();
      Button b1 = new Button ("Guess");
      Button b2 = new Button ("Reset");
      Button b3 = new Button ("Quit");

      vb.getChildren().add (b1);  
      vb.getChildren().add(guess);
      vb.getChildren().addAll(info); 
      vb.getChildren().add (b2);     
      vb.getChildren().add (b3);

      setContent(vb);
      
      //Onclick actions for each button, calling functions in the controller object
      b1.setOnAction(e -> Controller.makeguess());
      b2.setOnAction(e -> Controller.resetGame());
      b3.setOnAction(e -> Controller.quitGame());
   }
   
   //Gets the string guess entered by the user and returns it as an int
   public static int  getGuess() {
	   String strguess = guess.getText();
	   int guess = Integer.parseInt(strguess);
	   return guess; 
   }
   
   //Set info box to string, checks if the game is over
   public static void setInfo(int target, int guessesleft, String text) {
	   if(guessesleft > 0) info.setText("Target was: " + target + " Attempts left: " + guessesleft + " " + text);
	   else info.setText(text); 
   }
   
   public static void setInfo(String text) {
	   info.setText(text); 
   }
}

