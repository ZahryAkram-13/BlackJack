package blackjack.model;

import cartes.model.Card;

/**
 * L'interface ManipulateCards définit les fonctions manipulant les cartes
 */
public interface ManipulateCards
{
    /**
     * La méthode suppriment toutes les cartes en main du joueur
     */
    public void clearCards();
    /**
     * La méthode ajoute une carte à la main du joueur
     * @param card : une Carte Card
     */
    public void addCard(Card card);
  
}
