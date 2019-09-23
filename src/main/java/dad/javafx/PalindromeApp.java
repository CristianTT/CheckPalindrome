package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PalindromeApp extends Application {

	private Label palindromeLabel;
	private TextField palindromeField;
	private Button palindromeButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		palindromeLabel = new Label();

		palindromeField = new TextField();
		palindromeField.setPromptText("Introduce una palabra");
		palindromeField.setMaxWidth(150);

		palindromeButton = new Button("Calcular");
		palindromeButton.setDefaultButton(true);

		palindromeButton.setOnAction(e -> onCheckPalindromeButtonAction(e));

		VBox root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(palindromeField, palindromeButton, palindromeLabel);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Comprobador de palíndromos");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onCheckPalindromeButtonAction(ActionEvent e) {
		String word = palindromeField.getText();
		String reverse = "";
		for (char c : word.toCharArray()) {
			reverse = c + reverse;
		}
		if (reverse.equals(word)) {
			palindromeLabel.setText(word + " es un palíndromo");
			palindromeLabel.setStyle("-fx-text-fill: green; -fx-font: 20 sans-serif;");
		} else {
			palindromeLabel.setText(word + " no es un palíndromo");
			palindromeLabel.setStyle("-fx-text-fill: red; -fx-font: 20 sans-serif;");
		}
		palindromeField.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
