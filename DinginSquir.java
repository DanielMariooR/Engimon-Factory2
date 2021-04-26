import java.util.ArrayList;

public class DinginSquir implements Spesies {

    public Engimon initSpesies(){
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Water");
        elem.add("Ice");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("water attack", elem, 50, 1 );
        Skill S2 = new Skill("Cold Destruction", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("DinginSquir", "Let's freeze the enemy!", pn, ps, skillset, "DinginSquir", elem, 3, 1, 100, 100, P);
    }
}
