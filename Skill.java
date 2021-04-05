import java.util.*;

public class Skill{
    private String name;
    private ArrayList<String> elements;
    private int basePower;
    private int masteryLevel;

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

    public void skillDetail(){
        System.out.println("Skill Detail: ");
    }
}