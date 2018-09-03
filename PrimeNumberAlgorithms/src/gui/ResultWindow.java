package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ResultWindow {

	private VBox mainPane;
	private Text values;
	private ScrollPane scrollPane;
	private Text header;
	private String algorithmName;
	private String results;

	public ResultWindow(String data, String name) {
		results = data;
		algorithmName = name;
		initialize();
		content();
		properties();
	}

	public void initialize() {
		mainPane = new VBox(10);
		scrollPane = new ScrollPane();
		header = new Text("Results of the " + algorithmName + " algorithm");
		values = new Text(results);
	}

	public void content() {
		mainPane.getChildren().addAll(header, new Separator(), scrollPane);
	}

	public void properties() {
		mainPane.setAlignment(Pos.TOP_CENTER);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		scrollPane.setContent(values);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(new Scene(mainPane, 650, 350));
		stage.setTitle("Algorithm Results");
		stage.show();
		stage.setResizable(false);
		header.setFont(new Font(24));
		values.setFont(new Font(14));
	}

}
