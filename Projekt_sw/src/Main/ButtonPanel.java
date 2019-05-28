package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel implements ActionListener{

	public static final int HEIGHT = 200;
	public static final int WIDTH = 400;
	private JButton startButton;
	private JButton exitButton;
	
	static ActionFrame af = new ActionFrame();
	
	public ButtonPanel() {
		startButton = new JButton("Start");
		exitButton = new JButton("Exit");

		startButton.addActionListener(this);
		exitButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.CENTER, WIDTH*4, HEIGHT/6 ));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(startButton);
		add(exitButton);
		setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == startButton) {
			JFrame ex = new Animation(af);
			ex.setVisible(true);

		}

		else if(source == exitButton)
			System.exit(0) ;

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				af.setVisible(true);
				}	
		});
	}
	public void setMainController(ActionFrame actionFrame) {
		af = actionFrame ;
	}
}