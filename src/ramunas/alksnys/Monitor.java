package ramunas.alksnys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Monitor {

	public void showCards(Dealer dealer, Player player) {
		StringBuilder sb = new StringBuilder();
		sb.append("Dealer ").append(dealer.getName()).append(" cards are: X ").append(dealer.getCards().get(1))
				.append("\nPlayers ").append(player.getName()).append(" cards: ").append(player.getCards())
				.append(" tai yra taskai: ").append(new PointsCalcul().calculatePoints(player));
		System.out.println(sb);
	}

	public void showCommands() {
		System.out.println(Consts.meniu);
	}

	public void showPersonCards(PlayerProperties person) {
		StringBuilder sb = new StringBuilder();
		sb.append(person.getName()).append(" tavo kortos yra: ").append(person.getCards()).append(" tai yra tasku: ")
				.append(person.getPoints());
		System.out.println(sb);
	}

	public void showDealerCards(Dealer dealer) {
		System.out.println(Arrays.toString(dealer.getCards().toArray()));
	}

	public void showDealerStats(Dealer dealer) {
		StringBuilder sb = new StringBuilder();
		sb.append(Consts.dealerCards).append(dealer.getCards()).append(" tai yra: ")
				.append(Collections.max(new PointsCalcul().calculatePoints(dealer)));
		System.out.println(sb);
	}

	public void showPlayerStatsinDetailAll(List<Player> players) {
		for (Player player : players) {
			System.out.println("Players " + player.getName() + " balance is " + player.getBalance());
		}
	}
}
