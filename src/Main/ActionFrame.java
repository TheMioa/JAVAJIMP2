package Main;

import java.awt.EventQueue;

import javax.swing.*;

public class ActionFrame extends JFrame {

	public ActionFrame() {
		super( "Strzelaj�ce Czo�gi" );

		JPanel buttonPanel = new ButtonPanel();
		add(buttonPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		this.setLocation(450, 250);;
	}

}
