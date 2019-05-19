package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

import static java.util.logging.Level.INFO;


public class FXMLDocumentController implements Initializable, EventHandler<KeyEvent> {
    public FXMLDocumentController() {
    }

    Tank player1 = new Tank();
    Tank player2 = new Tank();
    @FXML
    private Button startButton;
    @FXML
    private Button exitButton;

    @FXML
    private Pane pointsPane;
    @FXML
    private Pane leftPlayerPoints;
    @FXML
    private Label numberOfPlayerPoints;
    @FXML
    private Label textNumberOfPlayerPoints;

    @FXML
    private Pane rightPlayerPoints;
    @FXML
    private Label numberOfPlayerPoints2;
    @FXML
    private Label textNumberOfPlayerPoints2;

    @FXML
    private Pane buttonsPane;
    @FXML
    private Button saveButton;
    @FXML
    private Button exitButton2;

    @FXML
    ImageView tank1;
    @FXML
    ImageView tank2;
    @FXML
    ImageView redBlock;


    @FXML
    private void startButtonAction(ActionEvent event) {
        textNumberOfPlayerPoints.setText("Liczba punktów pierwszego gracza:");
        numberOfPlayerPoints.setText("0");
        textNumberOfPlayerPoints2.setText("Liczba punktów drugiego gracza:");
        numberOfPlayerPoints2.setText("0");

        startButton.setVisible(false);
        exitButton.setVisible(false);
        saveButton.setVisible(true);
        exitButton2.setVisible(true);
        tank1.setVisible(true);
        tank2.setVisible(true);
        redBlock.setVisible(true);

        tank1.setX(tank1.getX() + 300);
        tank2.setX(tank2.getX() + 700);
        redBlock.setX(tank1.getX() + 40);
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        for (int i = 0; i < 23; i++) {
            if (tank1.getX() < tank2.getX() - tank2.getFitWidth())
                player1.moveRight(tank1);
        }
    }


    @FXML
    private void exitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void exitButtonAction2(ActionEvent event) {
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveButton.setVisible(false);
        exitButton2.setVisible(false);
        tank1.setVisible(false);
        tank2.setVisible(false);
        redBlock.setVisible(false);


    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
            {if (tank1.getX() < tank2.getX() - tank2.getFitWidth())

                    player1.moveRight(tank1);}

                break;

            case LEFT:

            {for (int i = 0; i < 23; i++)
                    player1.moveLeft(tank1);}

                break;

        }
    }
}