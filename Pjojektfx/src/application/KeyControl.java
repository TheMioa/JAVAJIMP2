package application;

import java.awt.*;
import java.util.List;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;



public class KeyControl implements EventHandler<KeyEvent> {

    private static final Logger LOG = Logger.getLogger(KeyControl.class.getName());
    private Tank tankLeft;
    private Tank tankRight;

    public KeyControl(Tank tankLeft, Tank tankRight) {
        this.tankLeft = tankLeft;
        this.tankRight = tankRight;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                if(tankLeft.getX()<tankRight.getX()-tankRight.getFitWidth())
                    for( int i=0;i<23;i++) {
                        tankLeft.moveRight(tankLeft);
                    }
                break;

            case LEFT:
                if(tankLeft.getX()>tankLeft.getFitWidth())
                    for( int i=0;i<23;i++) {
                        tankLeft.moveLeft(tankLeft);
                    }
                break;
            default:
                LOG.log(INFO, "Handle unsupported key: {0}", event.getCode());
        }
    }
}
