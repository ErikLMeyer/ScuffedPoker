public class PokerGame {
    private final int STARTING_POINTS = 200;
    private Game thisGame;

    PokerGame(){
        thisGame = new Game();
        thisGame.customDeck(13, 4);
        thisGame.shuffle();
    }
}
