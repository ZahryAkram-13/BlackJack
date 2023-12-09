package blackjack.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import blackjack.model.board.Board;
import blackjack.model.humains.Player;

public class GamePlayerMisesPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<JTextField> playersNames ;
	List<JTextField> playersMises ;
	GameParameterWindow windowParent;
	JPanel infoContainer ;
	public GamePlayerMisesPanel(int nbPlayer,GameParameterWindow parent) {
		this.windowParent = parent ;
		this.playersNames = new ArrayList<JTextField>();
		this.playersMises = new ArrayList<>();
		this.infoContainer = new JPanel();
		this.infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());
		
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		
		for(int i=0;i<nbPlayer;i++) {
			JPanel container = new JPanel();
			container.setLayout(fl);
			playersNames.add(new JTextField());
			container.add(new JLabel("Nom du joeur "+(i+1)));
			playersNames.get(i).setPreferredSize(new Dimension(100,20));
			container.add(this.playersNames.get(i));
			playersMises.add(new JTextField());
			container.add(new JLabel("Mise du joeur "+(i+1)));
			playersMises.get(i).setPreferredSize(new Dimension(100,20));
			container.add(this.playersMises.get(i));
			infoContainer.add(container);
		}
		this.add(infoContainer,BorderLayout.NORTH);
		JButton createBoard = new JButton("Commencer");
		createBoard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					List<Player> list = generatePlayerList();
					System.out.println(list);
					Board board = new Board(list);
					GameWindow gw = new GameWindow(board);
					//this.board.addModelListner(gw);
					getWindoParent().dispose();
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Mises incorrect");
				}
				
			}
		});
	
		this.add(createBoard,BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(infoContainer);
		this.add(scroll);
		
		
	}

	public List<Player> generatePlayerList() {
		List<Player> players = new ArrayList<Player>();
			for(int i =0;i<this.playersNames.size();i++) {
			String name = playersNames.get(i).getText();
			int mise=0;
			
			mise = Integer.parseInt(playersMises.get(i).getText());
			
			players.add(new Player(name, mise));
			
		}
		return players;
	}

	public JFrame getWindoParent() {
		return windowParent;
	}
	
}
