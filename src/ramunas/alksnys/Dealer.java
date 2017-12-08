package ramunas.alksnys;

import java.util.List;

public class Dealer extends CasinoHumanTemp {

	private PlayerData playerData;

	protected Dealer(String name, PlayerData playerData) {
		super(name);
		this.playerData = playerData;
	}
	
	public List<Player> getPlayers(){
		return playerData.getList();
	}
	
	@Override
	protected void reset() {
		// TODO Auto-generated method stub

	}

}
