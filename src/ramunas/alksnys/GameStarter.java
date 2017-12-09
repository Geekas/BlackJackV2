package ramunas.alksnys;

import java.util.List;
import java.util.Scanner;

public class GameStarter {
	private Player player;
	private PlayerData playerData;
	private PlayerRegistration registPlayers;
	private Dealer dealer;
	private GameBrains brains;
	private WinnerFinder winnerFinder;
	private TakeBetsFromPlayers takeBets;
	private AccountManagment accMan;
	private Scanner userInput;

	public GameStarter() {
		userInput = new Scanner(System.in);
		playerData = new PlayerData();
		takeBets = new TakeBetsFromPlayers();
		accMan = new AccountManagment();
		start();
	}

	public static void main(String... args) {
		new GameStarter();
	}

	public void start() {
		String command = "y";
		registPlayers = new PlayerRegistration(playerData);
		registPlayers.StartRegistration();
		while (command.equalsIgnoreCase("y")) {
			dealer = new Dealer("Tomas", playerData);
			brains = new GameBrains(dealer);
			takeBets.takingBets(playerData.getList());
			brains.startDealing();
			winnerFinder = new WinnerFinder(dealer, playerData.getList());
			winnerFinder.showWinner();
			System.out.println("If you want play again press Y/N");
			command = userInput.nextLine();
			playerData.resetAll();
			dealer.reset();
			accMan.checkAccount(playerData.getList());
		}
	}

}
