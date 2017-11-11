/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.sims;

/**
 *
 * @author APLOMB
 */
public class CPU1 {

    
    private String [] Core1Thred1 = new String [20];
    
    private String [] Core1Thred2 = new String [20];
    
    private String [] Core2Thred1 = new String [20];
    
    private String [] Core2Thred2 = new String [20];
    
    private int counter1 = 20;
    
    private int counter2 = 20;
    
    private int counter3 = 20;
    
    private int counter4 = 20;
           
    
    public CPU1(){}
    
    public String checker ()
    { 
        return "available resource: \n core1 tred1:" + counter1 + 
                "\n core1 tred2" + counter2+
                "\n core2 tred1" + counter3 +
                "\n core2 tred2" + counter4;
    }
    
    public void addProcess1 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core1Thred1[i].equals(null)){Core1Thred1[i] = "str"; counter1 --; flag = false;}
            else i++;
        
        }while(flag);
    }
     
    public void addProcess2 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core1Thred2[i].equals(null)){Core1Thred1[i] = "str"; counter2--; flag = false;}
            else i++;
        
        }while(flag);
    }
    
    public void addProcess3 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core2Thred1[i].equals(null)){Core1Thred1[i] = "str"; counter3--; flag = false;}
            else i++;
        
        }while(flag);
    }
    
    public void addProcess4 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core2Thred2[i].equals(null)){Core1Thred1[i] = "str"; counter4--; flag = false;}
            else i++;
        
        }while(flag);
    }
    
    public void delProcess1 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core1Thred1[i].equals(str)){Core1Thred1[i] = "null"; counter1 ++; flag = false;}
            else i++;
        
        }while(flag);
    }
     
    public void delProcess2 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core1Thred2[i].equals(str)){Core1Thred2[i] = "null"; counter2 ++; flag = false;}
            else i++;
        
        }while(flag);
    }
    
    public void delProcess3 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core2Thred1[i].equals(str)){Core2Thred1[i] = "null"; counter3++; flag = false;}
            else i++;
        
        }while(flag);
    }
    
    public void delProcess4 (String str)
    { int i = 0; boolean flag = true;
        do{
            if (Core2Thred2[i].equals(str)){Core1Thred1[i] = "null"; counter4++; flag = false;}
            else i++;
        
        }while(flag);
    }
}
