package blackjack.model.board.iterator;

import java.util.List;
import blackjack.model.humains.Player;


public class PlayersIterator implements Iterator{
    
    public List<Player> players;
    public int currentPlayerIndex = -1;

    public PlayersIterator(List<Player> players) {
        this.players = players;    
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    
    @Override
    public Player getNext() {
        if(this.hasNext()) {
            this.currentPlayerIndex++;
            return this.players.get(this.currentPlayerIndex);
        }
        else 
            return null;
        
    }

    @Override
    public boolean hasNext() {
        return this.currentPlayerIndex < this.players.size()-1;
    }
    
    
}
