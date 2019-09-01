package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.Random;

public class MyEventHandler implements EventHandler {
	
	Random r = new Random(); 
	
	private BoxPane1 strguess;
	private int target = r.nextInt(50) + 1; 
	private int guessesleft = 4; 
	
	public MyEventHandler(BoxPane1 guess) {
		this.strguess = guess; 
		
	}
	
	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		System.out.println("Event");
		System.out.println(target);
		guessesleft -= 1; 
	}
	
	

}
