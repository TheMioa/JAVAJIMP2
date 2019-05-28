package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Blocks.Blocks;
import Blocks.RedBlock;
import Blocks.YellowBlock;
import Objects.Tank;

public class Board extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 600;
	private final int INITIAL_Y = -40;
	private final int DELAY = 25;
	private final int NUMBEROFTANKS = 2;
	private final int NUMBEROFREDBLOCKS = 4;
	private final int NUMBEROFYELLOWBLOCKS = 6;
	private final int BULLETBUF = -100;

	int i = 0;
	private Thread animator;
	Random random = new Random();
	JLabel nCollisions [] = new JLabel[2];
	
	int rnd;
	int typeX = 1;
	int typeY = 0;

	public Board() {
		initBoard();
	}

	public Board(JLabel l1, JLabel l2) {
		this();
		nCollisions[0] = l1;
		nCollisions[1] = l2;

	}

	public void initBoard() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	}

	public void initRnd() {
		rnd = random.nextInt(4);
		if (rnd == 0) {
			typeX = 1;
			typeY = 0;
		}
		if (rnd == 1) {
			typeX = -1;
			typeY = 0;
		}
		if (rnd == 2) {
			typeX = 0;
			typeY = 1;
		}
		if (rnd == 3) {
			typeX = 0;
			typeY = -1;
		}
	}

	public Tank tank[] = new Tank[2];
	public RedBlock redBlock[] = new RedBlock[NUMBEROFREDBLOCKS];
	public YellowBlock yellowBlock[] = new YellowBlock[NUMBEROFYELLOWBLOCKS];

	int j = 0;

	public void initBlocks() {
		for (i = 0; i < NUMBEROFREDBLOCKS; i++) {
			redBlock[i] = new RedBlock(random.nextInt(B_WIDTH - 100) + 50, INITIAL_Y - 150 * (j++));
		}
		for (i = 0; i < NUMBEROFYELLOWBLOCKS; i = i + 2) {
			yellowBlock[i] = new YellowBlock(random.nextInt(B_WIDTH - 100) + 50, INITIAL_Y - 150 * (j++));
			yellowBlock[i + 1] = new YellowBlock(yellowBlock[i].getX() + typeX * yellowBlock[i].getDx(),
					yellowBlock[i].getY() + typeY * yellowBlock[i].getDy());
		}
	}

	public void initTanks() {
		tank[0] = new Tank(300, 540);
		tank[1] = new Tank(700, 540);
	}

	{
		initBlocks();
		initTanks();
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g);
	}

	private void draw(Graphics g) {
		for (i = 0; i < NUMBEROFREDBLOCKS; i++) {
			g.drawImage(redBlock[i].getBlock(), redBlock[i].getX(), redBlock[i].getY(), this);
		}
		for (i = 0; i < NUMBEROFYELLOWBLOCKS; i++) {
			g.drawImage(yellowBlock[i].getBlock(), yellowBlock[i].getX(), yellowBlock[i].getY(), this);
		}
		for (i = 0; i < NUMBEROFTANKS; i++) {
			for (int j = 0; j < tank[i].getNUMBEROFBULLETS(); j++) {
				g.drawImage(tank[i].bullet[j].getImage(), tank[i].bullet[j].getX(), tank[i].bullet[j].getY(), this);
			}
			g.drawImage(tank[i].getTank(), tank[i].getX(), tank[i].getY(), this);
			g.drawImage(tank[i].gun.getImage(), tank[i].gun.getX(), tank[i].gun.getY(), this);
			
		}
		Toolkit.getDefaultToolkit().sync();
	}
	private boolean collision(Tank tank, Blocks block, int j) {
		boolean c = false;
		for (int i = 0; i < tank.getNUMBEROFBULLETS(); i++) {
			c = Math.abs(block.getX() - tank.bullet[i].getX()) < block.getDx() / 2 + tank.bullet[i].getDx() / 2
					&& Math.abs(block.getY() - tank.bullet[i].getY()) < block.getDy() / 2
							+ tank.bullet[i].getDy() / 2;
			if (c) {
				if (block.getHp() == 1) {
					tank.bullet[i].setY(BULLETBUF);
					tank.bullet[i].setX(BULLETBUF);
					tank.bullet[i].setxMove(0);
					tank.bullet[i].setyMove(0);
					nCollisions[j].setText("" + (Integer.parseInt((nCollisions[j]).getText()) + block.getPoints()));
					return c;
				} else {
					block.setHp(block.getHp() - 1);
					tank.bullet[i].setY(BULLETBUF);
					tank.bullet[i].setX(BULLETBUF);
					tank.bullet[i].setxMove(0);
					tank.bullet[i].setyMove(0);
				}
			}
		}
		return c;
	}

	private void cycleBlocks() {

		for (i = 0; i < NUMBEROFREDBLOCKS; i++) {
			redBlock[i].setY(redBlock[i].getY() + 3);
		}
		for (i = 0; i < NUMBEROFYELLOWBLOCKS; i++) {
			yellowBlock[i].setY(yellowBlock[i].getY() + 3);
		}
		for (i = 0; i < NUMBEROFREDBLOCKS; i++) {
			if (redBlock[i].getY() > B_HEIGHT || collision(tank[0], redBlock[i], 0) || collision(tank[1], redBlock[i], 1)) {
				redBlock[i].setY(INITIAL_Y);
				redBlock[i].setX(random.nextInt(950) + 25);
			}
		}
		for (i = 0; i < NUMBEROFYELLOWBLOCKS; i = i + 2) {
			if (yellowBlock[i].getY() > B_HEIGHT || collision(tank[0], yellowBlock[i], 0) || collision(tank[1], yellowBlock[i], 1)
					|| collision(tank[0], yellowBlock[i+1], 0) || collision(tank[1], yellowBlock[i+1], 1)) {
				yellowBlock[i].setY(INITIAL_Y);
				yellowBlock[i].setX(random.nextInt(950) + 25);
				initRnd();
				yellowBlock[i + 1].setY(yellowBlock[i].getY() + typeY * yellowBlock[i].getDy());
				yellowBlock[i + 1].setX(yellowBlock[i].getX() + typeX * yellowBlock[i].getDx());
				yellowBlock[i].setHp(2);
				yellowBlock[i+1].setHp(2);
			}
			if(yellowBlock[i].getHp() < yellowBlock[i+1].getHp()) {
				yellowBlock[i+1].setHp(yellowBlock[i].getHp());
			}
			if(yellowBlock[i].getHp() > yellowBlock[i+1].getHp()) {
				yellowBlock[i].setHp(yellowBlock[i+1].getHp());
			}
		}

	}

	private void cycleTanks() {
		if (tank[0].isTankMoveRight() && tank[0].getX() < (tank[1].getX() - tank[0].getDx()))
			tank[0].right();

		if (tank[0].isTankMoveLeft() && tank[0].getX() > 0)
			tank[0].left();

		if (tank[1].isTankMoveRight() && tank[1].getX() < (B_WIDTH - tank[1].getDx())) {
			tank[1].right();

		}
		if (tank[1].isTankMoveLeft() && tank[1].getX() > (tank[0].getX() + tank[1].getDx()))
			tank[1].left();

		for (int j = 0; j < NUMBEROFTANKS; j++) {
			for (i = 0; i < tank[j].getNUMBEROFBULLETS(); i++) {
				tank[j].bullet[i].setX(tank[j].bullet[i].getX() + tank[j].bullet[i].getxMove());
				tank[j].bullet[i].setY(tank[j].bullet[i].getY() - tank[j].bullet[i].getyMove());

				if (tank[j].bullet[i].getY() < 0 || tank[j].bullet[i].getX() < 0 || tank[j].bullet[i].getX() > B_WIDTH) {
					tank[j].bullet[i].setY(BULLETBUF);
					tank[j].bullet[i].setX(BULLETBUF);
					tank[j].bullet[i].setxMove(0);
					tank[j].bullet[i].setyMove(0);
				}

			}
		}
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;

		while (true) {
			beforeTime = System.currentTimeMillis();
			cycleBlocks();
			cycleTanks();
			repaint();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = DELAY - timeDiff;

			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				String msg = String.format("Thread interrupted: %s", e.getMessage());
				JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}