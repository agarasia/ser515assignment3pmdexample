package ser515.assign3;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Deck deck; 

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List winnings;
    
    public Player(String name) {
	this.name = name;
	winnings = new ArrayList(0);
    }

    public String getName() {
	return name;
    }

    public static void display(List disp) {
        for (Object x:disp)
            Cards.show((Cards)x);
        }
}
