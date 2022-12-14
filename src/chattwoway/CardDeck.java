package chattwoway;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CardDeck {
    
    private String[] spadeList = {"Spade 1", "Spade 2", "Spade 3", "Spade 4", "Spade 5", "Spade 6"
    , "Spade 7", "Spade 8", "Spade 9", "Spade 10", "Spade Jack","Spade Queen", "Spade King"};

    private String[] diamondList = {"Spade 1", "Spade 2", "Spade 3", "Spade 4", "Spade 5", "Spade 6"
    , "Spade 7", "Spade 8", "Spade 9", "Spade 10", "Spade Jack","Spade Queen", "Spade King"};

    private String[] cloverList = {"Spade 1", "Spade 2", "Spade 3", "Spade 4", "Spade 5", "Spade 6"
    , "Spade 7", "Spade 8", "Spade 9", "Spade 10", "Spade Jack","Spade Queen", "Spade King"};

    private String[] heartList = {"Spade 1", "Spade 2", "Spade 3", "Spade 4", "Spade 5", "Spade 6"
    , "Spade 7", "Spade 8", "Spade 9", "Spade 10", "Spade Jack","Spade Queen", "Spade King"};
    
    private String[][] suitsList = {spadeList, diamondList, cloverList, heartList};

    private Map<String, Integer> uniqueCardTracker = new HashMap<>();
    // public CardDeck{}

    // pick a random card 
    public void getUniqueCard(){
    
        Random rand = new SecureRandom();
        //we get the suit
        String[] finalSuit = suitsList[rand.nextInt(3)];
        
        //generate a number between 0 to 12 for index picking
        Integer cardIdx = rand.nextInt(12);
        String uncheckedCard = finalSuit[cardIdx];
        String result = "";

        while (this.uniqueCardTracker.containsKey(uncheckedcard) == true){
            uniqueCardTracker.put(uncheckedCard, 1);
            result = uncheckedCard;
            break;
        }
        System.out.println("Here's your card! " + result);
        // return result;
    }



    // return all cards to the deck


    
}
