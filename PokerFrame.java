import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PokerFrame extends JFrame implements ActionListener{
    private GamePanel poker;
    private JMenuBar pokerMenu;
    private JMenu gameOptions, displayOptions;
    private JMenuItem newGame, exitGame;
    private Container pokerContainer;

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
        newGame.addActionListener(this);
        exitGame.addActionListener(this);
        gameOptions.add(newGame);
        gameOptions.add(exitGame);
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
        }
        if (e.getSource() == exitGame){
            System.exit(0);
        }
    }


}
