import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.FileWriter;
import java.io.IOException;

public class Eksternal {

    public static String addSkill(String file, Skill skill){
        String newline = "\n";
        String spasi = " ";
        String skillStr = "SKILL";
        file.concat(skillStr);
        file.concat(newline);
        file.concat(skill.getName());
        file.concat(newline);
        List<String> elemen = skill.getElem();
        for (String elmt : elemen) {
            file.concat(elmt);
            file.concat(spasi);
        }
        file.concat(newline);
        file.concat(String.valueOf(skill.getBasePower()));
        file.concat(newline);
        file.concat(String.valueOf(skill.getMasteryLevel()));
        file.concat(newline);
        return file;
    }
    
    public static String addEngi(String file, Engimon engimon){
        String newline = "\n";
        String spasi = " ";
        String engimonStr = "ENGIMON";
        file.concat(engimonStr);
        file.concat(newline);
        file.concat(engimon.getName());
        file.concat(newline);
        file.concat(String.valueOf(engimon.getLevel()));
        file.concat(newline);
        file.concat(String.valueOf(engimon.getExp()));
        file.concat(newline);
        file.concat(String.valueOf(engimon.getLives()));
        file.concat(newline);
        file.concat(String.valueOf(engimon.getTotExp()));
        file.concat(newline);
        file.concat(engimon.getSpecies());
        List<String> elemen = engimon.getElem();
        for (String elmt : elemen) {
            file.concat(elmt);
            file.concat(spasi);
        }
        file.concat(newline);
        List<String> parentName = engimon.getParentName();
        for (String elmt : parentName) {
            file.concat(elmt);
            file.concat(spasi);
        }
        file.concat(newline);
        List<String> parentSpecies = engimon.getParentSpecies();
        for (String elmt : parentSpecies) {
            file.concat(elmt);
            file.concat(spasi);
        }
        file.concat(newline);
        List<Skill> skill = engimon.getSkills();
        for (Skill elmt : skill) {
            file = addSkill(file, elmt);
            file.concat(newline);
        }
        Point position = engimon.getPos();
        String posX = String.valueOf(position.getX());
        String posY = String.valueOf(position.getY());
        file.concat(posX);
        file.concat(" ");
        file.concat(posY);
        return file;
    }

    public static String addPlayer(String file, Player player){
        String newline = "\n";
        //String spasi = " ";
        String playerStr = "PLAYER";
        String engiActiveStr = "ENGIMON ACTIVE";
        String invenEngiStr = "INVENTORY ENGIMON";
        String invenItemStr = "INVENTORY ITEM";
        String pos = "POSITION";
        //catat data player
        file.concat(playerStr);
        file.concat(newline);
        file.concat(engiActiveStr);
        file.concat(newline);
        Engimon active = player.getActive();
        if(active!=null){
            file = addEngi(file, active);
        }
        file.concat(newline);
        file.concat(invenEngiStr);
        file.concat(newline);
        List<Engimon> engimon = player.getInventoryEngimons();
        for (Engimon elmt : engimon) {
            file = addEngi(file, elmt);
            file.concat(newline);
        }
        file.concat(invenItemStr);
        file.concat(newline);
        List<Item> item = player.getInventoryItem() ;
        for (Item elmt : item) {
            Skill skill = elmt.getSkill();
            Integer jumlah = elmt.getJumlah();
            file = addSkill(file, skill);
            file.concat(newline);
            file.concat(jumlah.toString());
            file.concat(newline);
        }
        file.concat(pos);
        file.concat(newline);
        Point position = player.getPos();
        String posX = String.valueOf(position.getX());
        String posY = String.valueOf(position.getY());
        file.concat(posX);
        file.concat(" ");
        file.concat(posY);
        return file;
    }

    public static String addMap(String file, Map map){
        String newline = "\n";
        String spasi = " "; 
        String endStr = "END";
        String wildEngiStr = "WILDENGIMON";
        String tiles = "TILES";
        //catat data player
        file.concat(wildEngiStr);
        file.concat(newline);
        file = addPlayer(file, map.getPlayer());
        //catat wild Engimon
        WildEngimon wildEngimonn = map.getWildEngimon();
        List<Engimon> wildEngimon = wildEngimonn.getEngimonList();
        for (Engimon elmt : wildEngimon) {
            file = addEngi(file, elmt);
            file.concat(newline);
        }
        //catat tile atau mapnya
        file.concat(tiles);
        file.concat(newline);
        char[][] tile = map.getTile();
        int row  = 20;
        int columns = 15;
        for(int i=0; i<row; i++){
            for(int j=0; j<columns; j++){
                String str = String.valueOf(tile[i][j]);
                file.concat(str);
                file.concat(spasi);
            }
            file.concat(newline);
        }
        file.concat(endStr);
        return file;
    }

    public static Map Load(){
        Map map = new Map();
        try {
            String fileName = "File.txt";
            Scanner myReader = new Scanner(new File(fileName));
            String curr = "";
            int currBrs = 0;
            int newBrs = 0;
            int row  = 20;
            int columns = 15;
            List<String> temps = new ArrayList<String>();
    
            // Load file menjadi sebuah array of string
            while (myReader.hasNext()){
                curr = myReader.nextLine();
                temps.add(curr);
            }
            myReader.close();
            String[] tempsArray = temps.toArray(new String[0]);

            // LOAD MAP

            // LOAD PLAYER

            // LOAD ENGIMON ACTIVE
            String name = tempsArray[3];
            int level = Integer.valueOf(tempsArray[4]);
            int exp = Integer.valueOf(tempsArray[5]);;
            int lives = Integer.valueOf(tempsArray[6]);;
            int totalxp = Integer.valueOf(tempsArray[7]);;
            String species = tempsArray[8];
            ArrayList<String>  Elements = new ArrayList<String>();
            String el = tempsArray[9];
            String[] arrOfEl = el.split(" ", -2);
            for (String a : arrOfEl){
                Elements.add(a);
            }
            ArrayList<String> parentName = new ArrayList<String>();
            String PN = tempsArray[10];
            String[] arrOfPN = PN.split(" ", -2);
            for (String a : arrOfPN){
                parentName.add(a);
            }
            ArrayList<String> parentSpecies = new ArrayList<String>();
            String PS = tempsArray[11];
            String[] arrOfPS = PS.split(" ", -2);
            for (String a : arrOfPS){
                parentSpecies.add(a);
            }
            ArrayList<Skill> skills = new ArrayList<Skill>();
            currBrs = 12;
            while(!tempsArray[currBrs].equals("POSITION")){
                String nameskill = tempsArray[currBrs+1];
                ArrayList<String> elements = new ArrayList<String>();
                String element = tempsArray[currBrs+2];
                String[] arrOfele = element.split(" ", -2);
                for (String a : arrOfele){
                    elements.add(a);
                }
                int basePower = Integer.valueOf(tempsArray[currBrs+3]);
                int masteryLevel = Integer.valueOf(tempsArray[currBrs+4]);
                Skill lisSkill = new Skill(nameskill,elements,basePower,masteryLevel);
                skills.add(lisSkill);
                currBrs+=5;
            }

            newBrs = currBrs;
            Point position = new Point();
            //Position newBrs+2;

            // Construct Engimon Active
            Engimon Active = new Engimon(name,parentName,parentSpecies,skills,species,Elements,lives,level,exp,totalxp,position);
    
            currBrs = newBrs+3;
            // Load Inventory Engimon
            Inventory<Engimon> ownedEngimon = new Inventory<Engimon>();
            while(!tempsArray[currBrs].equals("INVENTORY ITEM")){
                String nama = tempsArray[currBrs+1];
                int lev = Integer.valueOf(tempsArray[currBrs+2]);
                int ex = Integer.valueOf(tempsArray[currBrs+3]);;
                int live = Integer.valueOf(tempsArray[currBrs+4]);;
                int totxp = Integer.valueOf(tempsArray[currBrs+5]);;
                String spec = tempsArray[currBrs+6];
                ArrayList<String>  El = new ArrayList<String>();
                String elem = tempsArray[currBrs+7];
                String[] arrOfElem = elem.split(" ", -2);
                for (String a : arrOfElem){
                    El.add(a);
                }
                ArrayList<String> pName = new ArrayList<String>();
                String PName = tempsArray[currBrs+8];
                String[] arrOfPName = PName.split(" ", -2);
                for (String a : arrOfPName){
                    pName.add(a);
                }
                ArrayList<String> pSpecies = new ArrayList<String>();
                String PSpec = tempsArray[currBrs+9];
                String[] arrOfPSpec = PSpec.split(" ", -2);
                for (String a : arrOfPSpec){
                    pSpecies.add(a);
                }
                ArrayList<Skill> skill = new ArrayList<Skill>();
                currBrs = currBrs+10;
                while(!tempsArray[currBrs].equals("POSITION")){
                    String nameskill = tempsArray[currBrs+1];
                    ArrayList<String> elements = new ArrayList<String>();
                    String element = tempsArray[currBrs+2];
                    String[] arrOfele = element.split(" ", -2);
                    for (String a : arrOfele){
                        elements.add(a);
                    }
                    int basePower = Integer.valueOf(tempsArray[currBrs+3]);
                    int masteryLevel = Integer.valueOf(tempsArray[currBrs+4]);
                    Skill lisSkill = new Skill(nameskill,elements,basePower,masteryLevel);
                    skills.add(lisSkill);
                    currBrs+=5;
                }

                newBrs = currBrs;
                Point pos = new Point();
                //Position newBrs+2;

                // Construct Engimon Active
                Engimon inven = new Engimon(nama,pName,pSpecies,skill,spec,El,live,lev,ex,totxp,pos);
                ownedEngimon.masuk(inven);
            }
            currBrs = newBrs+3;
            // Load Inventory Item
            Inventory<Item> skillItems = new Inventory<Item>();
            while(!tempsArray[currBrs].equals("POINT")){
                String nameskill = tempsArray[currBrs+1];
                ArrayList<String> elements = new ArrayList<String>();
                String element = tempsArray[currBrs+2];
                String[] arrOfele = element.split(" ", -2);
                for (String a : arrOfele){
                    elements.add(a);
                }
                int basePower = Integer.valueOf(tempsArray[currBrs+3]);
                int masteryLevel = Integer.valueOf(tempsArray[currBrs+4]);
        
                int jumlah = Integer.valueOf(tempsArray[currBrs+5]);
                Item newItem = new Item(nameskill,basePower,elements,masteryLevel);
                newItem.setJumlah(jumlah);
                skillItems.masuk(newItem);
                currBrs+=6;
            }
            newBrs = currBrs;
            // Load Point 
            // newBrs + 2
            Point point = new Point();

            // Construct Player
            Player player = new Player(Active,ownedEngimon,skillItems,point);

            currBrs = newBrs+3;
            // LOAD WILDENGIMON
            WildEngimon wild = new WildEngimon();
            while(!tempsArray[currBrs].equals("TILES")){
                String nama = tempsArray[currBrs+1];
                int lev = Integer.valueOf(tempsArray[currBrs+2]);
                int ex = Integer.valueOf(tempsArray[currBrs+3]);;
                int live = Integer.valueOf(tempsArray[currBrs+4]);;
                int totxp = Integer.valueOf(tempsArray[currBrs+5]);;
                String spec = tempsArray[currBrs+6];
                ArrayList<String>  El = new ArrayList<String>();
                String elem = tempsArray[currBrs+7];
                String[] arrOfElem = elem.split(" ", -2);
                for (String a : arrOfElem){
                    El.add(a);
                }
                ArrayList<String> pName = new ArrayList<String>();
                String PName = tempsArray[currBrs+8];
                String[] arrOfPName = PName.split(" ", -2);
                for (String a : arrOfPName){
                    pName.add(a);
                }
                ArrayList<String> pSpecies = new ArrayList<String>();
                String PSpec = tempsArray[currBrs+9];
                String[] arrOfPSpec = PSpec.split(" ", -2);
                for (String a : arrOfPSpec){
                    pSpecies.add(a);
                }
                ArrayList<Skill> skill = new ArrayList<Skill>();
                currBrs = currBrs+10;
                while(!tempsArray[currBrs].equals("POSITION")){
                    String nameskill = tempsArray[currBrs+1];
                    ArrayList<String> elements = new ArrayList<String>();
                    String element = tempsArray[currBrs+2];
                    String[] arrOfele = element.split(" ", -2);
                    for (String a : arrOfele){
                        elements.add(a);
                    }
                    int basePower = Integer.valueOf(tempsArray[currBrs+3]);
                    int masteryLevel = Integer.valueOf(tempsArray[currBrs+4]);
                    Skill lisSkill = new Skill(nameskill,elements,basePower,masteryLevel);
                    skills.add(lisSkill);
                    currBrs+=5;
                }

                newBrs = currBrs;
                Point pos = new Point();
                //Position newBrs+2;

                // Construct WildEngimon
                Engimon wld = new Engimon(nama,pName,pSpecies,skill,spec,El,live,lev,ex,totxp,pos);
                wild.addWildEngimon(wld);
            }

            currBrs = newBrs+4;
            // LOAD TILES
            char[][] tiles = new char[20][15];
            while(!tempsArray[currBrs].equals("END")){
                for(int i=0; i<row; i++){
                    for(int j=0; j<columns; j++){
                        tiles[i][j] = tempsArray[currBrs].charAt(j);
                    }
                }
            }

            // CONSTRUCT MAP
            map.setPlayer(player);
            map.setWild(wild);
            map.setTile(tiles);
            
        } catch (Exception e) {
            System.out.println("File Not found error!"); 
        }       
        return map;
    }

    public static void Save(Map map){
        String fileName = "File.txt";
        String file = "";
        //catat data dari map
        file = addMap(file, map);
        //tulis di file eksternal
        //teks lama akan ditimpa
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(file);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
    }


}