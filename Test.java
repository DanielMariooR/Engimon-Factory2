import java.util.*;

public class Test {
    public HashSet<Point> forbiddenPoints;
    public Test(){
        forbiddenPoints = new HashSet<>();
        forbiddenPoints.add(new Point(14,14));
        forbiddenPoints.add(new Point(14,11));
        forbiddenPoints.add(new Point(14,0));
        forbiddenPoints.add(new Point(0,19));
    }

    public void show(){
        for(Point P: forbiddenPoints){
            System.out.println(P.getX());
            System.out.println(P.getY());
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show();
    }
}
