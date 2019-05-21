package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
	@FXML
	public Label textLeftPlayerPoints;
	
	@FXML
	public Label leftPlayerPoints;
	
	@FXML
	public Label textRightPlayerPoints;
	
	@FXML
	public Label rightPlayerPoints;
	
	@FXML
	public void exitButtonAction() {
		System.exit(0);
	}
	
}
