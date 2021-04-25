import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.ActionMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


import java.awt.event.*;
import java.util.HashMap;


public class GameCanvas extends JPanel{
    private Image grass;
    private Image water;
    private Image mountain;
    private Image tundra;
    private Image character;
    private Image engimon;
    private HashMap<Character, Image> image = new HashMap<>();
    private Map objects;
    private Timer timer;
    private int turn;

    public GameCanvas(Map m){
        
        
        grass = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/grass.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/water.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/mountain.png");
        tundra = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/ice.png");
        character = Toolkit.getDefaultToolkit().getImage("resource/tiles/char.png");
        engimon = Toolkit.getDefaultToolkit().getImage("resource/tiles/pokemon.png");
        image.put('-', grass);
        image.put('o', water);
        image.put('^', mountain);
        image.put('#', tundra);
        this.objects = m;
        addBinding();
        timer = new Timer(10, new TimerListener());
        timer.start();
    }

    private void addBinding(){
        int condition = WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();
        KeyStroke keyPressed;

        keyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
        inputMap.put(keyPressed, "moveleft");
        actionMap.put("moveleft", new KeyAction(-1,0));

        keyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        inputMap.put(keyPressed, "moveright");
        actionMap.put("moveright", new KeyAction(1, 0));

        keyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
        inputMap.put(keyPressed, "moveup");
        actionMap.put("moveup", new KeyAction(0, -1));

        keyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
        inputMap.put(keyPressed, "movedown");
        actionMap.put("movedown", new KeyAction(0, 1));
    }

    class KeyAction extends AbstractAction{
        private int dy;
        private int dx;

        public KeyAction(int dx, int dy){
            this.dy = dy;
            this.dx = dx;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                objects.movePlayer(dx, dy);
            } catch (InvalidMoveException err){
                err.message();
            }
            
            if(turn == 3){
                turn = 0;
                if(objects.getWildEngimon().getListSize() < 6){
                    //objects.getWildEngimon().spawn(5);
                }
                objects.moveAllWild();
            } else {
                turn++;
            }
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        int i=0;
        int j=0;
        while(i<20){
            while(j<15){
                g.drawImage(image.get(objects.tiles[i][j]), j*32, i*32, this);
                j++;
            }
            i++;
            j = 0;
        }
        g.drawImage(character, objects.getPlayerX()*32, objects.getPlayerY()*32, this);
        g.drawImage(engimon, objects.getPlayer().getActive().getPos().getX()*32, objects.getPlayer().getActive().getPos().getY()*32 , this);
        for(Engimon E : objects.getWildEngimon().getEngimonList()){
            g.drawImage(engimon, E.getPos().getX()*32, E.getPos().getY()*32 , this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

}
