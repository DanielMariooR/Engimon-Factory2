import java.util.*;

public class CharmanPikamon implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Fire");
        elem.add("Electric");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("ThunderBolt", elem, 50, 1);
        Skill S2 = new Skill("Thunder Blaze", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("CharmanPikamon", "Being called the Operator of Overloading, I shalt overload anything! ", pn, ps, skillset, "CharmanPikamon", elem, 3, 1, 100, 100, P);

    }
}