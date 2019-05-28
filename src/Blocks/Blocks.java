package Blocks;

import java.awt.Image;

public class Blocks  {
	
	private Image block;
	private int y;
	private int x;
	private int dx;
	private int dy;
	private int points;
	private int hp;

	public int getPoints() {
		return points;
	}
	public void setPoints(int value) {
		points = value;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int value) {
		hp = value;
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
	public Image getBlock() {
		return block;
	}
	public void setBlock(Image block) {
		this.block = block;
	}
	
}
