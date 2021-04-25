public class BaseInventory{
    protected static int size = 0;
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