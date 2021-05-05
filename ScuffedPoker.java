import javax.swing.*;
import java.awt.*;

public class ScuffedPoker{
    private static final String HAND_NAMES[] = {"nothing", "Jacks or Better", "Two Pairs",
                                                "Three of a Kind", "Straight", "Flush", "Full House",
                                                "Four of a Kind", "Straight Flush", "Royal Flush"};

    // Prints the hand belonging to a given Game object to the console
    public static void printHand(Game g){
        System.out.print("Hand: ");
        for (int i = 0; i < g.getHand().size(); i++){
            System.out.print(g.getHand().get(i) + "; ");
        }
    }

    public static boolean getBet(PokerFrame p){
        boolean invalidInput = false;
        String input;
        int bank = p.getPanel().getGame().getBank();
        int bet = 0;
        String boxMessage = "Current funds: " + bank + "\nPlace your bet:";
        do{
            invalidInput = false;
            try{
                input = JOptionPane.showInputDialog(p, boxMessage);
                if (input != null){
                    bet = Integer.parseInt(input);
                } else{
                    return false;
                }
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(p, "Error: bet must be a number.", "Invalid bet", 
                                                JOptionPane.PLAIN_MESSAGE);
                invalidInput = true;
                continue;
            }
            if (bet > bank){
                JOptionPane.showMessageDialog(p, "You cannot bet more than you have.", 
                                                "Invalid bet", JOptionPane.PLAIN_MESSAGE);
                invalidInput = true;
            }
            if (bet <= 0){
                JOptionPane.showMessageDialog(p, "Bets must be greater than 0.", 
                                                "Invalid bet", JOptionPane.PLAIN_MESSAGE);
                invalidInput = true;
            }
        } while(invalidInput);
        p.getPanel().getGame().setBet(bet);
        p.getPanel().getGame().setBank(bank - bet);
        return true;
    }

    public static void calcWin(PokerFrame p){
        int result = p.getPanel().getGame().scanHand();
        int bank = p.getPanel().getGame().getBank();
        int bet = p.getPanel().getGame().getBet();
        int winnings = 0;

        switch(result){
            case 0:
                winnings = bank;
                break;
            case 1:
                winnings = bank + bet;
                break;
            case 2:
                winnings = bank + 2 * bet;
                break;
            case 3:
                winnings = bank + 3 * bet;
                break;
            case 4:
                winnings = bank + 4 * bet;
                break;
            case 5:
                winnings = bank + 6 * bet;
                break;
            case 6:
                winnings = bank + 9 * bet;
                break;
            case 7:
                winnings = bank + 25 * bet;
                break;
            case 8:
                winnings = bank + 50 * bet;
                break;
            case 9:
                winnings = bank + 250 * bet;
                break;
            default:
                System.out.println("Calc win");
                break;
        }
    
        if (result == 0){
            JOptionPane.showMessageDialog(p, "You got " + HAND_NAMES[result], "You lose",
                                        JOptionPane.PLAIN_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(p, "You got " + HAND_NAMES[result] + "!", "You win!",
                                        JOptionPane.PLAIN_MESSAGE);
        }
        p.getPanel().getGame().setBank(winnings);
    }

    // Displays a dialog with the option to start a new game or to close program
    public static boolean exit_continue(PokerFrame p){
        int in = 0;
        String options[] = {"New Game", "Exit Program"};
        do{
            in = JOptionPane.showOptionDialog(p, "Game Over", "Quit?",
                                                JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.PLAIN_MESSAGE, null, options,
                                                options[0]);
        } while(in == JOptionPane.CLOSED_OPTION);
        if (in == 1){
            System.exit(0);
        }
        return true;
    }

    public static void main(String args[]){
        PokerFrame testCardFrame = new PokerFrame();
        /* int handCounter = 0;
        boolean inDebt = false; */
        testCardFrame.setVisible(true);
        while(true){
            if(!getBet(testCardFrame)){
                if (exit_continue(testCardFrame)){
                    testCardFrame.getPanel().resetGame(true);
                    continue;
                }
            }
            testCardFrame.getPanel().resetGame(false);
            while(!testCardFrame.getPanel().getAccepted()){
                // This doesn't work unless I have a print for some reason.
                System.out.print("");
                if (testCardFrame.getReset()){
                    break;
                }
                continue;
            }
            if (testCardFrame.getReset()){
                testCardFrame.setReset(false);
                continue;
            }
            testCardFrame.getPanel().setAccepted(false);
            calcWin(testCardFrame);
            if(testCardFrame.getPanel().getGame().getBank() <= 0){
                if (exit_continue(testCardFrame)){
                    testCardFrame.getPanel().resetGame(true);
                    continue;
                }
            }
        }
    }
}