package blackjack.model;

import java.util.ArrayList;
import java.util.List;

import blackjack.model.humains.Player;
import blackjack.view.PersonnePannel;
import blackjack.view.PlayerPanel;

public class ListPlayerPanel {
	private List<PlayerPanel> playerPanelList;
	public ListPlayerPanel(List<Player> l) {
		this.playerPanelList = new ArrayList();
		for(Player p : l) {
			PlayerPanel panel = new PlayerPanel(p);
			p.addModelListner(panel);
			this.playerPanelList.add((PlayerPanel) panel);
		
		}
	}
	public List<PlayerPanel> getPlayerPanelList() {
		return playerPanelList;
	}
	public int size() {
		return this.playerPanelList.size();
	}

}
