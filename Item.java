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

    public String getName(){
        return this.skill.getName(); 
    }

    public setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public Skill getSkill(){
        return this.skill;
    }

    public void printItem(){
        System.out.printf("Nama: %s%n", getName());
        System.out.printf("Power: %d%n", this.skill.getBasePower());
        System.out.printf("Jumlah: %d%n"), this.jumlah);
    }    
}