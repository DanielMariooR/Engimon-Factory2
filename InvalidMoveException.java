public class InvalidMoveException extends Exception {
    public InvalidMoveException(){
        super("Invalid Move\n");
    }

    public void message(){
        System.out.println("Invalid Move\n");
    }
}
