package ramunas.alksnys;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {
	private List<Player> playerList;

	public PlayerData() {
		playerList = new ArrayList<>();
	}
	public void addPlayer(Player player){
		playerList.add(player);
	}
	public int getListSize(){
		return playerList.size();
	}
	public List<Player> getList(){
		return playerList;
	}
	public void resetAll(){
		for (Player player: playerList){
			player.reset();
		}
	}
}
