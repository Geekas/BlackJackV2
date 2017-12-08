package ramunas.alksnys;

import java.util.Arrays;

public class Monitor {

	public  void showCards(Dealer dealer, Player player) {
		StringBuilder sb = new StringBuilder();
		sb.append("Dealer cards are: X ").append(dealer.getCards().get(1));
		System.out.println(sb);
	}

	public void showCommands() {
		System.out.println(Consts.meniu);
		
	}
	public void showDealerCards(Dealer dealer){
		System.out.println(Arrays.toString(dealer.getCards().toArray()));
	}
}
