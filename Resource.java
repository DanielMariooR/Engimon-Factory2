import java.util.*;

import jdk.tools.jlink.builder.ImageBuilder;

import java.awt.Image;
import java.awt.Toolkit;

public class Resource {
    public HashMap<Character, Image> blocks;
    public HashMap<String, Image> engimonIcon;

    public Resource(){
        blocks = new HashMap<>();
        engimonIcon = new HashMap<>();
    }

    public loadTileImage(){
        Image grass = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/grass.png");
        Image water = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/water.png");
        Image mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/mountain.png");
        Image tundra = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/ice.png");

        blocks.put('-', grass);
        blocks.put('o', water);
        blocks.put('^', mountain);
        blocks.put('#', tundra);
    }

    public loadEngimonImage(){
        Image waterEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image waterEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image fireEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image fireEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image groundEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image groundEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image iceEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image iceEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image elecEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image elecEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image watericeEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image watericeEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image groundwaterEngimonBig = Toolkit.getDefaultToolkit().getImage(url);
        Image groundwaterEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image fireelecEngimonSmall = Toolkit.getDefaultToolkit().getImage(url);
        Image fireelecEngimonBig = Toolkit.getDefaultToolkit().getImage(url);

        
        
    }


}
