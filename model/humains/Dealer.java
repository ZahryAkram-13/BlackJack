package blackjack.model.humains;


public class Dealer extends Personne {

    public Dealer(String name) {
        super(name);
    }
    
    public  void showCard(){
        this.listCards.get(1).setHidden(); //position 2
        this.fireChange();
    }
    
    
    public String toString(){
        return super.toString();
    }

   
}