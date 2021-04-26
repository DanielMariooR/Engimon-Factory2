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
import java.awt.Rectangle;
import javax.swing.JOptionPane;


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
    private Image EngimonElectric;
    private Image EngimonFire;
    private Image EngimonWater;
    private Image EngimonIce;
    private Image EngimonGround;
    private Image EngimonFireElectric;
    private Image EngimonWaterIce;
    private Image EngimonWaterGround;

    private Image mountain;
    // private Inventory<Item> player.skillItems;
    // private Inventory<Engimon> engimons;
    private Image engimon;
    private Timer timer;
    private Player player;
    public Engimon[][] slotEngi;
    public Item[] slotSkill;
    public int[][] filled;
    private Rectangle selectedCell = null;

    public InvenPanel(Player P){
        EngimonElectric = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonElectricSmall.png");
        EngimonFire = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireSmall.png");
        EngimonWater = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterSmall.png");
        EngimonIce = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonIceSmall.png");
        EngimonGround = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/engimonGroundSmall.png");
        EngimonFireElectric = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireElectricSmall.png");
        EngimonWaterIce = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterIceSmall.png");
        EngimonWaterGround = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterGroundSmall.png");
        ice = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/ice.png");
        engimon = Toolkit.getDefaultToolkit().getImage("resource/tiles/pokemon.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/mountain.png");
        fire = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/fire.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/waterelement.png");
        electric = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/electric.png");
        ground = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/ground.png");
        icy = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/icy.png");
        felec = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/felec.png");
        gwat = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/gwat.png");
        icewat = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/icewat.png");
        skillinven = Toolkit.getDefaultToolkit().getImage("resource/tiles/element/skillinven.png");
        slotEngi = new Engimon[9][10];
        slotSkill = new Item[9];
        filled = new int[9][10];

        player = P;
        timer = new Timer(10, new TimerListener());
        timer.start();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int w = getWidth();
                int h = getHeight();
                selectedCell = null;
                for (int col = 0; col < 9 && selectedCell == null; col++) {
                    for (int row = 0; row < 10; row++) {
                        int x = (w / 9) * col;
                        int y = (h / 10) * row;
                        Rectangle cell = new Rectangle(x, y, w / 9, h / 10);
                        if (cell.contains(e.getPoint())) {
                            System.out.println(filled[row][col]);
                            System.out.println(slotEngi[row][col]);
                            System.out.println(row);
                            System.out.println(col);
                            if(filled[row][col]!=0 && row != 8) JOptionPane.showMessageDialog(null, slotEngi[row][col]);
                            else if (filled[row][col]!=0 && row == 8) JOptionPane.showMessageDialog(null, slotSkill[col]);
                            selectedCell = cell;
                            repaint();
                            break;
                        }
                    }
                }
            }
        });
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        player.sortEngimon();
        player.sortSkill();
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
        for (int k = 0; k <9; k++) {
            for (int k2 = 0; k2 < 10; k2++) {
                filled[k][k2] = 0;
            }
        }
        // Engimon
        for (index =  0; index < player.ownedEngimon.getInv().size(); index++) {
            if(player.ownedEngimon.getInv().get(index).getElem().size() == 1){
                if(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Fire"){g.drawImage(EngimonFire, fi*32, 0*32, this);filled[0][fi] = 1;slotEngi[0][fi] = player.ownedEngimon.getInv().get(index); fi++;}
                else if(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Water") {g.drawImage(EngimonWater, wi*32, 1*32, this);filled[1][wi] = 1;slotEngi[1][wi] = player.ownedEngimon.getInv().get(index);wi++;}
                else if(player.ownedEngimon.getInv().get(index).getElem().get(0).equals("Electric")){g.drawImage(EngimonElectric, ei*32, 2*32, this);filled[2][ei] = 1;slotEngi[2][ei] = player.ownedEngimon.getInv().get(index);ei++;}
                else if(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Ground"){g.drawImage(EngimonGround, gi*32, 3*32, this);filled[3][gi] = 1;slotEngi[3][gi] = player.ownedEngimon.getInv().get(index);gi++;}
                else if(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Ice"){g.drawImage(EngimonIce, ii*32, 4*32, this);filled[4][ii] = 1;slotEngi[4][ii] = player.ownedEngimon.getInv().get(index);ii++;}
            }
            else if(player.ownedEngimon.getInv().get(index).getElem().size() == 2){
                if((player.ownedEngimon.getInv().get(index).getElem().get(0) == "Fire" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Electric")||(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Electric" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Fire")){g.drawImage(EngimonFireElectric, fei*32, 5*32, this);filled[5][fei] = 1;slotEngi[5][fei] = player.ownedEngimon.getInv().get(index);fei++;}
                else if((player.ownedEngimon.getInv().get(index).getElem().get(0) == "Water" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Ground")||(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Ground" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Water")){g.drawImage(EngimonWaterGround, gwi*32, 6*32, this);filled[6][gwi] = 1;slotEngi[6][gwi] = player.ownedEngimon.getInv().get(index);gwi++;}
                else if((player.ownedEngimon.getInv().get(index).getElem().get(0) == "Water" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Ice")||(player.ownedEngimon.getInv().get(index).getElem().get(0) == "Ice" && player.ownedEngimon.getInv().get(index).getElem().get(1) == "Water")){g.drawImage(EngimonWaterIce, wii*32, 7*32, this);filled[7][wii] = 1;slotEngi[7][wii] = player.ownedEngimon.getInv().get(index);wii++;}
            }
        }
        // Skill
        for (int k = 0; k < player.skillItems.getInv().size(); k++) {
            g.drawImage(engimon, (k+1)*32, 8*32, this);
            slotSkill[k+1] = player.skillItems.getInv().get(k);
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
