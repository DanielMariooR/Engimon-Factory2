import java.util.ArrayList;

public class GroundSquir implements Spesies {

    public Engimon initSpesies(){
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Ground");
        elem.add("Water");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("Sandstorm", elem, 50, 1 );
        Skill S2 = new Skill("water bullet", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("GroundSquir", "Let's burn everything on our path!", pn, ps, skillset, "GroundSquir", elem, 3, 1, 100, 100, P);
    }
}