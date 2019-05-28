package Objects;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullets {
	private Image image;
	private int y = -100;
	private int x = -100;
	private int dx;
	private int dy;
	private int yMove = 0;
	private int xMove = 0;
	
	public Bullets() {
	ImageIcon icon = new ImageIcon("src/Grafika/ball.png");
	setImage(icon.getImage());
	setDx(icon.getIconWidth());
	setDy(icon.getIconHeight());
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
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
	
	public int getyMove() {
		return yMove;
	}
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
	public int getxMove() {
		return xMove;
	}
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}
}
