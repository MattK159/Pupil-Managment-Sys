package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 
import javafx.scene.control.Button;
import java.util.ArrayList; 
import java.io.File; 
import java.util.Scanner;

public class prizeTab extends Tab {

	ArrayList<String> prizeList = new ArrayList<String>(30); 
	ArrayList<String[]> prizes = new ArrayList<String[]>(30); 

	TextArea i1 = new TextArea(""); 

	VBox  vb = new VBox();
	TextField p1 = new TextField ("");
	TextField p2 = new TextField ("");
	TextField p3 = new TextField ("");
	TextField p4 = new TextField ("");
	TextField p5 = new TextField ("");
	Button b1 = new Button("Prize 1");
	Button b2 = new Button("Prize 2"); 
	Button b3 = new Button("Prize 3"); 
	Button b4 = new Button("Prize 4"); 
	Button b5 = new Button("Prize 5"); 

	public void getInputFromFile() {
		int count = 0; 
		//Gets input from prizes.txt, checks for errors finding the file
		try {
			File file = new File("./src/prizes.txt"); 
			Scanner sc = new Scanner(file); 
			//Reads through each line of the file
			//Each line is added to the array prizeslist
			while(sc.hasNextLine()) {
				String line = sc.nextLine(); 
				System.out.println(line);
				line.split(",");
				prizeList.add(line); 
			}
			sc.close(); 
		}
		catch(Exception FileNotFound ) {
			File directory = new File("./src/");
			System.out.println(directory.getAbsolutePath());
			System.out.println("Unable to find prizes.txt in directory"); 
		}
		//Splits the prizeslist strings by comma, getting the individual varialbes
		prizes.add(prizeList.get(0).split(",")); 
		prizes.add(prizeList.get(1).split(",")); 
		prizes.add(prizeList.get(2).split(",")); 
		prizes.add(prizeList.get(3).split(",")); 
		prizes.add(prizeList.get(4).split(",")); 
		//Choosing which items from the prizes list to display
		for(String[] prize : prizes) {
			//Converts the weight of the prize which is held in [0] of the array prizes
			if(Integer.parseInt(prize[0]) == Controller.tokens) {
				count += 1; 
				//Don't display the prize weight
				switch(count) {
				case 1: 
					p1.setText(prize[1] + " " + prize[2] + " " + prize[3]);
					vb.getChildren().add (b1);
					b1.setText("Prize " + prize[1]);
					break;
				case 2: 
					p2.setText(prize[1] + " " + prize[2] + " " + prize[3]);
					vb.getChildren().add (b2);
					b2.setText("Prize " + prize[1]);
					break; 
				case 3: 
					p3.setText(prize[1] + " " + prize[2] + " " + prize[3]);
					vb.getChildren().add (b3);
					b3.setText("Prize " + prize[1]);
					break; 
				case 4: 
					p4.setText(prize[1] + " " + prize[2] + " " + prize[3]);
					vb.getChildren().add (b4);
					b4.setText("Prize " + prize[1]);
					break; 
				case 5: 
					p5.setText(prize[1] + " " + prize[2] + " " + prize[3]);
					vb.getChildren().add (b5);
					b5.setText("Prize " + prize[1]);
					break; 
				}
			}
		}
	}

	public prizeTab() {
		setText("Prizes");
		TextField h1 = new TextField("ID | Amount | Type"); 

		vb.getChildren().add(h1);
		vb.getChildren().add (p1);  
		vb.getChildren().add (p2);
		vb.getChildren().add (p3);
		vb.getChildren().add (p4);
		vb.getChildren().add (p5);


		setContent(vb);
		getInputFromFile(); 

		System.out.println(prizeList);

		b1.setOnAction(e -> claimPrize(1));
		b2.setOnAction(e -> claimPrize(2));
		b3.setOnAction(e -> claimPrize(3));
		b4.setOnAction(e -> claimPrize(4));
		b5.setOnAction(e -> claimPrize(5));
	}

	public void claimPrize(int id) {
		vb.getChildren().remove(b1);
		vb.getChildren().remove(b2);
		vb.getChildren().remove(b3);
		vb.getChildren().remove(b4);
		vb.getChildren().remove(b5);
		
		vb.getChildren().add(i1); 
		switch(id) {
		case 1:
			i1.setText("You have claimed prize " + id);
			break; 
		case 2:
			i1.setText("You have claimed prize " + id);
			break; 
		case 3:
			i1.setText("You have claimed prize " + id);
			break; 
		case 4:
			i1.setText("You have claimed prize " + id);
			break; 
		case 5:
			i1.setText("You have claimed prize " + id);
			break; 
		}
	}
}
