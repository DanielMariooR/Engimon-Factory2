import java.util.ArrayList;

public class Dwintamon implements Spesies {

    public Engimon initSpesies(){
        ArrayList<String> elem = new ArrayList<>();
        elem.add("Ground");

        ArrayList<String> pn = new ArrayList<>();
        ArrayList<String> ps = new ArrayList<>();

        Skill S1 = new Skill("Ground break", elem, 50, 1 );
        Skill S2 = new Skill("Spike blast", elem, 150, 1);
        Skill S3 = new Skill("Earth canonball", elem, 1000, 1);
        ArrayList<Skill> skillset = new ArrayList<>();
        skillset.add(S1);
        skillset.add(S2);
        skillset.add(S3);

        Point P = new Point(0,0);

        return new Engimon("Dwintamon", "Crashing deep into the ground!", pn, ps, skillset, "Dwintamon", elem, 3, 1, 100, 100, P);
    }
}