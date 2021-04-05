import java.util.ArrayList;

public class BaseInventory{
    protected static int size;
    public BaseInventory(){
        // BaseInvetory constructor
    }

    public static void fill(){
        size++;
    }

    public static void decr(){
        size--;
    }
}

public class Inventory<T> extends BaseInventory{
    private ArrayList<T> inv;

    public Inventory(){
        super();
        inv = new ArrayList<>();
    }

    public void keluar(T outItem){
        if(!inv.isEmpty()){
            inv.remove(outItem);
            decr();
        } else {
            throw "Inventory is empty";
        }
    }

    public void masuk(T inItem){
        if(size < 10){
            inv.add(inItem);
            fill();
        } else {
            throw "Inventory is full!";
        }
    }

    public T getItem(int idx){
        return inv.get(idx);
    }

    public boolean itemExist(T item){
        return inv.contains(item);
    }
}