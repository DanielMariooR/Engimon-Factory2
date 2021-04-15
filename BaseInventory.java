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