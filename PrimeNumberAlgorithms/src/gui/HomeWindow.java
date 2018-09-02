package gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeWindow {

	private Button eSieveButton, sSieveButton;
	private VBox mainPane;
	private HBox buttonBox, textBox;
	private GridPane gridPane;
	private TextField numField;
	private Text header;

	public HomeWindow() {
		initialize();
		content();
		properties();
		actionEvents();
	}

	private void initialize() {
		eSieveButton = new Button("Eratosthenes");
		sSieveButton = new Button("Sundaram");
		mainPane = new VBox(10);
		gridPane = new GridPane();
		buttonBox = new HBox(10);
		numField = new TextField();
		header = new Text("\nChoose a method of finding prime numbers");
	}

	private void content() {
		gridPane.add(new Label("Upper Range: "), 0, 0);
		gridPane.add(numField, 1, 0);
		gridPane.add(sSieveButton, 0, 1);
		gridPane.add(eSieveButton, 1, 1);
		mainPane.getChildren().addAll(header, new Separator(), gridPane);
	}

	private void properties() {
		header.setFont(new Font(18));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setAlignment(Pos.CENTER);
		mainPane.setAlignment(Pos.TOP_CENTER);
		eSieveButton.setMaxWidth(200);
		sSieveButton.setMaxWidth(200);
		PNALauncher.getRoot().setCenter(mainPane);
	}

	private void actionEvents() {
		numField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (!"0123456789".contains(keyEvent.getCharacter()))
					keyEvent.consume();
			}
		});
		
		eSieveButton.setOnAction(event -> {
			if (numField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR - Invalid Data Entry");
				alert.setContentText("You must enter an upper range");
				alert.showAndWait();
			}
			else 
				System.out.println("Huzzah!");
		});
		
		sSieveButton.setOnAction(event -> {
			if (numField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR - Invalid Data Entry");
				alert.setContentText("You must enter an upper range");
				alert.showAndWait();
			}
			else 
				System.out.println("Huzzah!");
		});
	}

}
