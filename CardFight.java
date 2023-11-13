package ser515.assign3;

public class CardFight {
	public static void main(String[] args) {
		int seed = 0;
		if (args.length != 3) {
		    System.out.println("Number of arguments must be 3");
		    System.exit(0);
		}
		try {
			seed = Integer.valueOf(args[2]).intValue();
		}
		catch (Exception e) {
			System.out.println("Invalid arguments");
		}
		Player comp;
		Player player;
		comp = new Player(args[0]);
		player = new Player(args[1]);
		Cards deck = new Cards();
		Deck cards = new Deck();
		cards.deal(player,comp, seed);
		deck.fight(player, comp);
	}
}
