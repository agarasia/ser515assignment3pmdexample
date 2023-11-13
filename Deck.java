package ser515.assign3;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Deck {
    public List deck;
	
    public Deck(){
        deck = new ArrayList(0);
    }//Deck
	
    public boolean add(Object o){
        return this.deck.add(o);
    }//add
	
    public Object get(int index){
        return this.deck.get(index);
    }//get
	
    public boolean isEmpty(){
        return this.deck.isEmpty();
    }//add is empty
	
    public Object remove(int index){
        return this.deck.remove(index);
    }
	
	
    /**
     * Deals each Player a deck(linked list) of Cards
     * @param 2 Players
     * @param seed for random number seed
     */
    public void deal(Player one, Player two, int seed) {
        int[] deal = new int[52];
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Cards add1;
        Cards add2;
        Random next = new Random(seed);
        int x;
        int nextCard = next.nextInt(52);
        int r;
        int s;
        boolean foundCard1 = false;
        boolean foundCard2 = false;
        for (x = 0; x < 52; x++)
            {deal[x] = x + 1;}
        for (x = 0; x < 26; x++) 
        {
            while (!foundCard1) 
            {
                nextCard = next.nextInt(52);
                if (deal[nextCard] != 0) 
                {
                    r = deal[nextCard] % 13;
                    s = deal[nextCard] / 13;
                    add1 = new Cards(r, s);
                    deck1.add((Object) add1);
                    deal[nextCard] = 0;
                    foundCard1 = true;
                }
	        } // while
            while (!foundCard2) 
            {
                nextCard = next.nextInt(52);
                if (deal[nextCard] != 0) 
                {
                    r = deal[nextCard] % 13;
                    s = deal[nextCard] / 13;
                    add2 = new Cards(r, s);
                    deck2.add((Object) add2);
                    deal[nextCard] = 0;
                    foundCard2 = true;
                } //if
            } //while
            foundCard1 = foundCard2 = false;
        } //fore
        one.setDeck(deck1);
        two.setDeck(deck2);
    } //Cards
}
