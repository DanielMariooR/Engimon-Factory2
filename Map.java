import java.util.ArrayList;
import java.util.List;

class Map {
    private Player player;
    private List<Engimon> wildEngimons;
    private final int mapLength = 20;

    public Map(Player player) {
        this.player = player;
        wildEngimons = new ArrayList<Engimon>();
    }
    public void addEngimon(Engimon anEngimon) {
        wildEngimons.add(anEngimon);
        System.out.println();
    }
    public void showMap() {
        /*
        for(int i = 0; i < 10; ++i) {
           for(int j = 0; j < mapLength; ++j) {
                if(j < 10) {
                    System.out.print('- ');
                }
                else {
                    System.out.print('O ');
                } 
            }
            System.out.println();
        }
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < mapLength; ++j) {
                System.out.println('- ');
            }
            System.out.println();
        }
        */
    }
    public void movePlayer() {

    }
    public void moveEngimon(int index) {
        // index adalah index wild engimon di list wildEngimons.
    }
}