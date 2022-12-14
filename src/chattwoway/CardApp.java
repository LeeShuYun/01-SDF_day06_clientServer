package chattwoway;

public class CardApp {
    public static void main(String[] args){
        CardDeck cardDeck = new CardDeck();
        String card = cardDeck.getUniqueCard();
        System.out.println(card);
        
    }
}
