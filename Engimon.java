import java.awt.Point;
import java.util.*;

class Engimon{
    private String name;
    private int level;
    private int exp;
    private int lives;
    private int totalxp;
    private string species;
    private ArrayList<String>  Elements;
    private ArrayList<String> parentName;
    private ArrayList<String> parentSpecies;
    private ArrayList<Skill> skills;
    private Point position;

    public void setLevel(int lvl){
        this.level = lvl;
    }

    public void setExp(int xp){
        this.exp = xp;
    }

    public String getSpecies(){
        return this.species;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Skill> getSkills(){
        return this.skills;
    }

    public void insertSkill(Skill newSkill){
        this.skills.add(newSkill);
    }

    public void move(int x, int y){
        this.position.setX(position.getX()+x);
        this.position.setY(position.getY()+y);
    }

    public void setPos(Position p){
        this.position.setX(p.getX());
        this.position.setY(p.getY());
    }

    public Position getPos(){
        return this.position;
    }

}