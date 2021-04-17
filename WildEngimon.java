import java.util.ArrayList;
import java.util.List;

public class WildEngimon {
    private ArrayList<Engimon> engimonList;

    public WildEngimon() {
        engimonList = new ArrayList<Engimon>();
    }

    public void addWildEngimon(Engimon engimon) {
        engimonList.add(engimon);
    }

    public void delWildEngimon(Engimon engimon) {
        if(this.isEngimonPresent(engimon.getPos()) != null) {
            engimonList.remove(engimon);
        }
    }

    public List<Engimon> getEngimonList(){
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

    public int getListSize() {
        return engimonList.size();
    }
}