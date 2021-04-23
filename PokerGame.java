public class PokerGame {
    private Game thisGame;

    PokerGame(){
        thisGame = new Game();
        thisGame.customDeck(13, 4);
        thisGame.shuffle();
    }
}
