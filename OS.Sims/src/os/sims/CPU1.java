
package os.sims;

/**
 *
 * @author APLOMB
 */
public class CPU1 {

    
    private String [] Core1Thred1 = new String [32];
    
    private String [] Core1Thred2 = new String [32];
    
    private String [] Core2Thred1 = new String [32];
    
    private String [] Core2Thred2 = new String [32];
    
    private int counter1 = 32;
    
    private int counter2 = 32;
    
    private int counter3 = 32;
    
    private int counter4 = 32;
           
    
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
        for(i=0; i<32; i++)
        {Core1Thred1[i] = "null";
         Core1Thred2[i] = "null";
         Core2Thred1[i] = "null";
         Core2Thred2[i] = "null";
        }
    }
    
    
    public void addProcess (int n, String str)
    { 
      Thread1 threadA = new Thread1(Core1Thred1, str,counter1);
      Thread2 threadB = new Thread2(Core1Thred2, str,counter2);
      Thread3 threadC = new Thread3(Core2Thred1, str,counter3);
      Thread4 threadD = new Thread4(Core2Thred2, str,counter4);
        int i, j, k; j = n/4;
        
        for(k = 0; k<j; k++){
            
        threadA.start();
        threadB.start();    
        threadC.start();
        threadD.start();
        
//        for (i = 0; i <30; i++){if(Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}
//
//        for (i = 0; i <30; i++){if (Core1Thred2[i].equals("null")){Core1Thred2[i] = str; counter2--;break;}}
//
//        for (i = 0; i <30; i++){if (Core2Thred1[i].equals("null")){Core2Thred1[i] = str; counter3--; break;}}
//        
//        for (i = 0; i <30; i++){if (Core2Thred2[i].equals("null")){Core2Thred2[i] = str; counter4--; break;}}
        } 
        
        j = n%4;
        
        for(i = 0; i<j; i++)
        { if (getMax() == 1){for (i = 0; i <30; i++){if(Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
        
          else if (getMax() == 2){for (i = 0; i <30; i++){if(Core1Thred2[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
          
          else if (getMax() == 3){for (i = 0; i <30; i++){if(Core2Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
          
          else if (getMax() == 4){for (i = 0; i <30; i++){if(Core2Thred2[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
        }
    }
     
    
     public void io2Process (int n, String str)
    { 
         int i, j, k; j = n/4;
        
        for(k = 0; k<j; k++){
        
        for (i = 0; i <32; i++){if(Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}

        for (i = 0; i <32; i++){if (Core1Thred2[i].equals("null")){Core1Thred2[i] = str; counter2--;break;}}

        for (i = 0; i <32; i++){if (Core2Thred1[i].equals("null")){Core2Thred1[i] = str; counter3--; break;}}
        
        for (i = 0; i <32; i++){if (Core2Thred2[i].equals("null")){Core2Thred2[i] = str; counter4--; break;}}
        } 
        
        j = n%4;
        
        for(i = 0; i<j; i++)
        { if (getMax() == 1){for (i = 0; i <32; i++){if(Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
        
          else if (getMax() == 2){for (i = 0; i <32; i++){if(Core1Thred2[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
          
          else if (getMax() == 3){for (i = 0; i <32; i++){if(Core2Thred1[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
          
          else if (getMax() == 4){for (i = 0; i <32; i++){if(Core2Thred2[i].equals("null")){Core1Thred1[i] = str; counter1 --; break;}}}
        }
    }
    
    public void io4Process (int n, String str)
    { int i,j, k; j = (n/4)+1;
        
        for (k = 0; k <j; k++){
        
         for (i = 0; i <32; i++){ if (Core1Thred1[i].equals(str)){Core1Thred1[i] = "null"; counter1 ++; break;}}

         for (i = 0; i <32; i++){if (Core1Thred2[i].equals(str)){Core1Thred2[i] = "null"; counter2++;break;}}

        for (i = 0; i <32; i++){if (Core2Thred1[i].equals(str)){Core2Thred1[i] = "null"; counter3++; break;}}
        
        for (i = 0; i <32; i++){if (Core2Thred2[i].equals(str)){Core2Thred2[i] = "null"; counter4++; break;}}
        }
        
    }
    
    public int getThred()
    {         return counter1+counter2+counter3+counter4;    }
    
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
     
    public void printArray()
    { int i;
        for(i = 0; i <32; i++ ){
        System.out.println(Core1Thred1[i]);}
    }
    
}
