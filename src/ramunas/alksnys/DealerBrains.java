package ramunas.alksnys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DealerBrains {

	private Monitor monitor;

	public DealerBrains() {
		monitor = new Monitor();
	}

	private void calculPoints(Dealer dealer) {
		List<Integer> dPoints = new ArrayList<>(new PointsCalcul().calculatePoints(dealer));
		if (dPoints.size() == 2 && Collections.max(dPoints) <= 21) {
			dealer.setPoints(Collections.max(dPoints));
		} else if (dPoints.size() == 2 && Collections.min(dPoints) <= 21) {
			dealer.setPoints(Collections.min(dPoints));
		} else {
			dealer.setPoints(dPoints.get(0));
		}
	}

	public void dealerCardDealing(Dealer dealer) {
		calculPoints(dealer);
		String command = getCommand(dealer);
		monitor.showDealerStats(dealer);
		while (command.equals(Consts.choiceTake)) {
			new CardGiver().setACard(dealer);
			calculPoints(dealer);
			monitor.showDealerStats(dealer);
			command = getCommand(dealer);
		}
	}

	private String getCommand(Dealer dealer) {
		if (dealer.getPoints() > Consts.maxPoints) {
			dealer.setStatus(true);
			return Consts.choiceEmpty;
		} else if (dealer.getPoints() >= Consts.minPoints) {
			return Consts.choiceStop;
		}
		return Consts.choiceTake;
	}
}
