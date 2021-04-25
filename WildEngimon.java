import java.util.ArrayList;
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
                E = new Engimon();
                break;
            case 2:
                E = new Engimon();
                break;
            case 3:
                E = new Engimon();
                break;
            case 4:
                E = new Engimon();
                break;
            case 5:
                E = new Engimon();
                break;
            case 6:
                E = new Engimon();
                break;
            case 7:
                E = new Engimon();
                break;
            case 8:
                E = new Engimon();
                break;
            case 9:
                E = new Engimon();
                break;
            case 10:
                E = new Engimon();
                break;
            default:
                E = new Engimon();
                System.out.println("");
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
        for(Engimon E: engimonList){
            E.incrExp(100);
            if(E.getLevel() > 15){
                delWildEngimon(E);
            }
        }
    }

    public int getListSize() {
        return engimonList.size();
    }
}