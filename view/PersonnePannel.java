package blackjack.view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import blackjack.model.humains.Personne;
import blackjack.utils.ModelListner;



public abstract class PersonnePannel extends JPanel implements ModelListner {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel InformationContainer;
	protected JPanel cardContainer;
	protected Personne p;
	public PersonnePannel(Personne p) {
		this.p = p;
		this.InformationContainer = new JPanel();
		this.cardContainer = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public PersonnePannel(LayoutManager layout) {
		super(layout);
	}
	public PersonnePannel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		
	}
	public PersonnePannel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		
	}
	public abstract void fillPlayerInformation();
	public abstract void fillPlayerCards();
	public void updateModel() {
			fillPlayerInformation();
			fillPlayerCards();
			
	}
}
