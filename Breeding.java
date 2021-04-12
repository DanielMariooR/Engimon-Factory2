import java.util.ArrayList;

public class Breeding{

    public static Engimon Breed(Engimon A, Engimon B,String childName){
        if(A.getLvl() < 4 || B.getLvl() < 4) throw A.getLvl(); // Throw Exception if either parent lv < 30
        // get child attributes
        ArrayList<String> childElSpec = setChildElSpec(A,B);
        ArrayList<String> childEl;
        for (int i = 1; i < childElSpec.size(); i++)
        {
            childEl.add(childElSpec[i]);
        }
        String childSpec = childElSpec[0];
    
        ArrayList<Skill> childSkills = setChildSkills(A,B,childEl);
    
        //Subtract parents lv
        A.setLvl(A.getLvl() - 3);
        B.setLvl(B.getLvl()- 3);
    
        ArrayList<String> PName;
        ArrayList<String> PSpecies;
        PName.add(A.getName());
        PName.add(B.getName());
        PSpecies.add(A.getSpecies());
        PSpecies.add(B.getSpecies());
        Point P = new Point(0,0);
        return new Engimon(childName,PName,PSpecies,childSkills,1,0,0,childSpec,childEl,P); 
    }
    // Set Child Skills - Skill Unik spesies anak blm di handle ; Bypass constraint atribut anak blm di handle
    // Priority : 1. Higher Mastery Level 2. A Skill 3. Lowest index
    public static ArrayList<Skill> setChildSkills(Engimon A, Engimon B, ArrayList<String> El ){
        ArrayList<Skill> aSkills = A.getSkills();
        ArrayList<Skill> bSkills = B.getSkills();
        ArrayList<Skill> mergedSkills = concatSkill(aSkills,bSkills);
        ArrayList<Skill> childSkills;
        int count = 0; // Counter childSkills
        int maxMasteryA = 0;
        int maxMasteryB = 0;
        for (int i = 0; i < mergedSkills.size(); i++)
        {
            if(childSkills.size() < 4){
                // Bypass constraint atribut anak blm di handle
            if(searchInVec(childSkills,mergedSkills.get(i)) == -1 && compareElSkill(mergedSkills.get(i).getElement(),El) == true){
                int idxA = searchInVec(aSkills,mergedSkills.get(i));
                int idxB = searchInVec(bSkills,mergedSkills.get(i));
                if(idxA != -1 && idxB != -1){
                    if(aSkills.get(idxA).getMasteryLevel() == bSkills.get(idxB).getMasteryLevel()){
                        if(aSkills.get(idxA).getMasteryLevel() == 3) mergedSkills.get(i).setMasteryLevel(aSkills.get(idxA).getMasteryLevel());
                        else mergedSkills.get(i).setMasteryLevel(aSkills.get(idxA).getMasteryLevel() + 1);
                    }
                    else if(aSkills.get(idxA).getMasteryLevel() > bSkills.get(idxB).getMasteryLevel()){
                        mergedSkills.get(i).setMasteryLevel(aSkills.get(idxA).getMasteryLevel());
                    }
                    else mergedSkills.get(i).setMasteryLevel(bSkills.get(idxB).getMasteryLevel());
                    childSkills.add(mergedSkills.get(i));
                }
                else childSkills.add(mergedSkills.get(i));
                }
            }
    
        }
    
        return childSkills;
    }
    public static ArrayList<String> setChildElSpec(Engimon A, Engimon B){
        ArrayList<String> elSpec;
        if(A.getElements().size() == 2 || B.getElements().size()==2) System.out.println("Elemen salah satu / kedua parent lebih dari 1. Akan diambil elemen pertama masing-masing parent");
        if(A.getElements().get(0) == B.getElements().get(0)){  // Same elements
            elSpec.add(A.getSpecies()); // Aturan : ambil species parent A
            elSpec.add(A.getElements().get(0));
            }
        else{ // Diff elements
            if(strongerEl(A.getElements().get(0),B.getElements().get(0)) == 1){ // ambil elemen dan species A
                elSpec.add(A.getSpecies());
                elSpec.add(A.getElements().get(0));
                 
            }
            else if(strongerEl(A.getElements().get(0),B.getElements().get(0)) == -1){ // ambil elemen dan species B
                elSpec.add(B.getSpecies()); 
                elSpec.add(B.getElements().get(0));
                    
            }
            else{ // Kasus Elemen Advantage Sama
                String aSpecies = A.getSpecies();
                aSpecies = aSpecies.subString(0,aSpecies.size()-3);
                String species = aSpecies + B.getSpecies(); 
                elSpec.add(species);
                elSpec.add(A.getElements().get(0));
                elSpec.add(B.getElements().get(0));
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
    public static ArrayList<Skill> concatSkill(ArrayList<Skill> As, ArrayList<Skill> Bs){
        ArrayList<Skill> ret;
        int ai = 0;
        int bi = 0;
        sort(As.begin(),As.end());
        reverse(As.begin(),As.end());
        sort(Bs.begin(),Bs.end());
        reverse(Bs.begin(),Bs.end());
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
    public static int searchInVec(ArrayList<Skill> v, ArrayList<Skill> S) {
        int ret = -1;
        for (int i = 0; i < v.size(); i++)
        {
            
            if(S == v.get(i)){
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

}