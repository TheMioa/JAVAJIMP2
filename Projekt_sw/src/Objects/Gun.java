package Objects;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Gun {
	private Image image;
	private int y;
	private int x;
	private int dx;
	private int dy;
	public Gun(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/wie¿a.png");
		setTank(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
	}
	
	
	public Image getImage() {
		return image;
	}
	public void setTank(Image image) {
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
}
