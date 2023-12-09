package blackjack.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

import blackjack.control.ChoiceButton;
import blackjack.model.board.Board;
import blackjack.utils.ModelListner;


public class PlayerChoicesPanel extends JPanel implements ModelListner {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board model ;
	private JLabel currentPlayerLabel ;
	private JPanel buttonsChoiceContainer;
	public PlayerChoicesPanel(Board model2) {
		this.model = model2 ;
		this.currentPlayerLabel = new JLabel();
		this.buttonsChoiceContainer = new JPanel();
		this.setLayout(new GridLayout(2,1));
		this.add(currentPlayerLabel);
		this.buttonsChoiceContainer.setLayout(new FlowLayout());
		this.add(buttonsChoiceContainer);
		
	}
	public void initButtonsChoice() {
		
		ChoiceButton hitButton = new ChoiceButton("HIT",model);
		this.buttonsChoiceContainer.add(hitButton);
		ChoiceButton passButton = new ChoiceButton("PASS",model);
		this.buttonsChoiceContainer.add(passButton);
		ChoiceButton doubleButton = new ChoiceButton("DOUBLE",model);
		this.buttonsChoiceContainer.add(doubleButton);
		
	}
	
	public void buttonsReplayChoice() {
		ChoiceButton replayButton = new ChoiceButton("rejouer",model);
		this.buttonsChoiceContainer.add(replayButton);
		
		ChoiceButton quitButton = new ChoiceButton("quiter",model);
		this.buttonsChoiceContainer.add(quitButton);
		
	}
	public PlayerChoicesPanel(LayoutManager layout) {
		super(layout);
		
	}

	public PlayerChoicesPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		
	}

	public PlayerChoicesPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		
	}

	
	@Override
	public void updateModel() {
		
			if(!model.isFinished())
			{
				this.currentPlayerLabel.setText("C'est le tour du joeur : "+model.getCurrentPlayer().getName());
				if(this.buttonsChoiceContainer.getComponentCount()!=0) {
					this.buttonsChoiceContainer.removeAll();
					this.validate();
				}
				initButtonsChoice();
				System.out.println("update");
			}
			else {
				this.currentPlayerLabel.setText("partie finie : voulez-vous rejouer ?");
				this.buttonsChoiceContainer.removeAll();
				this.validate();
				buttonsReplayChoice();
			}
			this.validate();
		
		
	}

}
