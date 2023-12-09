package blackjack.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import blackjack.model.humains.*;
import cartes.model.Card;
public class PlayerPanel extends PersonnePannel   {

	public PlayerPanel(Personne p) {
		super(p);
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		this.cardContainer.setLayout(fl);

		this.InformationContainer.setLayout(fl);
		this.add(InformationContainer);
		this.add(cardContainer);
		
		
	}
	public void fillPlayerInformation(){
		if(this.InformationContainer.getComponentCount()!=0) {
			this.InformationContainer.removeAll();
		}
		JLabel nameLabel = new JLabel("joueur : "+((Player)p).getName());
		this.InformationContainer.add(nameLabel);
		JLabel miseLabel = new JLabel("mise : "+((Player)p).getMise()+"$");
		this.InformationContainer.add(miseLabel);
		JLabel fortuneLabel = new JLabel("fortune : "+((Player)p).getFortune()+"$");
		this.InformationContainer.add(fortuneLabel);
		this.validate();
		
	}
	@Override
	public void fillPlayerCards() {
		
		if(this.cardContainer.getComponentCount()!=0) {
			this.cardContainer.removeAll();
		}
		for(Card c : p.getListCards()) {
			
			this.cardContainer.add(new JLabel(new ImageIcon("ressources/"+c.getNum()+"_"+c.getColor()+".png")));
		}
		this.validate();
	}
	
	
	
		
	
	

}
