public class Card {
    private int number;
    private int suite;

    public int getNumber(){ return number; }

    public int getSuite(){ return suite; }

    public void setNumber(int n){ number = n; }

    public void setSuite(int s){ suite = s; }

    Card(){
        number = 0;
        suite = 0;
    }

    Card(int n, int s){
        setNumber(n);
        setSuite(s);
    }

    public String toString(){
        return "Number: " + number + ", Suite: " + suite;
    }
}
