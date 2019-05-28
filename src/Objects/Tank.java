package Objects;
import java.awt.Image;

import javax.swing.ImageIcon;

import javafx.scene.shape.Rectangle;

public class Tank  {

	private Image tank;
	private int y;
	private int x;
	private int dx;
	private int dy;
	private boolean tankMoveRight = false;
	private boolean tankMoveLeft = false;
	private final int NUMBEROFBULLETS = 10;
	private final int bulletBUF = -100;
	public Bullets bullet[] = new Bullets[NUMBEROFBULLETS];
	public Gun gun = new Gun(-100,-100);

	public Tank(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/czo³g3.png");
		setTank(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
		this.initShots();
		gun.setX(this.x+3);
		gun.setY(this.y-4);
	}
	
	public void initShots() {
		for ( int i=0; i <NUMBEROFBULLETS; i++) {
			bullet[i] = new Bullets();
		}
	}
	public void shoot() {
		for ( int j=0; j <NUMBEROFBULLETS; j++)
		{
			if(bullet[j].getX()== bulletBUF) {
				bullet[j].setyMove(5);
				bullet[j].setY(this.y+this.dy/2-bullet[j].getDy()/2);
				bullet[j].setX(this.x+this.dx/2-bullet[j].getDx()/2);
				break;
			}
		}
		
	}
	
	public int getNUMBEROFBULLETS() {
		return NUMBEROFBULLETS;
	}

	public Image getTank() {
		return tank;
	}
	public void setTank(Image tank) {
		this.tank = tank;
	}
	public int getX() {
		return x;
	}
	public void setX(int value) {
		x = value;
	}
	public int getY() {
		return y;
	}
	public void setY(int value) {
		y = value;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int value) {
		dx = value;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int value) {
		dy = value;
	}
	
	public boolean isTankMoveRight() {
		return tankMoveRight;
	}

	public void setTankMoveRight(boolean tankMoveRight) {
		this.tankMoveRight = tankMoveRight;
	}
	
	public boolean isTankMoveLeft() {
		return tankMoveLeft;
	}

	public void setTankMoveLeft(boolean tankMoveLeft) {
		this.tankMoveLeft = tankMoveLeft;
	}
	
	public void right() {
		x=x+3;
		gun.setX(gun.getX()+3);
	}
	public void left() {
		x=x-3;
		gun.setX(gun.getX()-3);
		

	}
	
}
	