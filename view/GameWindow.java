package blackjack.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import blackjack.model.ListPlayerPanel;
import blackjack.model.board.Board;



public class GameWindow extends JFrame   {
	private JPanel unknownEntityContainer;
	private JPanel playersContainer;
	private JPanel DealerContainer;
	private Board model;
	private ListPlayerPanel listPlayerPanel ;
	private PlayerChoicesPanel gameProgress;
	
	public GameWindow(Board board) throws HeadlessException {
		this.model = board ;
		this.DealerContainer = new JPanel();
		this.unknownEntityContainer = new JPanel();
		this.gameProgress = new PlayerChoicesPanel(model);
		this.listPlayerPanel = new ListPlayerPanel(model.getPlayers());
		init();
		
	}
	public void init() {
		this.add(gameProgress,BorderLayout.NORTH);
		this.playersContainer = new JPanel();
		this.playersContainer.setLayout(new BoxLayout(playersContainer, BoxLayout.Y_AXIS));
	
		for(PlayerPanel pl : this.listPlayerPanel.getPlayerPanelList()) {
			this.playersContainer.add(pl);
			
			JScrollPane scroll = new JScrollPane(pl);
			playersContainer.add(scroll);
		}
		//this.playersContainer.setLayout(new GridLayout(listPlayerPanel.size(),1));
		this.unknownEntityContainer.add(playersContainer);
		
		
		
		AlbertoPanel alberto = new AlbertoPanel(this.model.getAlberto());
		
		this.model.getAlberto().addModelListner(alberto);
		this.DealerContainer.add(alberto);
		
		
		
		this.unknownEntityContainer.add(this.DealerContainer);
		
		this.unknownEntityContainer.setLayout(new GridLayout(1, 2));
		this.add(unknownEntityContainer);
		model.addModelListner( gameProgress);
		model.inisializeBoard();
		this.setSize(890, 730);
		this.validate();
		this.setVisible(true);
	}
	public GameWindow(GraphicsConfiguration gc) {
		super(gc);
		
	}

	public GameWindow(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public GameWindow(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	

}
