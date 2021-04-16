import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.text.Position;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Map {
    private Player player;
    private List<Engimon> wildEngimons;
    public char[][] tile;


    public Map(String filepath) {
        tile = new char[20][15];
        try{
            Scanner input = new Scanner(new File(filepath));
            int row  = 20;
            int columns = 15;

            while(input.hasNextLine()){
                for(int i=0; i<row; i++){
                    String line = input.nextLine();
                    for(int j=0; j<columns; j++){
                        tile[i][j] = line.charAt(j);
                    }
                }
            }
        } catch(Exception e){
            System.out.println("File Not found error!");
        }
    }

    public void setPlayer(Player P){
        this.player = P;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void movePlayer(int dx, int dy){
        if(isMoveVaild(getPlayerX()+dx, getPlayerY()+dy)){
            int x = getPlayerX();
            int y = getPlayerY();
            Point temp = new Point(x,y);
            player.changePosition(dx, dy);
            moveActiveEngimon(temp);
        }
        
    }

    public void addEngimon(Engimon anEngimon) {
        wildEngimons.add(anEngimon);
        System.out.println();
    }

    public void moveActiveEngimon(Point playerPos) {
        player.getActive().setPos(playerPos);
    }

    public boolean isMoveVaild(int x, int y){
        if(x <= 14 && x >=0 && y<=19 && y>=0){
            return true;
        }else {
            return false;
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