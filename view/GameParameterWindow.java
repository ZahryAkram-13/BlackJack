package blackjack.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public class GameParameterWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel container ;
	private GamePlayerMisesPanel gPM ;
	private JButton next;
	public GameParameterWindow() throws HeadlessException {
		
	}

	public GameParameterWindow(GraphicsConfiguration gc) {
		super(gc);
		
	}
	
	public GameParameterWindow(String title) throws HeadlessException {
		super(title);
		//this.setLayout(new GridLayout(3,1));
		this.container = new JPanel();
		this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		this.add(container);
		this.nbPlayerPlayerGenerator();
		this.setSize(500, 200);
		this.setVisible(true);
	}

	public GameParameterWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		
	}
	public void nbPlayerPlayerGenerator() {
		JPanel nbPlayerPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		nbPlayerPanel.setLayout(fl);
		JLabel label = new JLabel("Nombre de joueurs");
		Integer[] elements = new Integer[] {1,2,3,4};
		final JComboBox<Integer> nbPlayer = new JComboBox<Integer>(elements);
		nbPlayerPanel.add(label);
		nbPlayerPanel.add(nbPlayer);
		next = new JButton("valider");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				playerMiseGenerator((Integer) nbPlayer.getSelectedItem());
				
			}
		});
		this.container.add(nbPlayerPanel);
		this.container.add(next);
		next.setAlignmentX(CENTER_ALIGNMENT);
		nbPlayerPanel.setAlignmentX(CENTER_ALIGNMENT);
		this.pack();
	}
	public void playerMiseGenerator(int nbPlayer) {
			if(this.gPM != null) {
				
				this.container.remove(gPM);
				
				this.validate();
			}
			this.validate();
		
			this.gPM = new  GamePlayerMisesPanel(nbPlayer,this);
			this.container.add(this.gPM);
			
			this.validate();
		
	}


}
