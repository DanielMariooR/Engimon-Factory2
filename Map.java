import java.util.Scanner;
import java.io.File;
import java.util.Random;

class Map {
    private Player player;
    private WildEngimon wild;
    public char[][] tiles;


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
        } catch(Exception e){
            System.out.println("File Not found error!");
        }
    }

    public void setPlayer(Player P){
        this.player = P;
    }

    public WildEngimon getWildEngimon(){
        return this.wild;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void movePlayer(int dx, int dy){
        if(isMoveValid(getPlayerX()+dx, getPlayerY()+dy)){
            int x = getPlayerX();
            int y = getPlayerY();
            Point temp = new Point(x,y);
            player.changePosition(dx, dy);
            moveActiveEngimon(temp);
        }
        
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


    public void moveWildEngimon(){
        Random rand = new Random();
        
        for(Engimon E: wild.getEngimonList()){
            int dx = rand.nextInt(3) - 1;
            int dy = rand.nextInt(3) - 1;

            if(isMoveValidEngimon(E.getPos().getX()+dx, E.getPos().getY()+dy) && isTileValid(E, E.getPos().getX()+dx, E.getPos().getY()+dy)){
                E.move(dx, dy);
            }
        }
    }

    public List<Engimon> getWildEngimons(){
        return this.wildEngimons;
    }

    public int getPlayerX(){
        return player.getPos().getX();
    }

    public int getPlayerY(){
        return player.getPos().getY();
    }

    public char[][] getTile(){
        return this.tile;
    }

}