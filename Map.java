import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
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

    public void addEngimon(Engimon anEngimon) {
        wildEngimons.add(anEngimon);
        System.out.println();
    }

    public void moveEngimon(int index) {
        // index adalah index wild engimon di list wildEngimons.
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        int dx = 0;
        int dy = 0;
        if(key == KeyEvent.VK_LEFT){

        } 
        
        if(key == KeyEvent.VK_RIGHT){

        } 
        
        if(key == KeyEvent.VK_UP){

        } 

        if(key == KeyEvent.VK_DOWN){

        }
    }

}