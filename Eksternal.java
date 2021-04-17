import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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
        file.concat(skill.getBasePower().toString());
        file.concat(newline);
        file.concat(skill.getMasteryLevel().toString());
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
        file.concat(engimon.getLevel().toString());
        file.concat(newline);
        file.concat(engimon.getExp().toString());
        file.concat(newline);
        file.concat(engimon.getLives().toString());
        file.concat(newline);
        file.concat(engimon.getTotExp().toString());
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
        file.concat(position.toString());
        return file;
    }

    public static String addPlayer(String file, Player player){
        String newline = "\n";
        String spasi = " ";
        String playerStr = "PLAYER";
        //catat data player
        file.concat(playerStr);
        file.concat(newline);
        Engimon active = player.getActive();
        if(active!=null){
            file = addEngi(file, active);
        }
        file.concat(newline);
        List<Engimon> engimon = player.getInventoryEngimons();
        for (Engimon elmt : engimon) {
            file = addEngi(file, elmt);
            file.concat(newline);
        }
        List<Item> item = player.getInventoryItem() ;
        for (Item elmt : item) {
            Skill skill = elmt.getSkill();
            Integer jumlah = elmt.getJumlah();
            file = addSkill(file, skill);
            file.concat(newline);
            file.concat(jumlah.toString());
            file.concat(newline);
        }
        Point position = player.getPos();
        file.concat(position.toString());
        return file;
    }

    public static String addMap(String file, Map map){
        String newline = "\n";
        String spasi = " ";
        String mapStr = "MAP"; 
        String endStr = "END";
        //catat data player
        file = addPlayer(file, map.getPlayer());
        //catat wild Engimon
        List<Engimon> wildEngimon = map.getWildEngimons();
        for (Engimon elmt : wildEngimon) {
            file = addEngi(file, elmt);
            file.concat(newline);
        }
        //catat tile atau mapnya
        file.concat(mapStr);
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

    // public static Map Load(){
    //     try {
    //         String fileName = "File.txt";
    //         Scanner myReader = new Scanner(fileName);
    //         Map map = new Map();
    //         while (!myReader.nextLine().equals("PLAYER")){
    //             String
    //         }
    //     } catch (IOException e) {
            
    //     }       
    // }

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
