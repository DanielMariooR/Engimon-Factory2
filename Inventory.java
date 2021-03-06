import java.util.*;

public class Inventory<T> extends BaseInventory{
    private ArrayList<T> inv;

    public Inventory(){
        super();
        inv = new ArrayList<>();
    }

    public List<T> getInv(){
        return this.inv;
    }

    public void keluar(T outItem){
        if(!inv.isEmpty()){
            inv.remove(outItem);
            decr();
        } 
    }

    public void masuk(T inItem){
        if(size < 19){
            inv.add(inItem);
            fill();
        } 
    }

    public T getItem(int idx){
        return inv.get(idx);
    }

    public T getItem(T searchItem){
        for(T item: inv){
            if(item.equals(searchItem)){
                return item;
            }
        }
        return null;
    }

    public boolean itemExist(T item){
        return inv.contains(item);
    }

    public void show(){
        int idx = 1;
        for(T item: inv){
            System.out.printf("%d. %s%n", idx, item.toString());
            idx++;
        }
    }

    public static void showEngi(List<? extends Engimon> list){
        String str = "";
        for (Engimon engi : list) {
            engi.showDetail();
        }
    }
    
    public static void showItem(List<? extends Item> list){
        for (Item it : list) {
            System.out.println(it.getSkill().getName());
        }
    }
    public String showStr(){
        String out = "";
        int idx =1;
        for (T item : inv) {
            out+= idx +". " + item.toString() + "\n";
            idx++;
        }
        return out;
    }

    

}