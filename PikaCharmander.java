import java.util.*;

public class PikaCharmander implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Electric");
        elem.add("Fire");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("Fire ball", elem, 50, 1);
        Skill S2 = new Skill("Fiery 100k Volt", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("PikaCharmander", "My Fire will Electro-Cute our enemies", pn, ps, skillset, "PikaCharmander", elem, 3, 1, 100, 100, P);

    }
}
