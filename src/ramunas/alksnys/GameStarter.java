package ramunas.alksnys;

import java.util.List;

public class GameStarter {
	private Player player;
	private PlayerData playerData;
	private PlayerRegistration registPlayers;
	private Dealer dealer;
	private GameBrains brains;
//	private PCalcul pCalcul;
//	private WinnerFinder winFinder;
//	private Monitor monitor;	
	public GameStarter() {
		playerData = new PlayerData();
		start();
	}

	public static void main(String...args) {
		new GameStarter();
	}

	public void start() {
		registPlayers = new PlayerRegistration(playerData);
		registPlayers.StartRegistration();
		dealer = new Dealer("Tomas", playerData);
		brains = new GameBrains(dealer);
		brains.startDealing();
//		List<Player> list = playerData.getList();
//		for (Player player : list){
//			System.out.println(player.getName());
//		}
	}

}
