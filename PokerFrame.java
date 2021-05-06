import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PokerFrame extends JFrame implements ActionListener{
    private final String helpText = "Click on a card to discard it.\nClick it again to change" +
                                    "your mind.\nClick the deck to deal cards.";
    private GamePanel poker;
    private JMenuBar pokerMenu;
    private JMenu gameOptions, displayOptions;
    private JMenuItem newGame, exitGame, help;
    private Container pokerContainer;
    private boolean reset;

    public boolean getReset(){ return reset; }

    public void setReset(boolean r){ reset = r; }

    public GamePanel getPanel(){ return poker; }

    PokerFrame(){
        setTitle("Scuffed Poker");
        setBounds(50, 50, 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pokerMenu = new JMenuBar();
        gameOptions = new JMenu("Game");
        displayOptions = new JMenu("Settings");
        newGame = new JMenuItem("New game");
        exitGame = new JMenuItem("Exit");
        help = new JMenuItem("Help");
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
        help.addActionListener(this);
        gameOptions.add(newGame);
        gameOptions.add(exitGame);
        displayOptions.add(help);
        pokerMenu.add(gameOptions);
        pokerMenu.add(displayOptions);

        poker = new GamePanel();
        pokerContainer = getContentPane();
        pokerContainer.add(pokerMenu);
        pokerContainer.add(poker);
        setJMenuBar(pokerMenu);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == newGame){
            poker.resetGame(true);
            reset = true;
        }
        if (e.getSource() == exitGame){
            System.exit(0);
        }
        if (e.getSource() == help){
            JOptionPane.showMessageDialog(this, helpText, "Help", JOptionPane.PLAIN_MESSAGE);
        }
    }


}
