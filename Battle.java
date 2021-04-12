import java.util.*;


/* 
Whats NEW ?
Cant battle if there are no active engimon (di main kah ??)
Show Status and total power before battle (Y/N) 
If lose : minus 1 life from that engimon. 
If win : skill item not random, but first slot from enemies angimon 
*/

public class Battle{
    public Battle(){

    }
    public int Power(Engimon Active,Engimon e){
        int power;
        power = (Active.getLvl() * AdvElmt(Active,e)) + TotSkill(Active);
        return power;
    }
    public void ShowStatus(Engimon Active, Engimon e){
        //SHOW DETAIL ENGIMON
        System.out.print("Your Engimon ");
        System.out.print(Active.getname());
        System.out.print("Power is : ");
        System.out.println(Power(Active,e));
        //SHOW DETAIL ENEMY
        System.out.print("Enemy Engimon ");
        System.out.print(Active.getname());
        System.out.print("Power is : ");
        System.out.println(Power(e,Active));

        Scanner sc= new Scanner(System.in);
        System.out.print("Baku Hantam tak ? (Y/N) ");
        String jawaban = sc.nextLine();
        if (jawaban.equals("Y")){
            //Result(Active, e, player);
        }
        else if (jawaban.equals("N")){
            System.out.print("Berhasil kabur");
        }
    }
    public int TotSkill(Engimon Active){
        int total=0;
        ArrayList<String> aSkills = Active.getSkills();
        for(int i=0;i<aSkills.size();i++){
            total=total+(aSkills.get(i)).getMasteryLevel()*aSkills.get(i).getBasePower());
        }
        return total;
    }
    
    public double AdvElmt(Engimon Active, Engimon e){
        double hasil =0;
        ArrayList<String> pElmt = Active.getElements();
        ArrayList<String> eElmt = e.getElements();
        for(int i=0;i<pElmt.size();i++){
            for(int j=0;j<eElmt.size();j++){
                if(pElmt.get(i) == "Fire"){
                    if(eElmt.get(j) == "Fire"){
                        hasil=Maks(hasil,1);
                    } 
                    else if(eElmt.get(j) == "Water"){
                        hasil=Maks(hasil,0);
                    }
                    else if(eElmt.get(j)== "Electric"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Ground"){
                        hasil=Maks(hasil,0.5);
                    }
                    else if(eElmt.get(j)== "Ice"){
                        hasil=Maks(hasil,2);
                    }
                }
                else if(pElmt.get(i)== "Water"){
                    if(eElmt.get(j) == "Fire"){
                        hasil=Maks(hasil,2);
                    } 
                    else if(eElmt.get(j) == "Water"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Electric"){
                        hasil=Maks(hasil,0);
                    }
                    else if(eElmt.get(j)== "Ground"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Ice"){
                        hasil=Maks(hasil,1);
                    }
                }
                else if(pElmt.get(i)== "Electric"){
                    if(eElmt.get(j) == "Fire"){
                        hasil=Maks(hasil,1);
                    } 
                    else if(eElmt.get(j) == "Water"){
                        hasil=Maks(hasil,2);
                    }
                    else if(eElmt.get(j)== "Electric"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Ground"){
                        hasil=Maks(hasil,0);
                    }
                    else if(eElmt.get(j)== "Ice"){
                        hasil=Maks(hasil,1.5);
                    }
                }
                else if(pElmt.get(i)== "Ground"){
                    if(eElmt.get(j) == "Fire"){
                        hasil=Maks(hasil,1.5);
                    } 
                    else if(eElmt.get(j) == "Water"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Electric"){
                        hasil=Maks(hasil,2);
                    }
                    else if(eElmt.get(j)== "Ground"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Ice"){
                        hasil=Maks(hasil,0);
                    }
                }
                else if(pElmt.get(i)== "Ice"){
                    if(eElmt.get(j) == "Fire"){
                        hasil=Maks(hasil,0);
                    } 
                    else if(eElmt.get(j) == "Water"){
                        hasil=Maks(hasil,1);
                    }
                    else if(eElmt.get(j)== "Electric"){
                        hasil=Maks(hasil,0.5);
                    }
                    else if(eElmt.get(j)== "Ground"){
                        hasil=Maks(hasil,2);
                    }
                    else if(eElmt.get(j)== "Ice"){
                        hasil=Maks(hasil,1);
                    }
                }
            }
        }
        return hasil;
    }
    public double Maks(double a, double b){
        if(a>=b){
            return a;
        }
        else {
            return b;
        }
    }
    
    public void Result(Engimon Active,Engimon e, Player p){
        
        if(Power(Active,e)>=Power(e,Active)){
            Active.setExp(Active.getExp()+50);
            Active.LevelUp();
            p.addEngimon(e);
            //vector<string> elA = e.getElements();
            //srand((unsigned) time(0));
            //int i= rand()% elA.size();
            //vector<string> elAnew;
            //elAnew.push_back(elA.at(i));
            //string name = elAnew.at(0) + "attack";
            //Item N(name,100,elAnew);
            //p.addSkillItem(N);
            System.out.println("WIN");
        }
        else {
            
            //minus 1 live engimon
            //if live != 0
            System.out.println("LOSE");
            //else
            System.out.println("LOSE");
            p.killActive();
        }   
}
