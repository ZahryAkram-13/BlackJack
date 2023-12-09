package cartes.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cartes.observer.AbstractModeleEcoutable;

/**
 * La classe modélise un pacquet de carte
 */
public class Packet extends AbstractModeleEcoutable {
    
    public List<Card> cards;
    
    private final static List<String> colors = new ArrayList<String>(
        Arrays.asList("Trefle", "Carreau", "Pic", "Coeur")
    ); 

    private final static List<String> nums = new ArrayList<String>(
        Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    ); 
    
    /**
     * Constructeur
     */
    public Packet(){
        this.cards = new ArrayList<Card>();
    }
    
    /**
     * Accesseur a l'ensemble de cartes du paquet
     * @return l'ensemble des cartes du paquet
     */
    public List<Card> getCards() {
        return cards;
    }
    
    /**
     * Méthode pour ajouter une carte au pacquet
     * @param card Carte
     */
    public void fillingPacket(Card card){
        this.cards.add(card);
    }
    
    /**
     * Création d'un paquet qui contient 52 cartes
     * @return un pacquet de 52 cartes différentes
     */
    public static Packet createPacket52(){
      
        Packet packet = new Packet();
      
        for(String color : colors){
            for(String num : nums){
                packet.getCards().add(new Card(num, color));
            }
        }
        
        return packet;
    }
    
    /**
     * Méthode pour mélanger les cartes de manière aléatoir
     * @return Liste de cartes mélangées
     */
    public List<Card> shuffle(){
        Collections.shuffle(this.cards);
        return this.cards;
    }
    
    /**
     * Méthode pour tirer une carte 
     * @return la première carte du paquet s'il les contient sinon null
     */
    public Card takeCard(){
        if(!this.cards.isEmpty()){
            Card card = this.cards.remove(0);
            this.fireChangement();
            return card;
        }
        return null;
    }
   
    
    
}
