package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PNALauncher extends Application {
	
	private static Stage stage;
	private static BorderPane root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		root = new BorderPane();
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.setTitle("Prime Number Algorithms");
		primaryStage.setResizable(false);
		primaryStage.show();
		new HomeWindow();
	}

	public static Stage getStage() {
		return stage;
	}

	public static BorderPane getRoot() {
		return root;
	}

}
