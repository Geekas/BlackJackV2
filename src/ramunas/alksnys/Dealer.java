package ramunas.alksnys;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends CasinoHumanTemp {

	private PlayerData playerData;
	private boolean doDealCards;
	private List<Player> tempPlayers;

	protected Dealer(String name, PlayerData playerData) {
		super(name);
		this.playerData = playerData;
		doDealCards = false;
		tempPlayers = new ArrayList<>();
	}
	
	public List<Player> getPlayers(){
		return playerData.getList();
	}
	
	@Override
	protected void reset() {
		setPoints(0);
		setStatus(false);
		doDealCards = false;
		tempPlayers.clear();
		

	}
	public void setDoDealCards(boolean state){
		doDealCards = state;
	}
	public boolean getDoDealCards(){
		return doDealCards;
	}

}
