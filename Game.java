import java.util.ArrayList;
import java.lang.Math;

public class Game {
    private int numbers;
    private int suites;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;

    public void customDeck(int numOfNumbers, int numOfSuites){
        numbers = numOfNumbers;
        suites = numOfSuites;
    }

    public void shuffle(){
        Boolean cardTable[][] = new Boolean[suites][numbers];
        int num, sui;
        
        for (int i = 0; i < numbers * suites; i++){
            do{
                num = (int)(Math.random() * numbers);
                sui = (int)(Math.random() * suites);
            } while(cardTable[sui][num]);
            cardTable[sui][num] = true;
            deck.add(new Card(num, sui));
        }
    }

    public void deal(int toBeDealt){
        for (int i = 0; i < toBeDealt; i++){
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    Game(){
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
    }
}
