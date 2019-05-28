package Blocks;

import javax.swing.ImageIcon;

public class BlueBlock extends Blocks {

	public BlueBlock(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/niebieski.png");
		setBlock(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
		setPoints(7);
		setHp(4);
	}
}
