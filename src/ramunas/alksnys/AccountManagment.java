package ramunas.alksnys;

import java.util.ArrayList;
import java.util.List;

public class AccountManagment {
	public void checkAccount(List<Player> players){
		List<Player> tempList = new ArrayList<>(); 
		for (Player player : players){
			if (player.getBalance() == 0){
				tempList.add(player);
				System.out.println("Player " + player.getName() + " you are removed from game. Your account ballance = 0");
			}
		}
		players.removeAll(tempList);
	}
}
