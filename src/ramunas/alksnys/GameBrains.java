package ramunas.alksnys;

import java.util.List;
import java.util.Scanner;

public class GameBrains {
	private Monitor monitor;
	private Dealer dealer;
	private CardGiver cardGiver;
	private List<Player> list;
	private Scanner userInput;

	public GameBrains(Dealer dealer) {
		userInput = new Scanner(System.in);
		monitor = new Monitor();
		cardGiver = new CardGiver();
		this.dealer = dealer;
		this.list = dealer.getPlayers();
	}

	private void giveCardsToPlayer(Player player, int index) {		
			if (index == 0) {
				cardGiver.setACard(dealer);
				cardGiver.setACard(player);
				cardGiver.setACard(dealer);
				cardGiver.setACard(player);				
			} else {
				cardGiver.setACard(player);
				cardGiver.setACard(player);				
			}
	}
	
	public void startDealing(){
		int index = 0;
		String command = "";
		for (Player player : list){
			while(!player.getStatus()&&!player.getWinStatus()&&!command.equalsIgnoreCase("stop")){
				giveCardsToPlayer(player, index);	
				monitor.showCards(dealer, player);
				monitor.showCommands();
				command = userInput.nextLine();
				proccessCommand(command, player);
				
			}
		}
	}

	private void proccessCommand(String command, Player player) {
		switch(command.toLowerCase()){
		case "take": 
		}
	}

}
