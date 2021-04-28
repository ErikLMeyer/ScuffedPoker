import javax.swing.*;
import java.awt.*;

class CardTestPanel extends JPanel{
    private Card c;

    public void setCard(Card ca){ c = ca; }

    public Card getCard() { return c; }

    CardTestPanel(){
        c = new Card();
    }

    CardTestPanel(Card ca){
        c = ca;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        c.setWidth(panelWidth / 4);
        c.setX(50);
        c.setY(50);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, panelWidth, panelHeight);

        c.paintCardStandard(g);
    }
}

public class ScuffedPoker{

    public static void printHand(Game g){
        System.out.print("Hand: ");
        for (int i = 0; i < g.getHand().size(); i++){
            System.out.print(g.getHand().get(i) + "; ");
        }
    }
    public static void main(String args[]){
        System.out.println("Coming soon: Poker!");

        Game testGame = new Game();
        System.out.println("Creating new deck with 4 suites of 13 numbers.");
        testGame.customDeck(13, 4);
        testGame.shuffle();
        System.out.println(testGame);
        System.out.println("Dealing 5 cards from deck.");
        testGame.deal(5);
        System.out.println(testGame);

        System.out.println("Printing cards in hand and deck.");
        printHand(testGame);

        /* System.out.print("\nDeck: ");
        for (int i = 0; i < testGame.getDeck().size(); i++){
            System.out.print(testGame.getDeck().get(i) + "; ");
            if ((i + 1) % 5 == 0)
                System.out.print("\n");
        } */

        System.out.println("\nDiscarding 2 cards.");
        int throwOut[] = {1,4};
        testGame.discard(throwOut);
        printHand(testGame);

        System.out.println("\nPainting the game board.");
        PokerFrame testCardFrame = new PokerFrame();
        /* JFrame testCardFrame = new JFrame();
        testCardFrame.setTitle("Card");
        testCardFrame.setBounds(100, 100, 250, 350);
        testCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cardPane = testCardFrame.getContentPane();
        cardPane.add(new CardTestPanel(testGame.getHand().get(2))); */

        testCardFrame.setVisible(true);
    }
}