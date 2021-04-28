import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    private ArrayList<Integer> toDiscard;
    private int handWidth, handSpacing, handX, handY;
    private int deckX, deckY, deckWidth;

    public ArrayList<Integer> getList(){ return toDiscard; }

    public int gethWidth(){ return handWidth; }

    public int getSpacing(){ return handSpacing; }

    public int getHandX(){ return handX; }

    public int getHandY(){ return handY; }

    public int getDeckX(){ return deckX; }

    public int getDeckY(){ return deckY; }

    public int getDeckWidth(){ return deckWidth; }

    public void setCardWidth(int w){
        deckWidth = w;
        handWidth = w /* * number of cards in hand */;
    }

    public void setSpacing(int s){ handSpacing = s; }

    public GamePanel(){
        toDiscard = new ArrayList<Integer>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, panelWidth, panelHeight);

        /* 
            set deck position and dimensions
            paintDeck(g);

            set hand dimensions and position
            for(size of hand) {paintCardStandard(g);}
        */
    }
}
