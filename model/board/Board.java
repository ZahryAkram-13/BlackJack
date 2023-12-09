package blackjack.model.board;

import cartes.model.Packet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import blackjack.model.board.iterator.PlayersIterator;

import cartes.model.Card;

import blackjack.model.humains.Dealer;

import blackjack.model.humains.Player;


import blackjack.utils.AbstractListenableModel;

/**

 * La classe Board présente la mise en place du plateu du jeu 

 */

public class Board extends AbstractListenableModel {

    public PlayersIterator iter;

    public List<Player> players;

    public Dealer alberto;

    public Packet packet;
    private Player currentPlayer; 
    private boolean finished ;

    /**

     * Constructeur

     * @param players : Liste de joueurs

     */

    public Board(List<Player> players) {

        this.iter = new PlayersIterator(players);

        this.players = players;

        this.packet = Packet.createPacket52();

        this.alberto = new Dealer("ALBERTO");
        this.currentPlayer = iter.getNext();//this.players.get(0);
        this.finished = false;
    }

    

    /**

     * 

     * @param player : joueur

     * @return true si le gagnant est le joueur player sinon false

     */

    public  boolean isWin(Player player) {

        return player.getScore() <= 21 && player.getScore() > this.alberto.getScore();

   }

    /**

     * 

     * @param player : joueur

     * @return true si le player a le meme score du dealer sinon false

     */

    public boolean scoreMatched(Player player){

        return this.alberto.getScore() == player.getScore();

    }
    /**
     * joue le choix du joueur courant
     * @param choice le choix du joueur
     */

    public void choice(String choice){
        switch(choice){
          case "HIT" :
              this.hit();
              
              break;
          case "PASS" :
             
        	  this.pass();
              break;
          case "DOUBLE" :
             this.doubled();
              break;
          
          case "rejouer" :
        	  this.replay();
        	  break;
          default :
        	  break;
      }

  }
    /**
     * passe le tour
     */
    public void turn(){
        this.iter = new PlayersIterator(this.players);
        while( this.iter != null && this.iter.hasNext()){
            Player current = this.iter.getNext();
            
            
        }

    }
    /**
     * double la mise et faire separer les carte du joueur en deux groupes
     * @param player 
     */
	public void split(Player player){
        int index = this.players.indexOf(player);
        this.players.add(index+1, new Player(this.players.get(index).getName(), this.players.get(index).getMise()));
        Card c = this.players.get(index).getListCards().remove(1);
        this.players.get(index+1).getListCards().add(c);
        this.players.get(index).setScore(-this.players.get(index).convertToValue(c));
        this.players.get(index+1).setScore(this.players.get(index+1).convertToValue(c));
       
       
    }   
    /**
     * distribue une carte pour le joueur courant
     */
    public void hit(){
    	Player player = this.currentPlayer;
        Card card = this.packet.takeCard();
        card.setHidden();
        
 
        player.addCard(card);
        System.out.println(card);
    }
    /**
     * passe le tour au joueur suivant
     */
    public void pass() {
    	this.setCurrentPlayer();
        if(this.currentPlayer == null) {
        	setIter();
            this.setCurrentPlayer();
        	setFinished();
        	albertosTurn();
        	gain();
        }
        fireChange();
    }
    /**
     * reinitialise le plateau de jeu à zéro
     */
    public void replay() {
    	setIter();
        while(iter != null  && iter.hasNext()){
            Player player = iter.getNext();
            player.clearCards();
        }
        alberto.clearCards();
        setIter();
        setCurrentPlayer();
        setFinished();
       
        inisializeBoard();
    }
    /**
     * double la mise du joueur courant
     */
    public void doubled() {
    	this.currentPlayer.doubleMise();
    }
    /**
     * 
     * @return le caissier
     */
	public Dealer getAlberto() {
		return alberto;
	}
	/**
	 * 
	 * @return le joueur courant
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	/**
	 * change le joueur courant vers le prochain joueur de la liste
	 */
	public void setCurrentPlayer() {
		this.currentPlayer = this.iter.getNext();
	}
	/**
	 * initialisation du plateau de jeux
	 */
	public void inisializeBoard(){

        
        this.packet.shuffle();
        this.burn5Cards();
        for(int i = 0; i < 2; i++){
        	
            this.firstDistribution();
        }
        this.alberto.showCard();
        
        fireChange();
    }

	/**
	 * distribue une carte pour chaque joueur
	 */
    public void firstDistribution(){
    	
        while(this.currentPlayer != null){
                Player current = this.currentPlayer;
                Card card = this.packet.takeCard();
                card.setHidden();
                current.addCard(card);
                this.setCurrentPlayer();
               
         }

        this.iter = new PlayersIterator(this.players);
        this.setCurrentPlayer();
        Card card = this.packet.takeCard();
        card.setHidden();
        this.alberto.addCard(card);

    }
    /**
     * ignore les 5 premieres carte du packet
     */
    public void burn5Cards(){
        for(int i = 0; i < 5; i++ ){
            this.packet.takeCard();
        }
    }
    /**
     * reinitialise l'iterateur de joueurs
     */
    public void setIter() {
		this.iter = new PlayersIterator(players);
	}

    /**
     * 
     * @return iter
     */
	public PlayersIterator getIter() {
		return iter;
	}


	/**
	 * 
	 * @return true si la prtie est finie , false sinon
	 */
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return this.finished;
	}
	/**
	 * altere la valeur de finished
	 */
	public void setFinished() {
		this.finished =! this.finished ;
	}

	/**
	 * 
	 * @return la liste des joueurs
	 */

	public List<Player> getPlayers() {
		
		return this.players;
	}
	/**
	 * joue le tour du caissier
	 */
	public void albertosTurn(){
        this.alberto.showCard();
       
        
        while(this.alberto.getScore() < 17){
            Card card = this.packet.takeCard();
            card.showCard();
            this.alberto.addCard(card);
            
        }
    }
	/**
	 * 
	 * @return un dictionnaire contenant chaque joueur et son status
	 */
	public Map<Player, String> winners(){
        Map<Player, String> winners = new HashMap<Player, String>();
        this.iter = new PlayersIterator(this.players);
        
        if(this.alberto.getScore() <= 21){
            while(iter != null  && iter.hasNext()){
                Player current = this.iter.getNext();
                if(this.scoreMatched(current))
                    winners.put(current, "EGALITE");
                else if (this.isWin(current)){
                    if(current.blackJack())
                        winners.put(current, "BLACKJACK");
                    else
                       winners.put(current, "WIN");
                }
                else{ 
                    if(this.alberto.blackJack())
                       
                    winners.put(current, "LOSE");
                }
            }
       }
        else{
           while(iter != null  && iter.hasNext()){
               Player current = this.iter.getNext();
               
               if(current.getScore() <= 21){
                   if(current.blackJack())
                       winners.put(current, "BLACKJACK");
                   winners.put(current, "WIN");
               }
               else
                   winners.put(current, "EGALITE");
           }
       }
       return winners;
    }
    /**
     * mise à jour de fortune de chaque joueur selon son status
     */
	
	public void gain(){
        Map<Player, String> winners = this.winners();
        PlayersIterator iter = new PlayersIterator(new ArrayList<Player>(winners.keySet()));
        while(iter != null  && iter.hasNext()){
            Player player = iter.getNext();
            String state = winners.get(player);
    
            switch(state){
                case "EGALITE" :
                    
                    System.out.println("YOU WIN 0.0$");
                    player.setFortune(player.getMise());
                    break;
                case "WIN" :
                   
                    System.out.println("YOU WIN " + player.getMise());
                    player.setFortune(2*player.getMise());
                    break;
                case "BLACKJACK" :
                   
                    System.out.println("YOU WIN " + 1.5 * player.getMise());
                    player.setFortune(2.5*player.getMise());
                    break;
                case "LOSE":
                	System.out.println("YOU LOSE :");
                    
                    break;
                    
            }
            
        }
    }

}
