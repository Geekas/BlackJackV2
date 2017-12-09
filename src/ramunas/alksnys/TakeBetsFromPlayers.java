package ramunas.alksnys;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TakeBetsFromPlayers {
	
	private Scanner userInput;
	public TakeBetsFromPlayers(){
		userInput = new Scanner(System.in);
	}
	
	public void takingBets(List<Player> players) {
		for (Player player : players) {
			StringBuilder sb = new StringBuilder();
			sb.append("Player ").append(player.getName()).append(Consts.whatBet);
			System.out.println(sb);
			try {
				double ammount = userInput.nextDouble();
				if (ammount > 0 && ammount <= player.getBalance()) {
					player.setBet(ammount);
					userInput.nextLine();
				} else {
					System.out.println(Consts.errorNegMoney);
					player.setBet(1);
					userInput.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println(Consts.errorIncText);
				player.setBet(1);
				userInput.nextLine();
			}
		}

	}
}
