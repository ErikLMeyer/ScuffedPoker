import java.util.*;

public class PokerGame extends Game{
    private int bank;
    private int bet;
    private int credit;

    public int getBank(){ return bank; }

    public int getBet(){ return bet; }

    public int getCredit(){ return credit; }

    public void setBank(int b){ bank = b; }

    public void setBet(int b){ bet = b; }

    public void setCredit(int c){ credit = c; }

    public void resetCards(){
        hand.clear();
        deck.clear();
    }

    public void distribute(){
        shuffle();
        deal(5);
    }

    public int scanHand(){
        int nums[] = new int[13];
        int suis[] = new int[4];

        // should not be > 2
        int pairs = 0;
        boolean triple = false;
        boolean four = false;
        boolean allSuit = false;

        for (Card cards : hand){
            suis[cards.getSuite()] += 1;
            nums[cards.getNumber() - 1] += 1;

        }

        for (int s = 0; s < suis.length; s++){
            if (suis[s] == 5){
                allSuit = true;
            }
        }
    }

    PokerGame(int b){
        super();
        bank = b;
        customDeck(13, 4);
    }

    public String toString(){
        return "Current funds: " + bank + "\nCurrent bet: " + bet;
    }
}
