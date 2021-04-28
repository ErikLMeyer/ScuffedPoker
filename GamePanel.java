import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    private PokerGame poker;
    private Game game;
    private ArrayList<Integer> toDiscard;
    private int handWidth, spacing, handX, handY;
    private int deckX, deckY, deckWidth;

    public ArrayList<Integer> getList(){ return toDiscard; }

    public int gethWidth(){ return handWidth; }

    public int getSpacing(){ return spacing; }

    public int getHandX(){ return handX; }

    public int getHandY(){ return handY; }

    public int getDeckX(){ return deckX; }

    public int getDeckY(){ return deckY; }

    public int getDeckWidth(){ return deckWidth; }

    public void setCardWidthAndPosition(int w, int h){
        deckWidth = w / 12;
        deckX = w / 3;
        deckY = h / 10;
        spacing = deckWidth;

        handX = deckX - (3 * deckWidth) + (2 * deckWidth / 5);
        handY = deckY + game.getHeight() + spacing;
    }

    public void setSpacing(int s){ spacing = s; }

    public GamePanel(){
        poker = new PokerGame(200);
        game = poker.getGame();
        toDiscard = new ArrayList<Integer>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        setCardWidthAndPosition(panelWidth, panelHeight);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, panelWidth, panelHeight);

        game.setDimension(deckWidth);
        game.setX(deckX);
        game.setY(deckY);
        game.paintDeck(g);

        /*
            draw some information to the side of the deck
            for(size of hand) {paintCardStandard(g);}
        */
       
        for (int i = 0; i < game.getHand().size(); i++){
            game.getHand().get(i).setWidth(deckWidth);
            game.getHand().get(i).setY(handY);
            game.getHand().get(i).setX(handX + (deckWidth * i) + (spacing * i));
            game.getHand().get(i).paintCardStandard(g);
        }
    }
}
