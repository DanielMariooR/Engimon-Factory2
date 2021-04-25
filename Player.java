import java.util.*;

public class Player{
    private Engimon Active;
    public Inventory<Engimon> ownedEngimon;
    private Inventory<Item> skillItems;
    private Point playerPos;

    public Player(){
        this.Active = new Engimon();
        this.ownedEngimon = new Inventory<Engimon>();
        this.skillItems = new Inventory<Item>();
        this.playerPos = new Point();
    }
    public Player(Engimon E){
        this.Active = E;
        this.playerPos = new Point();
        this.ownedEngimon = new Inventory<>();
        this.skillItems = new Inventory<>();
        ownedEngimon.masuk(E);
    }

    public Player(Engimon E,Inventory<Engimon> ownedEngimon,Inventory<Item> skillItems,Point playerPos){
        this.Active = E;
        this.playerPos = playerPos;
        this.ownedEngimon = ownedEngimon;
        this.skillItems = skillItems;
        ownedEngimon.masuk(E);
    }

    public Player(int x, int y){
        playerPos = new Point(x, y);
        this.ownedEngimon = new Inventory<>();
        this.skillItems = new Inventory<Item>();
    }

    public void setActive(Engimon E){
        this.Active = E;
    }

    public void changePosition(int dx, int dy){
        playerPos.setX(playerPos.getX() + dx);
        playerPos.setY(playerPos.getY() + dy);
    }

    public void switchActive(){
        System.out.println("Pick active engimon: ");
        ownedEngimon.show();
        Scanner scan = new Scanner(System.in);
        int idx = scan.nextInt();
        this.Active = ownedEngimon.getItem(idx-1);
        scan.close();
    }

    public void addEngimon(Engimon E){
        ownedEngimon.masuk(E);
    }

    public void showAllEngimon(){
        for(Engimon E: ownedEngimon.getInv()){
            System.out.println(E.toString());
        }
    }

    public void useItem(){
        Scanner scan = new Scanner(System.in);
        int idx = scan.nextInt();
        Item temp = skillItems.getItem(idx-1);
        Skill skill = temp.getSkill();

        boolean found = false;
        boolean cancel = false;

        while(!found && !cancel){
            showAllEngimon();
            System.out.println("Enter the engimon to learn skill!\n");
            System.out.println("Enter 0 to cancel!\n");
            int id = scan.nextInt();

            if(id == 0) cancel = true ;

            else {
                boolean elemFound = false;
                Engimon current = ownedEngimon.getItem(id);
                for(String engimonElem: current.getElem()){
                    for(String skillElem: skill.getElem()){
                        if(engimonElem.equals(skillElem) && !found){
                            elemFound = true;
                            if(current.getSkills().size() == 4){
                                System.out.println("Your engimon cannot have more than 4 skills\n");
                                current.showSkills();
                                System.out.println("Choose skill to forget!\n");
                                int skillid = scan.nextInt();
                                current.removeSkill(skillid-1);
                            }

                            current.insertSkill(skill);
                            found = true;
                            break;
                        } 
                    }
                }
                if(!elemFound) System.out.println("The Engimon you choose are not compatible with the skill\n");
            }
        }
    }

    public void addSkillItem(Item item){
        
        if(skillItems.itemExist(item)){
            Item temp = skillItems.getItem(item);
            if(temp.getJumlah()+1 <= 10){
                temp.setJumlah(temp.getJumlah()+1);
                BaseInventory.fill();
            } 
        } else {
            skillItems.masuk(item);
        }
    }

    public Point getPos(){
        return this.playerPos;
    }

    public String showActiveDetail(){
        return Active.toString();
    }

    public Engimon getActive(){
        return Active;
    }

    public void showItem(){
        skillItems.show();
    }

    public List<Engimon> getInventoryEngimons(){
        return ownedEngimon.getInv();
    }

    public List<Item> getInventoryItem(){
        return skillItems.getInv();
    }
    public Inventory<Engimon> getEngi(){
        return ownedEngimon;
    }
    public void sortSkill(){
        skillItems.getInv().sort((Item i1, Item i2)->i2.getSkill().getMasteryLevel() - i1.getSkill().getMasteryLevel());
    }
    public void sortEngimon(){
        String[] order = {"Fire","Water","Electric","Ground","Ice","FireElectric","ElectricFire","WaterIce","IceWater","GroundWater","WaterGround"};
        ownedEngimon.getInv().sort((Engimon e1, Engimon e2) ->{
            if(e1.getElem().size()==1 && e2.getElem().size()==1){
                if(e1.getElem().get(0).equals(e2.getElem().get(0))) return e2.getLevel() - e1.getLevel(); 
                else{
                    return (Arrays.asList(order).indexOf(e1.getElem().get(0)) - Arrays.asList(order).indexOf(e2.getElem().get(0)));
                }
            }
            else if(e1.getElem().size()==2 && e2.getElem().size()==2){
                if(((e1.getElem().get(0).equals(e2.getElem().get(0))) && (e1.getElem().get(1).equals(e2.getElem().get(1)))) || ((e1.getElem().get(0).equals(e2.getElem().get(1))) && (e1.getElem().get(1).equals(e2.getElem().get(0))))) return e2.getLevel() - e1.getLevel();
            
                else{
                    return (Arrays.asList(order).indexOf(e1.getElem().get(0) + e1.getElem().get(1)) - Arrays.asList(order).indexOf(e2.getElem().get(0) + e2.getElem().get(1)));
                }
            }
            else return (e1.getElem().size() - e2.getElem().size());
        });
    }

 


}