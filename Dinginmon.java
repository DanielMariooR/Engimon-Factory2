import java.util.ArrayList;

public class  Dinginmon implements Spesies{
    public Engimon initSpesies(){
        
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Ice");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("Cold Destruction", elem, 280, 1);
        Skill S2 = new Skill("Bitter Frost", elem, 50, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);

        Point P = new Point(0,0);

        return new Engimon("Dinginmon", "Lets froze together", pn, ps, skillset, "Dinginmon", elem, 3, 1, 100, 100, P);

    }
}

