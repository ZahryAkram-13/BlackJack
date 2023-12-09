/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cartes.observer;

/**
 *
 * @author 22012583
 */

/**
 * Interface pour l'ajout et le retrait d'EcouteurModele
 */
public interface ModeleEcoutable {

  /**
   * Ajouter e à une list ou un set
   * @param e : EcouteurModele
   */
  void ajoutEcouteur(EcouteurModele e);

  /**
   * Supprimer e depuis une liste ou un set
   * @param e : EcouteurModele
   */
  void retraitEcouteur(EcouteurModele e);

}
