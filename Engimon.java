import java.util.*;

public class Engimon{
    private String name;
    private int level;
    private int exp;
    private int lives;
    private int totalxp;
    private String species;
    private ArrayList<String>  Elements;
    private ArrayList<String> parentName;
    private ArrayList<String> parentSpecies;
    private ArrayList<Skill> skills;
    private Point position;

    public Engimon(){
        this.name = "XXX";
        this.level = 0;
        this.exp = 1;
        this.lives = 3;
        position = new Point(0,0);
    }

    public List<String> getParentName(){
        return this.parentName;
    }

    public List<String> getParentSpecies(){
        return this.parentSpecies;
    }

    public String getName(){
        return this.name;
    }

    public Integer getLevel(){
        return this.level;
    }

    public Integer getExp(){
        return this.exp;
    }

    public Integer getLives(){
        return this.lives;
    }

    public Integer getTotExp(){
        return this.totalxp;
    }
    
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

    public void setPos(Point p){
        this.position.setX(p.getX());
        this.position.setY(p.getY());
    }

    public Point getPos(){
        return this.position;
    }


    public void removeSkill(int idx){
        this.skills.remove(idx);
    }

    public List<String> getElem(){
        return this.Elements;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Nama: " + this.name + "\n");
        str.append("Level: "+ this.level + "\n");
        str.append("Lives: "+this.lives + "\n");
        return str.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;

        if(!(o instanceof Engimon)) return false;

        Engimon E = (Engimon) o;

        return this.name.equals(E.getName()) && this.species.equals(E.getSpecies()) && this.Elements.equals(E.getElem()) && this.parentName.equals(E.getParentName());
    }

    public void showSkills(){
        for(Skill S: this.skills) {
            System.out.println(S.toString());
        }
    }
}
