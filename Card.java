import java.awt.*;

public class Card {
    public final Color SPADES_AND_CLUBS = Color.BLACK;
    public final Color HEARTS_AND_DIAMONDS = Color.RED;

    private int xPos;
    private int yPos;
    private int wide;

    private int number;
    private int suite;

    public int getNumber(){ return number; }

    public int getSuite(){ return suite; }

    public int getX(){ return xPos; }

    public int getY(){ return yPos; }

    public int getWidth(){ return wide; }

    public int getHeight(){ return (int)(wide * 1.4); }

    public void setX(int x){ xPos = x; }

    public void setY(int y){ yPos = y; }

    public void setWidth(int w){ wide = w; }

    public void setNumber(int n){ number = n; }

    public void setSuite(int s){ suite = s; }

    Card(){
        number = 0;
        suite = 0;
    }

    Card(int n, int s){
        setNumber(n);
        setSuite(s);
        xPos = 0;
        yPos = 0;
        wide = 0;
    }

    private void drawSymbols(Graphics g, String symS, String symN, Color suiteColor){
        int topAlign = yPos + (wide / 7);
        int leftAlign = xPos + (wide / 20);
        int rightAlign = xPos + (wide - (wide / 7));
        int bottomAlign = yPos + ((int)((wide * 1.4) - (wide / 20)));
        g.setColor(suiteColor);
        // Top left
        g.drawString(symS, leftAlign, topAlign);
        // Bottom right
        g.drawString(symS, rightAlign, bottomAlign);
        // Top right
        g.drawString(symN, rightAlign, topAlign);
        // Bottom left
        g.drawString(symN, leftAlign, bottomAlign);
    }

    private String getNumChar(){
        String num = "";
        switch(number){
            case 1:
                num = "A";
                break;
            case 11:
                num = "J";
                break;
            case 12:
                num = "Q";
                break;
            case 13:
                num = "K";
                break;
            default:
                num = "" + number;
                break;
        }
        return num;
    }

    public void paintCardStandard(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRoundRect(xPos, yPos, wide, (int)(wide * 1.4), wide / 10, wide / 10);
        switch (suite){
            case 0:
                drawSymbols(g, "S", getNumChar(), SPADES_AND_CLUBS);
                break;
            case 1:
                drawSymbols(g, "H", getNumChar(), HEARTS_AND_DIAMONDS);
                break;
            case 2:
                drawSymbols(g, "C", getNumChar(), SPADES_AND_CLUBS);
                break;
            case 3:
                drawSymbols(g, "D", getNumChar(), HEARTS_AND_DIAMONDS);
                break;
            default:
                System.out.println("Unsupported suite. Something went wrong. Suite = " + suite);
                break;
        }
    }

    public String toString(){
        return "Number: " + number + ", Suite: " + suite;
    }
}
