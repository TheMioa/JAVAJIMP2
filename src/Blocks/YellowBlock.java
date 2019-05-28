package Blocks;

import javax.swing.ImageIcon;

public class YellowBlock extends Blocks {

	public YellowBlock(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/¿ó³ty.png");
		setBlock(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
		setPoints(3);
		setHp(2);
	}

}
