package Blocks;

import javax.swing.ImageIcon;

public class GreenBlock extends Blocks {

	public GreenBlock(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/zielony.png");
		setBlock(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
		setPoints(4);
		setHp(3);
	}
}
