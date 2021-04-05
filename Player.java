import java.util.*;

public class Player{
    private Engimon Active;
    private Inventory<Engimon> ownedEngimon;
    private Inventory<Item> skillItems;
    private Point playerPos;

    public Player(Engimon E){
        this.Active = E;
        this.playerPos = new Point();
    }

    public Point getPos(){
        return playerPos;
    }

    public void showActiveDetail(){
        Active.showDetail();
    }

    public Engimon getActive(){
        return Active;
    }

    public void showItem(){
        skillItems.Show();
    }
}