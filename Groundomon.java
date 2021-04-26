
import java.util.ArrayList;
public class Groundomon implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Ground");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("Ground Pound", elem, 50, 1);
        Skill S2 = new Skill("Earth Quake", elem, 150, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("Groundomon", "SMASH!!!!!", pn, ps, skillset, "Groundomon", elem, 3, 1, 100, 100, P);

    }
}
