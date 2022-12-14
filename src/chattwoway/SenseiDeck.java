package chattwoway;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SenseiDeck {
    
    public static final String[] SUITS = {"Spade", "Diamond", "Clubs", "Heart"};
    public static final String[] CARD_NAME = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
    "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    public static final Integer[] CARD_VALUES= {
        1, 2, 3, 4, 5, 6, 7,
        8, 9, 10, 10, 10, 10
    };

    private List<SenseiCard> cards = new LinkedList<>();

    public SenseiDeck(){

    }

    //optional for when there's no cards in a deck
    public Optional<Card> take(){

        if (cards.size() > 0){
            SenseiCard c = cards.remove(0);
            return Optional.of(c);
        }
        return Optional.empty();
    }
}
