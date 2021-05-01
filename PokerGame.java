public class PokerGame extends Game{
    private int bank;
    private int bet;

    public int getBank(){ return bank; }

    public int getBet(){ return bet; }

    public void setBank(int b){ bank = b; }

    public void setBet(int b){ bet = b; }

    PokerGame(int b){
        super();
        bank = b;
        customDeck(13, 4);
        shuffle();
        deal(5);
    }

    public String toString(){
        return "Current funds: " + bank + "\nCurrent bet: " + bet;
    }
}
