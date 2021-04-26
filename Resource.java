import java.util.*;


import java.awt.Image;
import java.awt.Toolkit;

public class Resource {
    public HashMap<Character, Image> blocks;
    public HashMap<String, Image> engimonIcon;

    public Resource(){
        blocks = new HashMap<>();
        engimonIcon = new HashMap<>();

        loadTileImage();
        loadEngimonImage();
    }

    public void loadTileImage(){
        Image grass = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/grass.png");
        Image water = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/water.png");
        Image mountain = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/mountain.png");
        Image tundra = Toolkit.getDefaultToolkit().getImage("resource/tiles/tile/ice.png");

        blocks.put('-', grass);
        blocks.put('o', water);
        blocks.put('^', mountain);
        blocks.put('#', tundra);
    }

    public void loadEngimonImage(){
        Image waterEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterSmall.png");
        Image waterEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterBig.png");
        Image fireEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireBig.png");
        Image fireEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireSmall.png");
        Image groundEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/engimonGroundBig.png");
        Image groundEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/engimonGroundSmall.png");
        Image iceEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonIceBig.png");
        Image iceEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonIceSmall.png");
        Image elecEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonElectricBig.png");
        Image elecEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonElectricSmall.png");
        Image watericeEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterIceBig.png");
        Image watericeEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterIceSmall.png");
        Image groundwaterEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterGroundBig.png");
        Image groundwaterEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonWaterGroundSmall.png");
        Image fireelecEngimonSmall = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireElectricSmall.png");
        Image fireelecEngimonBig = Toolkit.getDefaultToolkit().getImage("resource/tiles/Engimon/EngimonFireElectricBig.png");

        engimonIcon.put("SquirmonBig", waterEngimonBig);
        engimonIcon.put("Squirmon", waterEngimonSmall);
        engimonIcon.put("Charmander", fireEngimonSmall);
        engimonIcon.put("CharmanderBig", fireEngimonBig);
        engimonIcon.put("Groundomon", groundEngimonSmall);
        engimonIcon.put("GroundomonBig", groundEngimonBig);
        engimonIcon.put("Dinginmon", iceEngimonSmall);
        engimonIcon.put("DinginmonBig", iceEngimonBig);
        engimonIcon.put("Pikamon", elecEngimonSmall);
        engimonIcon.put("PikamonBig", elecEngimonBig);
        engimonIcon.put("CharmanPikamon", fireelecEngimonSmall);
        engimonIcon.put("CharmanPikamonBig", fireelecEngimonBig);
        engimonIcon.put("PikaChamander", fireEngimonSmall);
        engimonIcon.put("PikaCharmanderBig", fireelecEngimonBig);
        engimonIcon.put("GroundSquir", groundEngimonSmall);
        engimonIcon.put("GroundSquirBig", groundEngimonBig);
        engimonIcon.put("DinginSquir", watericeEngimonSmall);
        engimonIcon.put("DinginSquirBig", waterEngimonBig);  
    }


}
