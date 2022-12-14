package chattwoway;

import java.util.Optional;

public class SenseiMain {
    SenseiDeck deck = new SenseiDeck();


    
    Optional<SenseiCard> opt = deck.take();
    if (opt.isPresent()){
        //the danger of getting null returned is a exception
        //so we used optional so we can check if there's something or not
        SenseiCard c = deck.take();
        System.out.printf("suit: %s\n", c.getSuit());
        
    }
    //same as the above, but lamba way of writing it
    opt.ifPresent(c -> {
        System.out.printf("suit: %s\n", c.getSuit());

    }
}
