import java.util.Scanner;
import java.io.File;
import java.util.*;

class Map {
    private Player player;
    private WildEngimon wild;
    public char[][] tiles;
    public HashSet<Point> forbiddenPoints;

    public Map(){
        this.player = new Player();
        this.wild = new WildEngimon();
        this.tiles = new char[20][15];
        forbiddenPoints = new HashSet<>();
        forbiddenPoints.add(new Point(14,14));
        forbiddenPoints.add(new Point(14,11));
        forbiddenPoints.add(new Point(14,0));
        forbiddenPoints.add(new Point(0,19));

    }

    public Map(String filepath) {
        tiles = new char[20][15];
        try{
            Scanner input = new Scanner(new File(filepath));
            int row  = 20;
            int columns = 15;

            while(input.hasNextLine()){
                for(int i=0; i<row; i++){
                    String line = input.nextLine();
                    for(int j=0; j<columns; j++){
                        tiles[i][j] = line.charAt(j);
                    }
                }
            }

            wild = new WildEngimon();
            forbiddenPoints = new HashSet<>();
            forbiddenPoints.add(new Point(14,14));
            forbiddenPoints.add(new Point(14,11));
            forbiddenPoints.add(new Point(14,0));
            forbiddenPoints.add(new Point(0,19));
        } catch(Exception e){
            System.out.println("File Not found error bro!");
        }
    }

    public void setPlayer(Player P){
        this.player = P;
    }

    public WildEngimon getWildEngimon(){
        return this.wild;
    }

    public void setWild(WildEngimon wild){
        this.wild = wild;
    }

    public void setTile(char[][] tiles){
        this.tiles = tiles;
    }

    public Player getPlayer(){
        return this.player;
    }


    public void movePlayer(int dx, int dy) throws InvalidMoveException{
        if(isMoveValid(getPlayerX()+dx, getPlayerY()+dy)){
            int x = getPlayerX();
            int y = getPlayerY();
            Point temp = new Point(x,y);
            player.changePosition(dx, dy);
            moveActiveEngimon(temp);
        } else {
            throw new InvalidMoveException();
        }
    }
    
    public Engimon isWild() {
        for(Engimon eng: wild.getEngimonList()){
            if( eng.getPos().getX() == player.getPos().getX() && eng.getPos().getY() == player.getPos().getY()+1){
                return eng;
            }
        }
        return null;
    }

    public void addEngimon(Engimon anEngimon) {
        wild.addWildEngimon(anEngimon);
    }

    public void moveActiveEngimon(Point playerPos) {
        player.getActive().setPos(playerPos);
    }

    public boolean isMoveValid(int x, int y){
        if(x <= 14 && x >=0 && y<=19 && y>=0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isForbidden(Point P){
        for(Point point: forbiddenPoints){
            if(point.isEqual(point, P)){
                return true;
            }
        }

        return false;
    }

    public boolean isMoveValidEngimon(int x, int y){
        if(x <= 14 && x>=0 && y<=19 && y>= 0){
            if(getPlayerX() != x && getPlayerY() != y && player.getActive().getPos().getX() != x && player.getActive().getPos().getY() != y){
                for(Engimon eng: wild.getEngimonList()){
                    if( eng.getPos().getX() == x && eng.getPos().getY() == y){
                        return false;
                    }
                }
                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean isTileValid(Engimon E, int x, int y){
        char tile = tiles[y][x];
        boolean temp = true;
        for(String element: E.getElem()){
            if(tile == '-'){
                temp = (element.equals("Ground") || element.equals("Electric"));
            } else if(tile == 'o'){
                temp = element.equals("Water");
            } else if(tile == '^'){
                temp = element.equals("Fire");
            } else if(tile == '#'){
                temp = element.equals("Ice");
            }

            if(temp) break;
        }

        return temp;
    }


    public void moveWildEngimon(Engimon E, Random rand) throws InvalidMoveException{

        int dx = rand.nextInt(3) - 1;
        int dy = rand.nextInt(3) - 1;

        if(isMoveValidEngimon(E.getPos().getX()+dx, E.getPos().getY()+dy) && isTileValid(E, E.getPos().getX()+dx, E.getPos().getY()+dy) && !isForbidden(new Point(E.getPos().getX()+dx, E.getPos().getY()+dy))){
            E.move(dx, dy);
            System.out.println(dx);
            System.out.println(dy);
            System.out.println(E.getPos().getX());
            System.out.println(E.getPos().getY());
        } else {
            throw new InvalidMoveException();
        }
    }

    public void moveAllWild(){
        Random rand = new Random();
        int count = 0;
        for(Engimon E: wild.getEngimonList()){
            count = 0;

            while(count < 3){
                try{
                    moveWildEngimon(E, rand);
                    break;
                } catch(InvalidMoveException err) {
                    count++;
                }
            }
        }
    }


    public int getPlayerX(){
        return player.getPos().getX();
    }

    public int getPlayerY(){
        return player.getPos().getY();
    }

    public char[][] getTile(){
        return this.tiles;
    }


}
