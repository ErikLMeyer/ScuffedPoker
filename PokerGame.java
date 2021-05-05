public class PokerGame extends Game{
    private int bank;
    private int bet;
    private int credit;

    public int getBank(){ return bank; }

    public int getBet(){ return bet; }

    public int getCredit(){ return credit; }

    public void setBank(int b){ bank = b; }

    public void setBet(int b){ bet = b; }

    public void setCredit(int c){ credit = c; }

    public void resetCards(){
        hand.clear();
        deck.clear();
    }

    public void distribute(){
        shuffle();
        deal(5);
    }

    private int isStraight(int nums[]){
        int inARow = 0;
        boolean hasAce = (nums[0] >= 1 ) ? true : false;
        for (int n = 0; n < nums.length; n++){
            if (nums[n] > 1){
                return 0; //not a straight
            } else{
                inARow = (nums[n] == 1) ? inARow + 1: 0;
                if (inARow == 5){ return 1; }
            }
        }
        return (inARow == 4 && hasAce) ? 2 : 0;
    }

    public int scanHand(){
        int nums[] = new int[13];
        int suis[] = new int[4];

        // should not be > 2
        int pairs = 0;

        boolean triple = false;
        boolean four = false;

        boolean allSuit = false;

        for (Card cards : this.hand){
            suis[cards.getSuite()] += 1;
            nums[cards.getNumber() - 1] += 1;
        }

        for (int s = 0; s < suis.length; s++){
            if (suis[s] == 5){
                allSuit = true;
            }
        }

        if (allSuit){
            switch (isStraight(nums)){
                case 0:
                    // Simply a Flush
                    return 5;
                case 1:
                    // Straight Flush
                    return 8;
                case 2:
                    // Royal Flush. Very impressive
                    return 9;
                default:
                    return -1;
            }
        }

        for (int n = 0; n < nums.length; n++){
            switch(nums[n]){
                case 2:
                    pairs++;
                    break;
                case 3:
                    triple = true;
                    break;
                case 4:
                    four = true;
                    break;
                default:
                    break;
                
            }
        }

        if (pairs == 0){
            if (triple){ return 3; } // Three of a kind
            if (four){ return 7; } // Four of a kind
            return (isStraight(nums) >= 1) ? 4 : 0; // Straight or nothing
        } else{
            if (pairs > 1){
                return 2; // Two pair
            } else{
                if (triple){ return 6;} // Full House
                if (nums[0] == 2 || nums[10] == 2 || nums[11] == 2 || nums[12] == 2){
                    return 1; // Pair of Jacks or Better
                }
            }
        }

        return 0; // Nothing
    }

    PokerGame(int b){
        super();
        bank = b;
        customDeck(13, 4);
    }

    public String toString(){
        return "Current funds: " + bank + "\nCurrent bet: " + bet;
    }
}
