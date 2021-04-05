import java.util.*;

public class Item{
    private Skill skill;
    private int jumlah;

    public Item(){
        this.jumlah = 0;
    }

    public Item(String name, int power, List<String> elements){
        skill = Skill(name, power, 1, elements);
    }

    
}