import java.util.*;


/* 
Whats NEW ?
Cant battle if there are no active engimon (di main kah ??) done
Show Status and total power before battle (Y/N) done
If lose : minus 1 life from that engimon. done
If win : skill item not random, but first slot from enemies angimon  DONE
*/

public class Battle{
    public Battle(){

    }
    public double Power(Engimon Active,Engimon e){
        double power;
        power = (Active.getLevel() * AdvElmt(Active,e)) + TotSkill(Active);
        return power;
    }
    public String ShowStatus(Engimon Active, Engimon e, Player p){
        //SHOW DETAIL ENGIMON
        String out = "Your Engimon : " + Active.getName()+ "\n";
        out += "Power is : " + Power(Active,e)+ "\n\n";
        //SHOW DETAIL ENEMY
        out += "Enemy Engimon :" + e.getName()+ "\n";
        out += "Power is : " + Power(e,Active) + "\n\n";

        //Scanner sc= new Scanner(System.in);
        out +="Baku Hantam tak ? (Y/N) ";
        //String jawaban = sc.nextLine();
        //if (jawaban.equals("Y")){
        //    Result(Active, e, p);
        //}
        //else if (jawaban.equals("N")){
        //   System.out.print("Berhasil kabur");
        //}
        //sc.close();
        return out;
    }
    public int TotSkill(Engimon Active){
        int total=0;
        ArrayList<Skill> aSkills = Active.getSkills();
        for(int i=0;i<aSkills.size();i++){
            total=total+(aSkills.get(i)).getMasteryLevel()*aSkills.get(i).getBasePower();
        }
        return total;
    }
    
    public double AdvElmt(Engimon Active, Engimon e){
        double hasil =0;
        List<String> pElmt = Active.getElem();
        List<String> eElmt = e.getElem();
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
    
    public String Result(Engimon Active,Engimon e, Player p){
        if(Power(Active,e)>=Power(e,Active)){
            Active.incrExp(50);
            if(Active.getLevel()==45){
                p.ownedEngimon.keluar(Active);
            }
            p.addEngimon(e);
            Skill get = e.getFirstSkill();
            int power = get.getBasePower();
            String name = get.getName();
            List<String> el = new ArrayList<String>(); 
            el = get.getElem();
            Item A = new Item(name, power, el);
            p.addSkillItem(A);
            String win = "WIN";
            return win;
        }
        else {
            Active.setLives(Active.getLives()-1);
            if(Active.getLives() == 0){            
                p.ownedEngimon.keluar(Active);
                //p.switchActive();
            }
            String lose = "LOSE";
            return lose;
        }   
    }
}

