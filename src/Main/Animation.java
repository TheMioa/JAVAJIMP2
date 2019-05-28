package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Animation extends JFrame {
	

	public Animation(ActionFrame af) {

		initUI();
		af.setVisible(false);
	}

	private void initUI() {
		this.setLayout(new BorderLayout());
	
		Panel score1 = new Panel();
		score1.setLayout(new BorderLayout());
		JLabel l1 = new JLabel("0");
		score1.add(l1, BorderLayout.NORTH);
		score1.setSize(20, 20);

		Panel score2 = new Panel();
		JLabel l2 = new JLabel("0");
	//	JLabel l2a = new JLabel("Punkty");
	    score2.setLayout(new BorderLayout());
	    score2.add(l2, BorderLayout.NORTH);
	    score2.setSize(20, 20);
	 //   score2.add(l2a, BorderLayout.CENTER);
	    
		
		Board b = new Board(l1,l2);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				if (event.getKeyChar() == 'a') {
					b.tank[0].setTankMoveLeft(true);
					b.tank[0].setTankMoveRight(false);
				}
				if (event.getKeyChar() == 'd') {
					b.tank[0].setTankMoveLeft(false);
					b.tank[0].setTankMoveRight(true);
				}
				if (event.getKeyChar() == 'j') {
					b.tank[1].setTankMoveLeft(true);
					b.tank[1].setTankMoveRight(false);
				}

				if (event.getKeyChar() == 'l') {
					b.tank[1].setTankMoveLeft(false);
					b.tank[1].setTankMoveRight(true);
				}
				if (event.getKeyChar() == 'w') {
					b.tank[0].shoot();
				}
				if (event.getKeyChar() == 'i') {
					b.tank[1].shoot();
				}
			}
		});
		add(score1,BorderLayout.WEST);
		add(score2, BorderLayout.EAST);
		score1.setBackground(Color.white);
		score2.setBackground(Color.white);
		add(b);

		setResizable(false);
		pack();

		setTitle("Strzelaj¹ce Czo³gi");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
