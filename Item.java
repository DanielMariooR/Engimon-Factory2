import java.util.*;


public class Item{
    private Skill skill;
    private int jumlah;

    public Item(){
        this.jumlah = 0;
    }

    public Item(String name, int power, List<String> elements){
        skill = new Skill(name, elements, power, 1);
        this.jumlah = 1;
    }

    public Item(String name, int power, List<String> elements, int masteryLevel){
        skill = new Skill(name, elements, power, masteryLevel);
        this.jumlah = 1;
    }
    public Item(Skill S){
        this.skill = S;
        this.jumlah = 1;
    }

    public String getName(){
        return this.skill.getName(); 
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public int getJumlah(){
        return this.jumlah;
    }

    public Skill getSkill(){
        return this.skill;
    }

    public void showDetail(){
        System.out.printf("Nama: %s%n", getName());
        System.out.printf("Power: %d%n", this.skill.getBasePower());
        System.out.printf("Jumlah: %d%n", this.jumlah);
    }
    
    @Override
    public boolean equals(Object o){
        if(o == this) return true;

        if(!(o instanceof Item)) return false;

        Item item = (Item) o;
        
        return this.getSkill().getName().equals(item.getSkill().getName()) && this.getSkill().getElem().equals(item.getSkill().getElem());
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Nama: " + skill.getName() + "\n");
        str.append("Power: " + skill.getBasePower() + "\n");
        str.append("Mastery Level: " + skill.getMasteryLevel() + "\n");
        return str.toString();
    }
}