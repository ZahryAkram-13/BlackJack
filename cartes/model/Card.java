package cartes.model;

import cartes.observer.AbstractModeleEcoutable;

/**
 * Classe permet de modéliser une carte
 */
public class Card extends AbstractModeleEcoutable{

    private String num, color;
    private boolean hidden;

    /**
     * Constructeur
     * @param num qui représente le numéro de la carte
     * @param color qui représente la couleur de la carte
     */
    public Card(String num, String color){
        this.num = num;
        this.color = color; 
        this.hidden = false;
    }
    
    /**
     * Accesseur a la couleur
     * @return la couleur de la carte
     */
    public String getColor() {
        return color;
    }

    /**
     * Accesseur au numero de la carte
     * @return le numero de la carte
     */
    public String getNum(){
        return this.num;
    }
    
    /**
     * Accesseur a l'attribut hidden qui decrit si la carte est caché ou pas
     * @return 
     */
    public boolean getHidden(){
        return this.hidden;
    }
    
    /**
     * La méthode montre la carte caché
     */
    public void showCard(){
        this.hidden = true;
        this.fireChangement();
    }
    
    @Override
    public String toString(){
        if(this.hidden) 
            return this.num + " " + this.color;
        return "hidden card";
    }
    
    /**
     * Modificateur de l'attribut hidden de la carte
     */
    public void setHidden() {
        this.hidden = !this.hidden;
        this.fireChangement();
    }
  
}

