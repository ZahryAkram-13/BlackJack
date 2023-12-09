package blackjack.model.board.iterator;

import blackjack.model.humains.Player;
import blackjack.model.humains.Personne;


public interface Iterator {
    
    public Player getNext();
    public boolean hasNext();
   
}
