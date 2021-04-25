import java.util.*;

public class Pikamon implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Electric");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("ThunderBolt", elem, 50, 1);
        Skill S2 = new Skill("100k Volt", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("Pikamon", "Pika Pika", pn, ps, skillset, "Pikamon", elem, 3, 1, 100, 100, P);

    }
}
