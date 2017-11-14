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
           
    
    public CPU1(){fillNull();}
    
    public int checker (int i)
    {  int n = 0;
        if (i == 1){n = counter1 ;}
        else if (i == 2){n = counter2;}
        else if (i == 3){n = counter3;}
        else if (i == 4){n = counter4;}
        
        return n;
    }
    
    public void fillNull()
    {int i;
        for(i=0; i<20; i++)
        {Core1Thred1[i] = "null";
         Core1Thred2[i] = "null";
         Core2Thred1[i] = "null";
         Core2Thred2[i] = "null";
        }
    }
    
    public void addProcess (int n, String str)
    { 
        int i; 
        
        for (i = 0; i <20; i++){
        
         if (n == 1){ if (Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}

         else if (n == 2){if (Core1Thred2[i].equals("null")){Core1Thred1[i] = str; counter2--;break;}}

        else if (n == 3){if (Core2Thred1[i].equals("null")){Core1Thred1[i] = str; counter3--; break;}}
        
        else if (n == 4){if (Core2Thred2[i].equals("null")){Core1Thred1[i] = str; counter4--; break;}}
        } 
    }
     
    
    public void delProcess (int n, String str)
    { int i; 
        
        for (i = 0; i <20; i++){
        
         if (n == 1){ if (Core1Thred1[i].equals(str)){Core1Thred1[i] = "null"; counter1 ++; break;}}

         else if (n == 2){if (Core1Thred2[i].equals(str)){Core1Thred1[i] = "null"; counter2++;break;}}

        else if (n == 3){if (Core2Thred1[i].equals(str)){Core1Thred1[i] = "null"; counter3++; break;}}
        
        else if (n == 4){if (Core2Thred2[i].equals(str)){Core1Thred1[i] = "null"; counter4++; break;}}
        }
        
    
    }
    
    public int getMax()
    {int n = 0;
    
     if(counter1 >= counter2)
     {n = 1;
         if (counter1 >= counter3){n = 1; 
                                   if (counter1 >= counter4){n = 1;}
                                   else {n = 4;} 
                                  }
         else{n = 3;  
              if(counter3>= counter4){n = 3;} 
              else{n = 4;} 
             }
     }
     else{n = 2;
           if(counter2 >= counter3){n =2;
                                    if (counter2 >= counter4){n = 2;}
                                    else {n = 4;}
                                   }
           
           else{n = 3;
                if(counter3 >= counter4){n = 3;}
                else {n = 4;}
              }
           } 
         
        
        return n; }
     
    
}
