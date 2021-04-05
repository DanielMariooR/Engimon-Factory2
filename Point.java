public class Point {
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public boolean isEqual(Point P1, Point P2){
        return (P1.getX() == P2.getX() && P1.getY() == P2.getY());
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public voidsetY(int y){
        this.y = y;
    }
}
