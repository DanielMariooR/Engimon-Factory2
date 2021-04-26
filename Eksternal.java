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
        //file.concat(skillStr);
        file += skillStr;
        //file.concat(newline);
        file += newline;
        //file.concat(skill.getName());
        file += skill.getName();
        //file.concat(newline);
        file += newline;
        List<String> elemen = skill.getElem();
        for (String elmt : elemen) {
            if(elmt != null){
                //file.concat(elmt);
                file += elmt;
                //file.concat(spasi);
                file += spasi;
            }    
        }
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(skill.getBasePower()));
        file += String.valueOf(skill.getBasePower());
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(skill.getMasteryLevel()));
        file += String.valueOf(skill.getMasteryLevel());
        //file.concat(newline);
        file += newline;
        return file;
    }
    
    public static String addEngi(String file, Engimon engimon){
        String newline = "\n";
        String spasi = " ";
        String engimonStr = "ENGIMON";
        String pos = "POSITION";
        //file.concat(engimonStr);
        file += engimonStr;
        //file.concat(newline);
        file += newline;
        //file.concat(engimon.getName());
        file += engimon.getName();
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(engimon.getLevel()));
        file += String.valueOf(engimon.getLevel());
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(engimon.getExp()));
        file += String.valueOf(engimon.getExp());
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(engimon.getLives()));
        file += String.valueOf(engimon.getLives());
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(engimon.getTotExp()));
        file += String.valueOf(engimon.getTotExp());
        //file.concat(newline);
        file += newline;
        //file.concat(String.valueOf(engimon.getSpecies()));
        file += engimon.getSpecies();
        //file.concat(newline);
        file += newline;
        List<String> elemen = engimon.getElem();
        for (String elmt : elemen) {
            if(elmt != null){
                //file.concat(elmt);
                file += elmt;
                //file.concat(spasi);
                file += spasi;
            }
        }
        //file.concat(newline);
        file += newline;
        List<String> parentName = engimon.getParentName();
        for (String elmt : parentName) {
            if(elmt != null){
                //file.concat(elmt);
                file += elmt;
                //file.concat(spasi);
                file += spasi;
            }
        }
        //file.concat(newline);
        file += newline;
        List<String> parentSpecies = engimon.getParentSpecies();
        for (String elmt : parentSpecies) {
            if(elmt != null){
                //file.concat(elmt);
                file += elmt;
                //file.concat(spasi);
                file += spasi;
            }
        }
        //file.concat(newline);
        file += newline;
        List<Skill> skill = engimon.getSkills();
        for (Skill elmt : skill) {
            if(elmt != null){
                file = addSkill(file, elmt);
                //file.concat(spasi);
                //file += spasi;
            }
        }
        //file.concat(pos);
        file += pos;
        //file.concat(newline);
        file += newline;
        Point position = engimon.getPos();
        String posX = String.valueOf(position.getX());
        String posY = String.valueOf(position.getY());
        //file.concat(posX);
        file += posX;
        //file.concat(" ");
        file += spasi;
        //file.concat(posY);
        file += posY;
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
        //file.concat(playerStr);
        file += playerStr;
        //file.concat(newline);
        file += newline;
        //file.concat(engiActiveStr);
        file += engiActiveStr;
        //file.concat(newline);
        file += newline;
        Engimon active = player.getActive();
        if(active!=null){
            file = addEngi(file, active);
        }
        //file.concat(newline);
        file += newline;
        //file.concat(invenEngiStr);
        file += invenEngiStr;
        //file.concat(newline);
        file += newline;
        List<Engimon> engimon = player.getInventoryEngimons();
        for (Engimon elmt : engimon) {
            if(elmt != null){
                file = addEngi(file, elmt);
                //file.concat(newline);
                file += newline;
            }
            
        }
        //file.concat(invenItemStr);
        file += invenItemStr;
        //file.concat(newline);
        file += newline;
        List<Item> item = player.getInventoryItem() ;
        for (Item elmt : item) {
            if(elmt != null){
                Skill skill = elmt.getSkill();
                Integer jumlah = elmt.getJumlah();
                file = addSkill(file, skill);
                //file.concat(newline);
                //file += newline;
                //file.concat(jumlah.toString());
                file += jumlah.toString();
                //file.concat(newline);
                file += newline;
            }
            
        }
        //file.concat(pos);
        file += pos;
        //file.concat(newline);
        file += newline;
        Point position = player.getPos();
        String posX = String.valueOf(position.getX());
        String posY = String.valueOf(position.getY());
        //file.concat(posX);
        file += posX;
        //file.concat(" ");
        file += " ";
        //file.concat(posY);
        file += posY;
        return file;
    }

    public static String addMap(String file, Map map){
        String newline = "\n";
        String spasi = " "; 
        String endStr = "END";
        String wildEngiStr = "WILDENGIMON";
        String tiles = "TILES";
        //catat data player
        file = addPlayer(file, map.getPlayer());
        //catat wild Engimon
        file += newline;
        //file.concat(wildEngiStr);
        file += wildEngiStr;
        //file.concat(newline);
        file += newline;
        WildEngimon wildEngimonn = map.getWildEngimon();
        List<Engimon> wildEngimon = wildEngimonn.getEngimonList();
        for (Engimon elmt : wildEngimon) {
            if(elmt != null){
                file = addEngi(file, elmt);
                //file.concat(newline);
                file += newline;
            }
            
        }
        //catat tile atau mapnya
        //file.concat(tiles);
        file += tiles;
        //file.concat(newline);
        file += newline;
        char[][] tile = map.getTile();
        int row  = 20;
        int columns = 15;
        for(int i=0; i<row; i++){
            for(int j=0; j<columns; j++){
                String str = String.valueOf(tile[i][j]);
                //file.concat(str);
                file += str;
                //file.concat(spasi);
                file += spasi;
            }
            //file.concat(newline);
            file += newline;
        }
        //file.concat(endStr);
        file += endStr;
        return file;
    }

    public static Map Load(){
        Map map = new Map();
        String fileName = "File.txt";
        try {
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

            // Position
            newBrs = currBrs;
            String posisi = tempsArray[newBrs+1];
            String[] arrOfPos = posisi.split(" ", -2);
            int posX = Integer.valueOf(arrOfPos[0]);
            int posY = Integer.valueOf(arrOfPos[1]);
            Point position = new Point(posX,posY);

            // Construct Engimon Active
            Breeding.init();
            String dia = "";
            if(Elements.size()==1){
                dia = Breeding.dialogue.get(Elements.get(0));
            }
            else if(Elements.size()==2){
                dia = Breeding.dialogue.get(Elements.get(0)+Elements.get(1));
            }
            Engimon Active = new Engimon(name,dia,parentName,parentSpecies,skills,species,Elements,lives,level,exp,totalxp,position);
    
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
                // Position
                String posi = tempsArray[newBrs+1];
                String[] arrOfP = posi.split(" ", -2);
                int X = Integer.valueOf(arrOfP[0]);
                int Y = Integer.valueOf(arrOfP[1]);
                Point pos = new Point(X,Y);

                // Construct Engimon Active
                Breeding.init();
                if(Elements.size()==1){
                    dia = Breeding.dialogue.get(Elements.get(0));
                }
                else if(Elements.size()==2){
                    dia = Breeding.dialogue.get(Elements.get(0)+Elements.get(1));
                }
                Engimon inven = new Engimon(nama,dia,pName,pSpecies,skill,spec,El,live,lev,ex,totxp,pos);
                ownedEngimon.masuk(inven);

                currBrs=newBrs+2;
            }
            currBrs = currBrs+1;
            // Load Inventory Item
            Inventory<Item> skillItems = new Inventory<Item>();
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
        
                int jumlah = Integer.valueOf(tempsArray[currBrs+5]);
                Item newItem = new Item(nameskill,basePower,elements,masteryLevel);
                newItem.setJumlah(jumlah);
                skillItems.masuk(newItem);
                currBrs+=6;
            }
            newBrs = currBrs;
            // Load Point 
            // Point
            String pot = tempsArray[newBrs+1];
            String[] arrOfPo = pot.split(" ", -2);
            int iniX = Integer.valueOf(arrOfPo[0]);
            int iniY = Integer.valueOf(arrOfPo[1]);
            Point point = new Point(iniX,iniY);

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
                // Position
                String posi = tempsArray[newBrs+1];
                String[] arrP = posi.split(" ", -2);
                int XX = Integer.valueOf(arrP[0]);
                int YY = Integer.valueOf(arrP[1]);
                Point posit = new Point(XX,YY);

                // Construct WildEngimon
                Breeding.init();
                if(Elements.size()==1){
                    dia = Breeding.dialogue.get(Elements.get(0));
                }
                else if(Elements.size()==2){
                    dia = Breeding.dialogue.get(Elements.get(0)+Elements.get(1));
                }
                Engimon wld = new Engimon(nama,dia,pName,pSpecies,skill,spec,El,live,lev,ex,totxp,posit);
                wild.addWildEngimon(wld);
                currBrs = newBrs+2;
            }

            currBrs = currBrs+1;
            // LOAD TILES
            char[][] tiles = new char[20][15];
            while(!tempsArray[currBrs].equals("END")){
                for(int i=0; i<row; i++){
                    for(int j=0; j<columns; j++){
                        tiles[i][j] = tempsArray[currBrs].charAt(j*2);
                    }
                    currBrs+=1;
                }
            }

            // CONSTRUCT MAP
            map.setPlayer(player);
            map.setWild(wild);
            map.setTile(tiles);
            
        } catch (Exception e) {
            System.out.println(e); 
        }       
        return map;
    }

    public static String Save(Map map){
        String fileName = "File.txt";
        String file = "";
        //catat data dari map
        file = addMap(file, map);
        //file = "ini contoh";
        //tulis di file eksternal
        //teks lama akan ditimpa
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(file);
            fileWriter.close();
            String yrs="berhasil di save";
            return yrs;
        } catch (IOException e) {
            //System.out.println("Terjadi kesalahan karena: " + e.getMessage());
            String baru = "Terjadi kesalahan karena: ";
            return baru;
        }
    }


}