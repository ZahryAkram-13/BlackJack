package cartes;

import cartes.model.Card;
import cartes.model.Packet;
import java.util.Scanner;

/**
 * Classe exécutable qui permet de voir le fonctionnement de la classe Card et Packet
 */
public class MainClass {
    
    public static void main (String[] args) {
        
        Packet pioche = Packet.createPacket52();
        pioche.shuffle();
        
        Packet mainJoueur = new Packet();
        
        Packet defausse = new Packet();
        
        Scanner scanner = new Scanner(System.in);
        
        boolean ok = true;
        
        System.out.println(" There's no cards in your packet !");
        do
        {
            System.out.println("Write TAKE to take a card\nWrite DELETE to delete a card from your packet\nWrite QUIT to quit");
            String input = scanner.nextLine();
            if(input.equals("QUIT"))
                ok = false;
            else if(input.equals("TAKE")){
                Card card = pioche.takeCard();
                card.showCard();
                mainJoueur.fillingPacket(card);
                System.out.println("your cards are : " + mainJoueur.getCards());
                System.out.println("Deleted cards are : " + defausse.getCards());
            }
            else if(input.equals("DELETE")){
                Card card = mainJoueur.takeCard();
                defausse.fillingPacket(card);
                System.out.println("your cards are : " + mainJoueur.getCards());
                System.out.println("Deleted cards are : " + defausse.getCards());
            }
            else {
                System.out.println("CHOICE NOT VALID, PLEASE TRY AGAIN");
            }
            
        }while(ok);
    }
    
}
