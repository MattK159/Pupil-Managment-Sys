package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//Matthew Keating R00154623
public class Main extends Application {
	//Public variable to access the tabpane
	public static TabPane tp = new TabPane();
	@Override
	public void start(Stage primaryStage) {
		try {
			//Setting up the application window
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			
			//Adding tabs to the window
			tp.getTabs().add ( new mainTab()); 
			tp.getTabs().add ( new BoxPane1());
			tp.getTabs().add ( new Vbox1()); 
			mainPane.setCenter(tp);

			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}







