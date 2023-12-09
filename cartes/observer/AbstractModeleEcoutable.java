/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes.observer;

/**
 *
 * @author 22012583
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Classe abstraite qui implémente l'interface ModeleEcoutable
 */
public abstract class AbstractModeleEcoutable implements ModeleEcoutable {

  //attributs
  protected List<EcouteurModele> ecouteurs;

  //constructeur

  /**
   * Initialise l'attributs ecouteurs à une liste vide
   */
  public AbstractModeleEcoutable(){
    this.ecouteurs = new ArrayList<EcouteurModele>();
  }

  @Override
  public void ajoutEcouteur(EcouteurModele e){
    this.ecouteurs.add(e);
  }

  @Override
  public void retraitEcouteur(EcouteurModele e){
    this.ecouteurs.remove(e);
  }

  /**
   * Fonction qui établie le lien entre le modèle et la vue, elle est responsable de la prévention des changement du modèle
   */
  public void fireChangement(){
    for(EcouteurModele e : this.ecouteurs)
      e.modeleMisAJour();
  }

}
