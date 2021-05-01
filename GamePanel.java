import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseListener{
    private PokerGame poker;
    private Game game;
    private ArrayList<Boolean> drawBorder;
    private int handWidth, spacing, handX, handY;
    private int cardsInHand, cardsSelected;
    private int deckX, deckY, deckWidth;

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
        cardsInHand = game.getHand().size();
        drawBorder = new ArrayList<Boolean>();
        for (int i = 0; i < cardsInHand; i++){
            drawBorder.add(false);
        }

        addMouseListener(this);
    }

    public void panelDiscard(){
        int toDiscard[] = new int[cardsSelected];
        int counter = 0;
        System.out.print("From panel: to discard:");
        for( int i = 0; i < cardsInHand; i++){
            if (drawBorder.get(i)){
                toDiscard[counter] = i;
                System.out.print(" " + toDiscard[counter]);
                counter++;
                drawBorder.set(i, false);
            }
        }
        game.discard(toDiscard);
        cardsSelected = 0;
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
            draw some information to the side of the deck such as:
                bank
                current bet
            perhaps:
                credit
                how many hands to pay back credit
        */
       
        for (int i = 0; i < game.getHand().size(); i++){
            int cardX = handX + (deckWidth * i) + (spacing * i);
            game.getHand().get(i).setWidth(deckWidth);
            game.getHand().get(i).setY(handY);
            game.getHand().get(i).setX(cardX);
            game.getHand().get(i).paintCardStandard(g);
            if (drawBorder.get(i)){
                g.setColor(Color.RED);
                g.drawRect(cardX - 1, handY - 1, deckWidth + 2, (int)(deckWidth * 1.4) + 2);
            }
        }

        // Draw string with various instructions
    }

    public void mouseClicked(MouseEvent e){
        if (e.getX() >= deckX && e.getX() <= deckX + deckWidth){
            if (e.getY() >= deckY && e.getY() <= deckY + (deckY * 1.4)){
                panelDiscard();
                repaint();
            }
        }
        if (e.getX() >= handX && 
            e.getX() <= handX + (deckWidth * cardsInHand) + (spacing * cardsInHand)){
                if (e.getY() >= handY && e.getY() <= handY + (handY * 1.4)){
                    int selectedCard = (e.getX() - handX) / (deckWidth + spacing);
                    if (drawBorder.get(selectedCard)){
                        drawBorder.set(selectedCard, false);
                        cardsSelected--;
                    } else{
                        drawBorder.set(selectedCard, true);
                        cardsSelected++;
                    }
                    System.out.println("Number of cards selected: " + cardsSelected);
                    System.out.print("Cards selected:");
                    for (int i = 0; i < cardsInHand; i++){
                        if(drawBorder.get(i)){
                            System.out.print(" " + i);
                        }
                    }
                    repaint();
                }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
