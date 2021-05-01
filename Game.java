import java.util.ArrayList;
import java.lang.Math;
import java.awt.*;

public class Game {
    protected int numbers;
    protected int suites;
    protected int deckX, deckY, deckWidth;
    protected ArrayList<Card> deck;
    protected ArrayList<Card> hand;

    public int getNumbers(){ return numbers; }

    public int getSuites(){ return suites; }

    public int getX(){ return deckX; }

    public int getY(){ return deckY; }

    public int getWidth(){ return deckWidth; }

    public int getHeight(){ return (int)(deckWidth * 1.4); }

    public ArrayList<Card> getHand(){ return hand; }

    public ArrayList<Card> getDeck(){ return deck; }

    public void setX(int x){ deckX = x; }

    public void setY(int y){ deckY = y; }

    /* Sets width of deck. There are no other dimension variables, as all are calculated based on 
        the width of the deck.
    */
    public void setDimension(int width){ deckWidth = width; }
    
    public void customDeck(int numOfNumbers, int numOfSuites){
        numbers = numOfNumbers;
        suites = numOfSuites;
    }

    public void shuffle(){
        boolean cardTable[][] = new boolean[suites][numbers];
        int num, sui;
        
        for (int i = 0; i < numbers * suites; i++){
            do{
                num = (int)(Math.random() * numbers);
                sui = (int)(Math.random() * suites);
            } while(cardTable[sui][num]);
            cardTable[sui][num] = true;
            deck.add(new Card(num + 1, sui));
        }
    }

    public void deal(int toBeDealt){
        for (int i = 0; i < toBeDealt; i++){
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void discard(int toDiscard[]){
        int numOfCards = toDiscard.length;
        for(int i = 0; i < numOfCards; i++){
            deck.add(hand.get(toDiscard[i] - i));
            hand.remove(toDiscard[i] - i);
        }
        deal(numOfCards);
    }

    Game(){
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
    }

    public void paintDeck(Graphics g){
        g.setColor(Color.WHITE); // pick out a pretty pattern for back of cards
        g.fillRoundRect(deckX, deckY, deckWidth, (int)(deckWidth * 1.4), deckWidth / 10, deckWidth / 10);
    }

    public String toString(){
        return "Deck: " + deck.size() + " cards, " + suites + " suites of " + numbers + 
               " cards each.\n Hand: " + hand.size() + " cards";
    }
}
