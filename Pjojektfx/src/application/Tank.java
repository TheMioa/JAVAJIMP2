package application;
import java.util.logging.Logger;

import javafx.scene.image.ImageView;

public class Tank  extends ImageView{
	
	public void moveRight(ImageView tank) {
		if(tank.getX()<1000-tank.getFitWidth())
		tank.setX(tank.getX()+3);
	}
	
	public void moveLeft(ImageView tank) {
		if(tank.getX()>0)
		tank.setX(tank.getX()-3);
	}


}
