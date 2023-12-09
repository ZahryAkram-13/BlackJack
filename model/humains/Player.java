package blackjack.model.humains;


public class Player extends Personne {

    private double mise;
    private double fortune;
    private int occurence;

    public Player(String name, double mise){
        super(name);
        this.fortune = 10000;
        this.mise = mise;
        this.fortune -= this.mise;
        this.occurence = 1;
    }

    public double getMise(){
        return this.mise;
    }

    public void doubleMise(){
        this.fortune -= this.mise;
        this.mise *= 2;
        this.fireChange();
    }

    public double getFortune(){
        return this.fortune;
    }

    public void setFortune(double fortune){
        this.fortune += fortune;
        this.fireChange();
    }

}
