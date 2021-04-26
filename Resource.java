import java.util.*;


import java.awt.Image;
import java.awt.Toolkit;

public class Resource {
    public HashMap<Character, Image> blocks;
    public HashMap<String, Image> engimonIcon;
    public HashMap<String,Image> skillIcon;

    public Resource(){
        blocks = new HashMap<>();
        engimonIcon = new HashMap<>();
        skillIcon = new HashMap<>();

        loadTileImage();
        loadEngimonImage();
        loadSkillImage();
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
        engimonIcon.put("GroundSquir", groundwaterEngimonSmall);
        engimonIcon.put("GroundSquirBig", groundwaterEngimonBig);
        engimonIcon.put("DinginSquir", watericeEngimonSmall);
        engimonIcon.put("DinginSquirBig", watericeEngimonBig);  
    }
    public void loadSkillImage(){
        Image fireblast1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s21.png");
        Image fireblast2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s22.png");
        Image fireblast3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s23.png");
        skillIcon.put("fireblast1",fireblast1);
        skillIcon.put("fireblast2",fireblast2);
        skillIcon.put("fireblast3",fireblast3);
        Image waterbullet1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s14_1.png");
        Image waterbullet2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s14_2.png");
        Image waterbullet3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s14_3.png");
        skillIcon.put("waterbullet1",waterbullet1);
        skillIcon.put("waterbullet2",waterbullet2);
        skillIcon.put("waterbullet3",waterbullet3);
        Image kvolt1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s81.png");
        Image kvolt2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s82.png");
        Image kvolt3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s83.png");
        skillIcon.put("100kvolt1",kvolt1);
        skillIcon.put("100kvolt2",kvolt2);
        skillIcon.put("100kvolt3",kvolt3);
        Image earthquake1= Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s31.png");
        Image earthquake2= Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s32.png");
        Image earthquake3= Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s33.png");
        skillIcon.put("earthquake1",earthquake1);
        skillIcon.put("earthquake2",earthquake2);
        skillIcon.put("earthquake3",earthquake3);
        Image bitterfrost1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s41.png");
        Image bitterfrost2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s42.png");
        Image bitterfrost3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s43.png");
        skillIcon.put("bitterfrost1",bitterfrost1);
        skillIcon.put("bitterfrost2",bitterfrost2);
        skillIcon.put("bitterfrost3",bitterfrost3);
        Image thunderblaze1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s71.png");
        Image thunderblaze2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s71.png");
        Image thunderblaze3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s71.png");
        skillIcon.put("thunderblaze1",thunderblaze1);
        skillIcon.put("thunderblaze2",thunderblaze2);
        skillIcon.put("thunderblaze3",thunderblaze3);
        skillIcon.put("fiery100kvolt1",thunderblaze1);
        skillIcon.put("fiery100kvolt2",thunderblaze2);
        skillIcon.put("fiery100kvolt3",thunderblaze3);
        Image tsunami1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s15_1.png");
        Image tsunami2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s15_2.png");
        Image tsunami3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s15_3.png");
        skillIcon.put("tsunami1",tsunami1);
        skillIcon.put("tsunami2",tsunami2);
        skillIcon.put("tsunami3",tsunami3);
        Image colddestruction1 =Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s91.png");
        Image colddestruction2 =Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s92.png");
        Image colddestruction3 =Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s93.png");
        skillIcon.put("colddestruction1",colddestruction1);
        skillIcon.put("colddestruction2",colddestruction2);
        skillIcon.put("colddestruction3",colddestruction3);
        Image fireball1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s1_1.png");
        Image fireball2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s1_2.png");
        Image fireball3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s1_3.png");
        skillIcon.put("fireball1",fireball1);
        skillIcon.put("fireball2",fireball2);
        skillIcon.put("fireball3",fireball3);
        Image groundpound1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s11_1.png");
        Image groundpound2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s11_2.png");
        Image groundpound3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s11_3.png");
        skillIcon.put("groundpound1",groundpound1);
        skillIcon.put("groundpound2",groundpound2);
        skillIcon.put("groundpound3",groundpound3);
        Image sandstorm1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s12_1.png");
        Image sandstorm2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s12_2.png");
        Image sandstorm3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s12_3.png");
        skillIcon.put("sandstorm1",sandstorm1);
        skillIcon.put("sandstorm2",sandstorm2);
        skillIcon.put("sandstorm3",sandstorm3);
        Image thunderbolt1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s16_1.png");
        Image thunderbolt2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s16_2.png");
        Image thunderbolt3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s16_3.png");
        skillIcon.put("thunderbolt1",thunderbolt1);
        skillIcon.put("thunderbolt2",thunderbolt2);
        skillIcon.put("thunderbolt3",thunderbolt3);
        Image waterattack1 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s51.png");
        Image waterattack2 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s52.png");
        Image waterattack3 = Toolkit.getDefaultToolkit().getImage("resource/tiles/skill/s53.png");
        skillIcon.put("waterattack1",waterattack1);
        skillIcon.put("waterattack2",waterattack2);
        skillIcon.put("waterattack3",waterattack3);
        
    
    
    
    }


}
