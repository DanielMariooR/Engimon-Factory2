import java.util.*;

public class Skill{
    private String name;
    private ArrayList<String> elements;
    private int basePower;
    private int masteryLevel;

    public Skill(){
        this.name = "XXX";
        this.basePower = 0;
        this.masteryLevel = 0;
        this.elements = new ArrayList<>();
    }

    public Skill(String name, List<String> element, int power, int level){
        this.name = name;
        this.basePower = power;
        this.masteryLevel = level;
        this.elements = new ArrayList<>();
        for(String S: element){
            this.elements.add(S);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBasePower(int power){
        this.basePower = power;
    }

    public void setMastery(int level){
        this.masteryLevel = level;
    }

    public int getBasePower(){
        return this.basePower;
    }

    public int getMasteryLevel(){
        return this.masteryLevel;
    }

    public String getName(){
        return this.name;
    }

    public List<String> getElem(){
        return this.elements;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Nama: " + this.name + "\n");
        str.append("Power: " + this.basePower + "\n");
        str.append("Level: " + this.masteryLevel + "\n");
        return str.toString();
    }
}