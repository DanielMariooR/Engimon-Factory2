
import java.util.*;

public class Engimon{
    private String name;
    private int level;
    private int exp;
    private int lives;
    private int totalxp;
    private String species;
    public ArrayList<String>  Elements;
    private ArrayList<String> parentName;
    private ArrayList<String> parentSpecies;
    private ArrayList<Skill> skills;
    private Point position;

    public Engimon(){
        this.name = "XXX";
        this.level = 0;
        this.exp = 1;
        this.lives = 3;
        this.species = "Basic";
        this.skills = new ArrayList<>();
        this.parentName = new ArrayList<>();
        this.parentSpecies = new ArrayList<>();
        this.Elements = new ArrayList<>();
        this.position = new Point(0,0);
        Elements.add("Ground");
    }

    
    // childName, PName, PSpecies, childSkills ,childSpec, childEl, lives, level, xp , cumm xp , location
    public Engimon(String n,ArrayList<String> pn, ArrayList<String> ps, ArrayList<Skill> sk, String sp, ArrayList<String> el, int live, int lvl, int xp, int totxp, Point pos){
        this.name = n;
        this.parentName = pn;
        this.parentSpecies = ps;
        this.skills = sk;
        this.species = sp;
        this.Elements = el;
        this.lives = live;
        this.level = lvl;
        this.exp = xp;
        this.totalxp = totxp;
        this.position = pos;
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

    public int getLevel(){
        return this.level;
    }

    public Integer getExp(){
        return this.exp;
    }

    public Integer getLives(){
        return this.lives;
    }
    
    public void setLives(int live){
        this.lives = live;
    }
    
    public Skill getFirstSkill(){
        return this.skills.get(0);
    }

    public Integer getTotExp(){
        return this.totalxp;
    }
    
    public void setLevel(int lvl){
        this.level = lvl;
        this.totalxp = this.level * 100;
    }

    public void setExp(int xp){
        this.exp = xp;
    }

    public String getSpecies(){
        return this.species;
    }

    public void incrExp(int xp){
        this.exp += xp;
        this.totalxp += xp;
        checkStatus();
    }

    public void checkStatus(){
        if((this.level+1)*100 > this.exp){
            this.level++;
            this.exp -= this.level * 100;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Skill> getSkills(){
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

    public void setElem(ArrayList<String> elem){
        this.Elements = elem;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Nama: " + this.name + "\n");
        str.append("Spesies: "+ this.species + "\n");
        str.append("Level: "+ this.level + "\n");
        str.append("Lives: "+this.lives + "\n");

        if(!skills.isEmpty()){
            str.append("Skills:\n");
            int idx = 1;
            for(Skill S : skills){
                str.append(idx + " " + S.toString());
                idx++;
            }
        }

        if(!Elements.isEmpty()){
            str.append("Elements:\n");
            for(String s: Elements){
                str.append(s + "\n");
            }
        }
        
        if(!parentName.isEmpty() && !parentSpecies.isEmpty()){
            for(int i=0; i<2; i++){
                str.append("Nama Parent: " + this.parentName.get(i) + "\n");
                str.append("Spesies Parent: " + this.parentSpecies.get(i) + "\n");
            }
        }

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

    public void showDetail(){
        System.out.println("Nama : " + this.name);
        System.out.println("Species : " + this.species);
        System.out.println("Level : " + this.level);
    }
}
