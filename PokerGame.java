public class PokerGame {
    private Game thisGame;
    private int bank;
    private int bet;

    public Game getGame(){ return thisGame; }

    public int getBank(){ return bank; }

    public int getBet(){ return bet; }

    public void setBank(int b){ bank = b; }

    public void setBet(int b){ bet = b; }

    public void runGame(){
        thisGame.shuffle();
        // prompt user to place a bet
        thisGame.deal(5);
        // calculate winnings

    }

    PokerGame(int b){
        thisGame = new Game();
        bank = b;
        thisGame.customDeck(13, 4);
        thisGame.shuffle();
        thisGame.deal(5);
    }
}
