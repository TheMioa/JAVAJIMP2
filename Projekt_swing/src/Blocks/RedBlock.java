package Blocks;
import javax.swing.ImageIcon;

public class RedBlock extends Blocks {

	public RedBlock(int a, int b) {
		setX(a);
		setY(b);
		ImageIcon icon = new ImageIcon("src/Grafika/czerwony.png");
		setBlock(icon.getImage());
		setDx(icon.getIconWidth());
		setDy(icon.getIconHeight());
		setPoints(1);
		setHp(1);
	}

}
