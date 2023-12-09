package blackjack.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import cartes.model.Card;
import blackjack.model.humains.Dealer;
import blackjack.model.humains.Personne;

public class AlbertoPanel extends PersonnePannel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel imageTapis;
	public AlbertoPanel(Personne p) {
		super(p);
		this.add(InformationContainer,BorderLayout.PAGE_START);
		this.add(cardContainer,BorderLayout.SOUTH);
		
	}

	@Override
	public void fillPlayerInformation() {
		
		if(InformationContainer.getComponentCount()!=0) {
			InformationContainer.removeAll();
		}
		this.InformationContainer.add(new JLabel("Caissier : "+p.getName()));
		
	}

	@Override
	public void fillPlayerCards() {
		
		if(this.cardContainer.getComponentCount()!=0) {
			this.cardContainer.removeAll();
		}
                
		imageTapis = new JLabel(new ImageIcon("ressources/Tapis.jpg"));
		
		imageTapis.setLayout(new GridLayout()); 
		for(Card c : p.getListCards()) {
			
			if(c.getHidden())
				imageTapis.add(new JLabel(new ImageIcon("ressources/"+c.getNum()+"_"+c.getColor()+".png")));
			else
				imageTapis.add(new JLabel(new ImageIcon("ressources/b2fv.png")));
		}
		this.cardContainer.add(imageTapis);
		}

	
}
