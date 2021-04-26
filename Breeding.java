import java.util.*;
import java.lang.Exception;

//TODO : Skill Unik

public class Breeding{

    public static Hashtable<String,String> dialogue = new Hashtable<String,String>(); 
    public static String[] dial = {"Let's burn everything on our path!","Let's fight strong engimons with my water power!","Pika Pika","SMASH!!!!!","Lets froze together","Being called the Operator of Overloading, I shalt overload anything!","My Fire will Electro-Cute our enemies","Let's freeze the enemy!","Let's freeze the enemy!","Water and Earth means life!","Water and Earth means life!"};


    public static Engimon Breed(Engimon A, Engimon B,String childName) throws IllegalStateException{
        if(A.getLevel() < 4 || B.getLevel() < 4) throw new IllegalStateException(new StringBuilder("Level parents harus lebih besar dari 3").toString()); // Throw Exception if either parent lv < 4
        // get child attributes
        init();
        ArrayList<String> childElSpec = setChildElSpec(A,B);
        ArrayList<String> childEl = new ArrayList<String>();
        for (int i = 1; i < childElSpec.size(); i++)
        {
            childEl.add(childElSpec.get(i));
        }
        String childSpec = childElSpec.get(0);
    
        ArrayList<Skill> childSkills = setChildSkills(A,B,childEl);
    
        //Subtract parents lv
        int lvlA = A.getLevel();
        int lvlB = B.getLevel();
        A.setLevel(lvlA - 3);
        B.setLevel(lvlB- 3);
        
        ArrayList<String> PName = new ArrayList<String>();
        ArrayList<String> PSpecies = new ArrayList<String>();
        PName.add(A.getName());
        PName.add(B.getName());
        PSpecies.add(A.getSpesies());
        PSpecies.add(B.getSpesies());
        Point P = new Point(0,0);
        String dia = "";
        if(childEl.size()==1){
            dia = dialogue.get(childEl.get(0));
        }
        else if(childEl.size()==2){
            dia = dialogue.get(childEl.get(0)+childEl.get(1));
        }
        return new Engimon(childName,dia,PName,PSpecies,childSkills,childSpec,childEl,3,1,0,0,P); 
        // childName, PName, PSpecies, childSkills ,childSpec, childEl, lives, level, xp , cumm xp , location
    }
    // Set Child Skills - Skill Unik spesies anak blm di handle ; Bypass constraint atribut anak blm di handle
    // Priority : 1. Higher Mastery Level 2. A Skill 3. Lowest index
    public static ArrayList<Skill> setChildSkills(Engimon A, Engimon B, ArrayList<String> El ){
        ArrayList<Skill> aSkills = A.getSkills();
        ArrayList<Skill> bSkills = B.getSkills();
        ArrayList<Skill> mergedSkills = concatSkill(aSkills,bSkills);
        ArrayList<Skill> childSkills = new ArrayList<Skill>();
        for (int i = 0; i < mergedSkills.size(); i++)
        {
            if(childSkills.size() < 4){
                // Bypass constraint atribut anak blm di handle - skrg handled
            if(searchInVec(childSkills,mergedSkills.get(i)) == -1){
                int idxA = searchInVec(aSkills,mergedSkills.get(i));
                int idxB = searchInVec(bSkills,mergedSkills.get(i));
                if(idxA != -1 && idxB != -1){
                    if(aSkills.get(idxA).getMasteryLevel() == bSkills.get(idxB).getMasteryLevel()){
                        if(aSkills.get(idxA).getMasteryLevel() == 3) mergedSkills.get(i).setMastery(aSkills.get(idxA).getMasteryLevel());
                        else mergedSkills.get(i).setMastery(aSkills.get(idxA).getMasteryLevel() + 1);
                    }
                    else if(aSkills.get(idxA).getMasteryLevel() > bSkills.get(idxB).getMasteryLevel()){
                        mergedSkills.get(i).setMastery(aSkills.get(idxA).getMasteryLevel());
                    }
                    else mergedSkills.get(i).setMastery(bSkills.get(idxB).getMasteryLevel());
                    childSkills.add(mergedSkills.get(i));
                }
                else childSkills.add(mergedSkills.get(i));
                }
            }
    
        }
        compUnique(El, childSkills);
    
        return childSkills;
    }
    public static ArrayList<String> setChildElSpec(Engimon A, Engimon B){
        ArrayList<String> elSpec = new ArrayList<String>();
        if(A.getElem().size() == 2 || B.getElem().size()==2) System.out.println("Elemen salah satu / kedua parent lebih dari 1. Akan diambil elemen pertama masing-masing parent");
        if(A.getElem().get(0) == B.getElem().get(0)){  // Same elements
            elSpec.add(A.getSpesies()); // Aturan : ambil species parent A
            elSpec.add(A.getElem().get(0));
            }
        else{ // Diff elements
            if(strongerEl(A.getElem().get(0),B.getElem().get(0)) == 1){ // ambil elemen dan species A
                elSpec.add(A.getSpesies());
                elSpec.add(A.getElem().get(0));
                 
            }
            else if(strongerEl(A.getElem().get(0),B.getElem().get(0)) == -1){ // ambil elemen dan species B
                elSpec.add(B.getSpesies()); 
                elSpec.add(B.getElem().get(0));
                    
            }
            else{ // Kasus Elemen Advantage Sama
                // String aSpecies = A.getSpesies();
                // aSpecies = aSpecies.substring(0,aSpecies.length()-3);
                // String species = aSpecies + B.getSpesies(); 
                // elSpec.add(species);
                String spes = "";
                if(A.getElem().get(0) == "Fire" && B.getElem().get(0) == "Electric") spes = "CharmanPikamon";
                else if( A.getElem().get(0) == "Electric" && B.getElem().get(0) == "Fire") spes ="PikaCharmanmon";
                else if((A.getElem().get(0) == "Water" && B.getElem().get(0) == "Ground") || A.getElem().get(0) == "Ground" && B.getElem().get(0) == "Water") spes ="GroundSquir";
                else if((A.getElem().get(0) == "Water" && B.getElem().get(0) == "Ice") || A.getElem().get(0) == "Ice" && B.getElem().get(0) == "Water") spes ="DinginSquir";
                elSpec.add(spes);
                elSpec.add(A.getElem().get(0));
                elSpec.add(B.getElem().get(0));
            }
        }
        return elSpec;
    }
    public static int strongerEl(String a,String b){
        if(a=="Fire"){
            if(b=="Water") return -1;
            else if(b=="Electric") return 0;
            else if(b=="Ground") return -1;
            else if(b=="Ice") return 1;
        }
        else if(a=="Water"){
            if(b=="Fire") return 1;
            else if(b=="Electric") return -1;
            else if(b=="Ground") return 0;
            else if(b=="Ice") return 0;
        }
        else if(a=="Electric"){
            if(b=="Water") return 1;
            else if(b=="Fire") return 0;
            else if(b=="Ground") return -1;
            else if(b=="Ice") return 1;
        }
        else if(a=="Ground"){
            if(b=="Water") return 0;
            else if(b=="Electric") return 1;
            else if(b=="Fire") return 1;
            else if(b=="Ice") return -1;
        }
        else if(a=="Ice"){
            if(b=="Water") return 0;
            else if(b=="Electric") return -1;
            else if(b=="Ground") return 1;
            else if(b=="Fire") return -1;
        }
    
        return 0;
    }
    public static ArrayList<Skill> concatSkill(ArrayList<Skill> Askill, ArrayList<Skill> Bskill){
        ArrayList<Skill> ret = new ArrayList<Skill>();
        ArrayList<Skill> As = new ArrayList<Skill>(Askill);
        ArrayList<Skill> Bs = new ArrayList<Skill>(Bskill);
        int ai = 0;
        int bi = 0;
        As.sort((Skill s1, Skill s2)->s2.getMasteryLevel() - s1.getMasteryLevel());
        Bs.sort((Skill s1, Skill s2)->s2.getMasteryLevel() - s1.getMasteryLevel());
        for (int i = 0; i < As.size() + Bs.size(); i++)
        {
            if(ai != As.size() && bi != Bs.size()){
                if(As.get(ai).getMasteryLevel() == Bs.get(bi).getMasteryLevel()){
                    ret.add(As.get(ai));ai++;
                    ret.add(Bs.get(bi));bi++;
                }
                else if(As.get(ai).getMasteryLevel() > Bs.get(bi).getMasteryLevel()){
                    ret.add(As.get(ai));ai++;
                }
                else{
                    ret.add(Bs.get(bi));bi++;
                }
            }
            else if(ai!=As.size() && bi==Bs.size()){
                ret.add(As.get(ai));ai++;
            }
            else if(ai==As.size() && bi!=Bs.size()){
                ret.add(Bs.get(bi));bi++;
            }
        }
    
        
        return ret;
    }
    public static int searchInVec(ArrayList<Skill> v, Skill S) {
        int ret = -1;
        for (int i = 0; i < v.size(); i++)
        {
            
            if(S.getName() == v.get(i).getName()){
                ret = i;
                break;
            }
        }
        return ret; 
    }
    public static Boolean compareElSkill(ArrayList<String> skillEl, ArrayList<String> engiEl){
        for (int i = 0; i < skillEl.size(); i++)
        {
            for (int j = 0; j < engiEl.size(); j++)
            {
                if(skillEl.get(i) == engiEl.get(j)) return true;
            }
            
        }
        return false;
    }
    public static void init(){
        dialogue.put("Fire",dial[0]);
        dialogue.put("Water",dial[1]);
        dialogue.put("Electric",dial[2]);
        dialogue.put("Ground",dial[3]);
        dialogue.put("Ice",dial[4]);
        dialogue.put("FireElectric",dial[5]);
        dialogue.put("ElectricFire",dial[6]);
        dialogue.put("WaterIce",dial[7]);
        dialogue.put("IceWater",dial[8]);
        dialogue.put("GroundWater",dial[9]);
        dialogue.put("WaterGround",dial[10]);
    }
    public static void compUnique(ArrayList<String> el,ArrayList<Skill> as){
        Skill S = new Skill("Basic Kick", el, 150, 1);
        if(el.size()==1){
            if(el.get(0)=="Fire") S = new Skill("Fire blast", el, 150, 1);
            else if(el.get(0)=="Water") S = new Skill("water bullet", el, 150, 1);
            else if(el.get(0)=="Electric") S = new Skill("100k Volt", el, 150, 1);
            else if(el.get(0)=="Ground")  S = new Skill("Earth Quake", el, 150, 1);
            else if(el.get(0)=="Ice")  S = new Skill("Bitter Frost", el, 150, 1);
            
        }
        else{
            if(el.get(0)=="Fire" && el.get(1)=="Electric") S = new Skill("Thunder Blaze", el, 150, 1);
            else if(el.get(0)=="Electric" && el.get(1)=="Fire")  S = new Skill("Fiery 100k Volt", el, 150, 1);
            else if(el.get(0)=="Water" && el.get(1)=="Ground") S = new Skill("Tsunami", el, 150, 1);
            else if(el.get(0)=="Ground" && el.get(1)=="Water")  S = new Skill("Tsunami", el, 150, 1);
            else if(el.get(0)=="Ice" && el.get(1)=="Water")  S = new Skill("Cold Destruction", el, 150, 1);
            else if(el.get(0)=="Water" && el.get(1)=="Ice") S = new Skill("Cold Destruction", el, 150, 1);
            
        }
        int idx = searchInVec(as, S);
        as.sort((Skill s1, Skill s2)->s2.getMasteryLevel() - s1.getMasteryLevel());
        if(idx!= -1){
            if(S.getMasteryLevel() > as.get(idx).getMasteryLevel()){
                as.remove(idx);
                as.add(idx,S);
            }
        }
        else{
            if(as.size() >= 4){
                as.remove(0);
                as.add(0,S);
            }
            else as.add(S);
        }
        as.sort((Skill s1, Skill s2)->s2.getMasteryLevel() - s1.getMasteryLevel());
    }
    // public static void main(String[] args) {
    //     ArrayList<String> Pname = new ArrayList<String>();
    //     init();
    //     Point Pos = new Point(11,3);
    //     ArrayList<Skill> skillA = new ArrayList<Skill>();
    //     ArrayList<String> elA  = new ArrayList<String>();
    //     ArrayList<String> elD  = new ArrayList<String>();
    //     elA.add("Water");

    //     Skill S = new Skill("Water Spurt",elA,100,1); // Masih ngasal
    //     skillA.add(S);
    //     // childName, PName, PSpecies, childSkills ,childSpec, childEl, lives, level, xp , cumm xp , location
    //     Engimon A = new Engimon("Squirmon",dialogue.get("Water"),Pname,Pname,skillA,"Squirmon",elA,3,5,0,0,Pos);

    //     ArrayList<Skill> skillC = new ArrayList<Skill>();
    //     ArrayList<String> elC  = new ArrayList<String>();
    //     elC.add("Ice");
    //     elD.add("Ice");
    //     elD.add("Water");
    //     Skill U = new Skill("Frost Br",elC,150,3);
    //     skillC.add(U);
    //     Engimon C = new Engimon("Dinginmon",dialogue.get("Ice"),Pname,Pname,skillC,"Dinginmon",elC,4,5,0,0,Pos);

    //     Engimon X = Breed(A, C, "SonMon");
    //     System.out.println(X.toString());
        

    // }


}