package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 
import javafx.scene.control.TextArea;

//Welcome tab
public class mainTab extends Tab {
	  static TextArea info = new TextArea("Welcome, choose a game to play. \n Press the claim prizes button when you're done playing"); 

   public mainTab() {
	  setText("Welcome");
	  VBox  vb = new VBox();
      Button b1 = new Button ("Guessing Game");
      Button b2 = new Button ("Lottery Game");
      Button b3 = new Button ("Quit");
      Button b4 = new Button ("Claim Prizes");
      Button b5 = new Button ("1 Free token"); 

      vb.getChildren().add (info);
      vb.getChildren().add (b1);  
      vb.getChildren().add (b2);     
      vb.getChildren().add (b4);
      vb.getChildren().add (b5);
      vb.getChildren().add (b3);

      setContent(vb);
      
      b1.setOnAction(e -> changeTab(1));
      b2.setOnAction(e -> changeTab(2));
      b3.setOnAction(e -> Controller.quitGame());
      b4.setOnAction(e -> Controller.addPrizeTab());
      b5.setOnAction(e -> freetokens());
   }
   
   //Adds free tokens for testing
   public void freetokens() {
	   Controller.tokens += 1; 
   }
   
   //Uses button input to change tab
   public void changeTab(int index) {
	   Main.tp.getSelectionModel().select(index); 
   }
   
   public static void setInfo(String text) {
	   info.setText(text); 
   }
}

