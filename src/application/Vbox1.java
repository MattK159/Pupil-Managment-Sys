package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 
import javafx.scene.control.Button;
import java.util.ArrayList; 

public class Vbox1 extends Tab {
	//public textbox for storing information
	static TextArea i1 = new TextArea("Enter 5 guesses between 1 and 20 \n 4 Correct = 4* Prize \n 5 Correct = 5* Prize"); 

	public Vbox1() {
		setText("Lottery");
		VBox  vb = new VBox();
		TextField n1 = new TextField ("Number 1");
		TextField n2 = new TextField ("Number 2");
		TextField n3 = new TextField ("Number 3");
		TextField n4 = new TextField ("Number 4");
		TextField n5 = new TextField ("Number 5");

		Button b1 = new Button ("Submit entries"); 

		vb.getChildren().add (n1);  
		vb.getChildren().add (n2);
		vb.getChildren().add (n3);
		vb.getChildren().add (n4);
		vb.getChildren().add (n5);
		vb.getChildren().add (b1);
		vb.getChildren().add (i1);


		setContent(vb);
		//Calls convertNums function, passing the 5 user entered numbers
		b1.setOnAction(e -> convertNums(n1,n2,n3,n4,n5));
	}

	public void convertNums(TextField n1, TextField n2, TextField n3, TextField n4, TextField n5) {
		ArrayList<TextField>tempList = new ArrayList<TextField>(6); 
		ArrayList<Integer> userGuesses = new ArrayList<Integer>(6); 
		
		//Coverts the user entered strings to integers and checks for any errors
		tempList.add(n1); 
		tempList.add(n2); 
		tempList.add(n3); 
		tempList.add(n4); 
		tempList.add(n5); 

		for (TextField n : tempList) {
			try {
				int x = Integer.parseInt(n.getText()); 
				userGuesses.add(x); 
			}
			catch(Exception NumberFormatException) {
				System.out.println("Error");
				setInfo("Please enter 5 numbers \n " + n.getText() + " is not a valid input"); 
				
			}
		}
		//Calls the guesses function in the controller class
		Controller.lottery(userGuesses);
	}
	
	//Function to update text in the info box
	public static void setInfo(String s) {
		i1.setText(s);
	}
	public static String getInfo() {
		return i1.getText(); 
	}
}


