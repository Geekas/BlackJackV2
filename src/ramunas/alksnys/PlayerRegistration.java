package ramunas.alksnys;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerRegistration {
	private PlayerData playerData;
	private Scanner userInput;
	private int playerNum;

	public PlayerRegistration(PlayerData playerData) {
		this.playerData = playerData;
		userInput = new Scanner(System.in);
	}

	public void StartRegistration() {
		System.out.println(Consts.regMess);
		setPlayerNumber();
		setPlayerNames();
	}

	private void setPlayerNames() {
		for (int i = 0; i < playerNum; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("Enter players ").append(i + 1).append(" name: ");
			System.out.println(sb);
			String name = userInput.nextLine();
			Player player = new Player(name);
			playerData.addPlayer(player);
		}

	}

	private void setPlayerNumber() {
		while (true) {
			try {
				playerNum = userInput.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				userInput.nextLine();
				System.out.println(Consts.errorPosNum);
				continue;
			}
			if (playerNum <= 0) {
				System.out.println(Consts.errorPosNum);
			} else {
				userInput.nextLine();
				break;
			}
		}
	}
}
