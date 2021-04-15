import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.event.keyEvent;



public class GameCanvas extends JPanel{
    private Image grass;
    private Image water;
    private Image mountain;
    private Image tundra;
    private Image character;
    private Map objects;

    public GameCanvas(Map m){
        grass = Toolkit.getDefaultToolkit().getImage("resource/tiles/grass.png");
        water = Toolkit.getDefaultToolkit().getImage("resource/tiles/water.png");
        mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/mountain.png");
        tundra = Toolkit.getDefaultToolkit().getImage("resource/tiles/ice.png");
        character = Toolkit.getDefaultToolkit().getImage("resource/tiles/char.png");
        this.objects = m;
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
                    g.drawImage(grass, i*32, j*32, this);
                } else if(objects.tile[i][j] == 'o'){
                    g.drawImage(water, i*32, j*32, this);
                } else if(objects.tile[i][j] == '^'){
                    g.drawImage(mountain, i*32, j*32, this);
                } else {
                    g.drawImage(tundra, i*32, j*32, this);
                }
                j++;
            }
            i++;
            j = 0;
        }
    }

    public static void main(String[] args) {
        Map m = new Map("map.txt");
        Frame frame = new Frame();
        frame.setSize(640,640);
        frame.add(new GameCanvas(m));
        frame.setVisible(true);
    }
}
