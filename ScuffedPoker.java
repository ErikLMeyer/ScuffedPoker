import javax.swing.*;
import java.awt.*;

public class ScuffedPoker{

    public static void printHand(Game g){
        System.out.print("Hand: ");
        for (int i = 0; i < g.getHand().size(); i++){
            System.out.print(g.getHand().get(i) + "; ");
        }
    }

    public static void getBet(PokerFrame p){
        boolean invalidInput = false;
        String input;
        int bank = p.getPanel().getGame().getBank();
        int bet = 0;
        String boxMessage = "Current funds: " + bank + "\nPlace your bet:";
        do{
            invalidInput = false;
            try{
                input = JOptionPane.showInputDialog(p, boxMessage);
                bet = Integer.parseInt(input);
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
    
        p.getPanel().getGame().setBank(winnings);
    }

    public static void main(String args[]){
        PokerFrame testCardFrame = new PokerFrame();
        int handCounter = 0;
        boolean inDebt = false;
        testCardFrame.setVisible(true);
        while(true){
            getBet(testCardFrame);
            testCardFrame.getPanel().resetGame(false);
            while(!testCardFrame.getPanel().getAccepted()){
                // This doesn't work unless I have a print for some reason.
                System.out.print("");
                continue;
            }
            testCardFrame.getPanel().setAccepted(false);
            calcWin(testCardFrame);
        }

    }
}