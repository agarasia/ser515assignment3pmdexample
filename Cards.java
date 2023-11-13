package ser515.assign3;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	public int rank;
	public int suit;
	public Cards() {
		rank = -1;
		suit = -1;
	} //cards
	
	public Cards(int r, int s) {
		rank = r;
		suit = s;
	}
	
	public static void show(Cards c) {
		int r = c.rank;
		int s = c.suit;
		String suit = null;
		String value = null;
		suit = extracted(s); //switch
		value = extracted2(r);
		System.out.println(" " + value + " of " + suit);
	} //show

	private static String extracted2(int r) {
		String value = null;
		if(r>=0 && r<=8)
		{
			value = String.valueOf(r+2);
			return value;
		}
		switch (r) {
			case 9 :
				value = "J";
				break;
			case 10 :
				value = "Q";
				break;
			case 11 :
				value = "K";
				break;
			case 12 :
				value = "A";
				break;
			default :
				System.out.println(" Invalid rank of the card");
				break;
		} //switch
		return value;
	}

	private static String extracted(int s) {
		if(s==0)	{return "Clubs";}
		else if(s==1)	{return "Diamonds";}
		else if(s==2)	{return "Hearts";}
		return	"Spades";
	}
	
	public void fight(Player p1, Player p2) {
		List tie = new ArrayList();
		Cards one;
		Cards two;
		String winner = null;
		Deck deck1 = p1.getDeck();
		Deck deck2 = p2.getDeck();
		while (!deck1.isEmpty()) {
			one = (Cards) deck1.get(0);
			two = (Cards) deck2.get(0);
			tie.add(one);
			tie.add(two);
			System.out.print("Player: " + p1.getName());
			show(one);
			System.out.print("Player: " + p2.getName());
			show(two);
			if (one.rank > two.rank) {
				add(tie, p1.winnings);
				tie.clear();
				winner = p1.getName();
			} //if
			else if (one.rank < two.rank) {
				add(tie, p2.winnings);
				tie.clear();
				winner = p2.getName();
			} //else if
			else {
				if (one.suit > two.suit) {
					add(tie, p1.winnings);
					tie.clear();
					winner = p1.getName();
				} //if
				else if (one.suit < two.suit) {
					add(tie, p2.winnings);
					tie.clear();
					winner = p2.getName();
				}
			} //else
			deck1.remove(0);
			deck2.remove(0);
			System.out.println(winner + " wins.");
			System.out.println("");
		} //while
		if (p1.winnings.size() > p2.winnings.size())
		    {System.out.println(p1.getName() + " wins overall.");}
		else
		    {System.out.println(p2.getName() + " wins overall.");}
	} //fight
	
	public void add(List a, List b) {
		int x = 0;
		while (!a.isEmpty() && x < a.size()) {
			Cards add = (Cards) a.get(0);
			b.add(add);
			a.remove(0);
		} //while
	} //add
} //Cards
