package blackjack.model.humains;

import cartes.model.Card;
import java.util.*;
import blackjack.model.ManipulateCards;
import blackjack.utils.AbstractListenableModel;

public abstract class Personne extends AbstractListenableModel implements ManipulateCards {
    

    protected String name;
    protected  List<Card> listCards = new ArrayList<Card>();
    protected int score = 0;
  
    public Personne(String name){
        this.name = name;
    }
  
    public String getName() {
        return name;
    }
  
    public int getScore(){
        return this.score;
    }
  
    public List<Card> getListCards() {
        return listCards;
    }
  
    public int convertToValue(Card card){
        try{
            int number = Integer.parseInt(card.getNum()); //ca marche pas avec A K Q J
            return number;
        }
        catch(NumberFormatException e){
            if("A".equals(card.getNum())){
                if(this.score + 10 > 21) 
                    return 1;
                return 11;
            }
            return 10;
        }
    }
  
    public void setScore(int score){
        this.score += score;
    }
  
  
  
    @Override
    public void clearCards() {
        this.listCards.clear();
        this.score = 0;
        this.fireChange();
    }

    @Override
    public void addCard(Card card) {
        this.listCards.add(card);
        this.setScore(this.convertToValue(card));
        this.fireChange();
    }

  
    public boolean blackJack(){
        ArrayList<String> listNum = new ArrayList<String>();
        listNum.add(this.listCards.get(0).getNum());
        listNum.add(this.listCards.get(1).getNum());
        return this.listCards.size() == 2 && listNum.contains("A") && (listNum.contains("J") || listNum.contains("K") || listNum.contains("Q"));
    }
    
    public String toString(){
        return this.name + " " + this.listCards + " " + this.getScore();
    }

    
    
}
