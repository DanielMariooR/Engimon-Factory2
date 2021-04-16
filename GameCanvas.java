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


public class GameCanvas extends JPanel{
    private Image grass;
    private Image water;
    private Image mountain;
    private Image tundra;
    private Image character;
    private Image engimon;
    private Map objects;
    private Timer timer;

    public GameCanvas(Map m){
        
        grass = Toolkit.getDefaultToolkit().getImage("resource/tiles/grass.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/water.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/mountain.png");
        tundra = Toolkit.getDefaultToolkit().getImage("resource/tiles/ice.png");
        character = Toolkit.getDefaultToolkit().getImage("resource/tiles/char.png");
        engimon = Toolkit.getDefaultToolkit().getImage("resource/tiles/pokemon.png");

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
            objects.movePlayer(dx, dy);
            System.out.println("Pressed");
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
                if(objects.tile[i][j] == '-'){
                    g.drawImage(grass, j*32, i*32, this);
                } else if(objects.tile[i][j] == 'o'){
                    g.drawImage(water, j*32, i*32, this);
                } else if(objects.tile[i][j] == '^'){
                    g.drawImage(mountain, j*32, i*32, this);
                } else {
                    g.drawImage(tundra, j*32, i*32, this);
                }
                j++;
            }
            i++;
            j = 0;
        }
        g.drawImage(character, objects.getPlayerX()*32, objects.getPlayerY()*32, this);
        g.drawImage(engimon, objects.getPlayer().getActive().getPos().getX()*32, objects.getPlayer().getActive().getPos().getY()*32 , this);
        Toolkit.getDefaultToolkit().sync();
    }

}
