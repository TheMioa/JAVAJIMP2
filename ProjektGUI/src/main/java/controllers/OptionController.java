package controllers;

import javafx.fxml.FXML;

public class OptionController {

	private MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void backButtonAction( ) {
		mainController.loadMenuScreen();
	}
	
}
