import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

public class WildEngimon {
    private ArrayList<Engimon> engimonList;
    private HashMap<String, Point> spawnPoints;

    public WildEngimon() {
        engimonList = new ArrayList<Engimon>();
        spawnPoints = new HashMap<>();
        spawnPoints.put("Ground", new Point(14,14));
        spawnPoints.put("Electric", new Point(14,14));
        spawnPoints.put("Fire", new Point(0,19));
        spawnPoints.put("Water", new Point(14,0));
        spawnPoints.put("Ice", new Point(14,11));
    }


    public void spawn(int level){
        // return some engimon with rng
        Random rand = new Random();
        int pick = rand.nextInt(11);
        Engimon E;

        switch(pick){
            case 1:
                Squirmon S = new Squirmon();
                E = S.initSpesies();
                break;
            case 2:
                Charmander C = new Charmander();
                E = C.initSpesies();
                break;
            case 3:
                Dinginmon D = new Dinginmon();
                E = D.initSpesies();
                break;
            case 4:
                Pikamon Pi = new Pikamon();
                E = Pi.initSpesies();
                break;
            case 5:
                DinginSquir DS = new DinginSquir();
                E = DS.initSpesies();
                break;
            case 6:
                PikaCharmander PC = new PikaCharmander();
                E = PC.initSpesies();
                break;
            case 7:
                Groundomon G = new Groundomon();
                E = G.initSpesies();
                break;
            case 8:
                GroundSquir GS = new GroundSquir();
                E = GS.initSpesies();
                break;
            default:
                Squirmon Sd = new Squirmon();
                E = Sd.initSpesies();
        }

        String elem = E.getElem().get(0);
        Point P = spawnPoints.get(elem);
        E.setPos(new Point(P.getX(), P.getY()));
        E.setLevel(level);
        addWildEngimon(E);
    }

    public void addWildEngimon(Engimon engimon) {
        engimonList.add(engimon);
    }

    public void delWildEngimon(Engimon engimon) {
        engimonList.remove(engimon);
    }

    public void delFromList(List<Engimon> deleteList){
        engimonList.removeAll(deleteList);
    }

    public ArrayList<Engimon> getEngimonList(){
        return this.engimonList;
    }

    public Engimon isEngimonPresent(Point position) {
        // return Engimon jika ada Engimon dengan posisi sama dengan position di engimonList
        for(Engimon el: engimonList) {
            if(el.getPos().equals(position)) {
                return el;
            }
        }
        return null;
    }

    public void incrExpWild(){
        ArrayList<Engimon> delEngimonList = new ArrayList<>();
        for(Engimon E: engimonList){
            E.incrExp(100);
            if(E.getLevel() >= 5){
                delEngimonList.add(E);
            }
        }
        delFromList(delEngimonList);
    }

    public int getListSize() {
        return engimonList.size();
    }
}