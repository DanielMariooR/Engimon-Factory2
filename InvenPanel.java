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


public class InvenPanel extends JPanel{
    private Image mountain;

    public InvenPanel(){
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/ice.png");
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        int i=0;
        int j=0;
        while(i<20){
            while(j<15){
                g.drawImage(mountain, j*32, i*32, this);
                j++;
            }
            i++;
            j = 0;
        }
        Toolkit.getDefaultToolkit().sync();
    }

}
