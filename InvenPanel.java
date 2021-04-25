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
    private Image ice;

    private Image water;
    private Image fire;
    private Image electric;
    private Image ground;
    private Image icy;
    private Image felec;
    private Image gwat;
    private Image icewat;
    private Image skillinven;

    private Image mountain;
    private Inventory<Item> skillItem;
    private Inventory<Engimon> engimons;
    private Image engimon;
    private Timer timer;

    public InvenPanel(Inventory<Item> sk, Inventory<Engimon> engi){
        ice = Toolkit.getDefaultToolkit().getImage("resource/tiles/ice.png");
        engimon = Toolkit.getDefaultToolkit().getImage("resource/tiles/pokemon.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/mountain.png");
        fire = Toolkit.getDefaultToolkit().getImage("resource/tiles/fire.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/waterelement.png");
        electric = Toolkit.getDefaultToolkit().getImage("resource/tiles/electric.png");
        ground = Toolkit.getDefaultToolkit().getImage("resource/tiles/ground.png");
        icy = Toolkit.getDefaultToolkit().getImage("resource/tiles/icy.png");
        felec = Toolkit.getDefaultToolkit().getImage("resource/tiles/felec.png");
        gwat = Toolkit.getDefaultToolkit().getImage("resource/tiles/gwat.png");
        icewat = Toolkit.getDefaultToolkit().getImage("resource/tiles/icewat.png");
        skillinven = Toolkit.getDefaultToolkit().getImage("resource/tiles/skillinven.png");

        engimons = engi;
        skillItem = sk;
        timer = new Timer(10, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        int i=0;
        int j=1;
        int index = 0;
        int fi = 1; // Fire index
        int wi = 1; // water index
        int ei = 1; // electric index
        int gi = 1; // ground index
        int ii = 1; // ice index
        int fei = 1; // fireelectric index
        int wii = 1; // waterice index
        int gwi = 1; // groundwater index
        int[][] filled = new int[9][10];
        for (int k = 0; k <9; k++) {
            for (int k2 = 0; k2 < 10; k2++) {
                filled[k][k2] = 0;
            }
        }
        // Element + Skill icon  
        g.drawImage(fire, 0*32, 0*32, this); // Fire
        g.drawImage(water, 0*32, 1*32, this); // Water
        g.drawImage(electric, 0*32, 2*32, this); // Electric
        g.drawImage(ground, 0*32, 3*32, this); // Ground
        g.drawImage(icy, 0*32, 4*32, this); // Ice
        g.drawImage(felec, 0*32, 5*32, this); // Fire Electric
        g.drawImage(gwat, 0*32, 6*32, this); // Water Ground
        g.drawImage(icewat, 0*32, 7*32, this); // Water Ice
        g.drawImage(skillinven, 0*32, 8*32, this); // Skill

        // Engimon
        for (index =  0; index < engimons.getInv().size(); index++) {
            if(engimons.getInv().get(index).getElem().size() == 1){
                if(engimons.getInv().get(index).getElem().get(0) == "Fire"){g.drawImage(engimon, fi*32, 0*32, this);filled[0][fi] = 1; fi++;}
                else if(engimons.getInv().get(index).getElem().get(0) == "Water") {g.drawImage(engimon, wi*32, 1*32, this);filled[1][wi] = 1;wi++;}
                else if(engimons.getInv().get(index).getElem().get(0).equals("Electric")){g.drawImage(engimon, ei*32, 2*32, this);filled[2][ei] = 1;ei++;}
                else if(engimons.getInv().get(index).getElem().get(0) == "Ground"){g.drawImage(engimon, gi*32, 3*32, this);filled[3][gi] = 1;gi++;}
                else if(engimons.getInv().get(index).getElem().get(0) == "Ice"){g.drawImage(engimon, ii*32, 4*32, this);filled[4][ii] = 1;ii++;}
            }
            else if(engimons.getInv().get(index).getElem().size() == 2){
                if((engimons.getInv().get(index).getElem().get(0) == "Fire" && engimons.getInv().get(index).getElem().get(1) == "Electric")||(engimons.getInv().get(index).getElem().get(0) == "Electric" && engimons.getInv().get(index).getElem().get(1) == "Fire")){g.drawImage(engimon, fei*32, 5*32, this);filled[5][fei] = 1;fei++;}
                else if((engimons.getInv().get(index).getElem().get(0) == "Water" && engimons.getInv().get(index).getElem().get(1) == "Ground")||(engimons.getInv().get(index).getElem().get(0) == "Ground" && engimons.getInv().get(index).getElem().get(1) == "Water")){g.drawImage(engimon, gwi*32, 6*32, this);filled[6][gwi] = 1;gwi++;}
                else if((engimons.getInv().get(index).getElem().get(0) == "Water" && engimons.getInv().get(index).getElem().get(1) == "Ice")||(engimons.getInv().get(index).getElem().get(0) == "Ice" && engimons.getInv().get(index).getElem().get(1) == "Water")){g.drawImage(engimon, wii*32, 7*32, this);filled[7][wii] = 1;wii++;}
            }
        }
        // Skill
        for (int k = 0; k < skillItem.getInv().size(); k++) {
            g.drawImage(engimon, (k+1)*32, 8*32, this);
            filled[8][k+1] = 1;
        }
        // Empty
        for (int k = 0; k <9; k++) {
            for (int k2 = 1; k2 < 10; k2++) {
                if(filled[k][k2]==0) g.drawImage(ice, k2*32, k*32, this);
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

}
