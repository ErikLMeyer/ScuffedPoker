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
        } while(invalidInput);
        p.getPanel().getGame().setBet(bet);
        p.getPanel().getGame().setBank(bank - bet);
    }

    public static void main(String args[]){
        System.out.println("Coming soon: Poker!");
        PokerFrame testCardFrame = new PokerFrame();
        int handCounter = 0;
        boolean inDebt = false;
        testCardFrame.setVisible(true);
        while(true){
            System.out.println("Get bet");
            getBet(testCardFrame);
            System.out.println("Deal cards");
            testCardFrame.getPanel().resetGame();
            System.out.println("Wait for user to select cards.");
            while(!testCardFrame.getPanel().getAccepted()){
                // This doesn't work unless I have a print for some reason.
                System.out.print("");
                continue;
            }
            System.out.println("User has selected.");
            testCardFrame.getPanel().setAccepted(false);
            // calculate winnings or subtract loser's bet from bank
        }
    }
}