package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuController {

	private MainController mainController;
	
	@FXML
	private Pane menuPane;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	public void startButtonAction() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/GameScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainController.setScreen(pane);
		
	}
	
	@FXML
	public void optionButtonAction( ) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/OptionScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OptionController optionController = loader.getController();
		optionController.setMainController(mainController);
		mainController.setScreen(pane);
	}
	
	@FXML
	public void exitButtonAction() {
		System.exit(0);
	}
	
	
}
