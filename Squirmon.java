import java.util.ArrayList;

public class Squirmon implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Water");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("water attack", elem, 50, 1);
        Skill S2 = new Skill("water bullet", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("Squirmon", "Let's fight strong engimons with my water power!", pn, ps, skillset, "Squirmon", elem, 3, 1, 100, 100, P);

    }
}
