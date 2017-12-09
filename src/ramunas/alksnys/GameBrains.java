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

	private void giveCardToPlayer(Player player) {
		cardGiver.setACard(player);
	}

	public void startDealing() {
		String command = "";
		giveFirst2Cards();
		for (Player player : list) {
			monitor.showCards(dealer, player);
			while (!player.getStatus() && !player.getWinStatus() && !command.equalsIgnoreCase("stop")) {				
				monitor.showCommands();
				command = userInput.nextLine();
				if (command.equalsIgnoreCase("stop")) {
					new PointsCalcul().getHighestPoints(player);
					monitor.showPersonCards(player);
					if (!player.getStatus()) {
						dealer.setDoDealCards(true);
					}	
					command = "";
					break;
				}
				proccessCommand(command, player);

			}
		}
		if (dealer.getDoDealCards()){ dealDealersCards();}
	}

	private void dealDealersCards() {
		new DealerBrains().dealerCardDealing(dealer);
		
	}

	private void giveFirst2Cards() {
		int index = 0;
		for (Player player : list) {
			giveCardsToPlayer(player, index);
			new PointsCalcul().getStatus(player);
			++index;
		}

	}

	private void proccessCommand(String command, Player player) {
		switch (command.toLowerCase()) {
		case "take":
			giveCardToPlayer(player);
			monitor.showCards(dealer, player);
			new PointsCalcul().getStatus(player);
			break;
		default:
			System.out.println("Wrong command");
			monitor.showCards(dealer, player);
			break;
		}
	}

}
