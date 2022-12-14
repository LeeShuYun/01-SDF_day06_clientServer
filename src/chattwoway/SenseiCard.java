package chattwoway;

public class SenseiCard {
    private final String suit;
    private final String name;
    private final Integer value;

    public SenseiCard(String suit, String name, Integer value){
        //final instance variables must be set inside the constructor
        //because they can't be changed
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }
    public String getName() {
        return name;
    }
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Card [suit=" + suit + ", name=" + name + ", value=" + value + "]";
    }

    
}
