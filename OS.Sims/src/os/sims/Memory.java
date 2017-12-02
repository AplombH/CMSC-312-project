
package os.sims;

/**
 * @author APLOMB
 */

/*Memory Algorithm
**When theres a new process in the link list,
**we check if the total memory has enough space according the size of the new process
**then we check if there's space in main memory(ram), reserved 200 mb in ram to run interrupts
**if the above 2 checks out. Process changes from new state to ready state, else process stays in new state
**we pass the process and this state to cpu to handle.
*/

public class Memory {
    

    
    private int Ram = 4096000;
    
    private int VRam = 4096000;
    
    public Memory(){}
    
    public int converter(String str, int n) // conver mb to kb
    { int quote = 0;
        
        if(str.equalsIgnoreCase("mb")){n= n*1000;}
    
    
        if(n%64 == 0){quote = n/64;}
        else{quote = (n/64)+1; }
        
        return quote;}
    
    public void add2Mem(int n) // add process and reduce ram or/and virtual memory
    {  if(n >= 20000 ){Ram = Ram - 20000; VRam = VRam - (n-20000);}
   
    else{Ram = Ram - n;}
    
    }
    
    public void io2Mem (int n)
    { Ram = Ram - n;    }
    
    public void del4Mem(int n) // remove process and add teh ram back
    {  if(n >= 20000){Ram = Ram + 20000; VRam = VRam + (n-20000);}
       else{Ram = Ram + n;}
    
    }
    
    public void io4Mem (int n) // remove the interrupt from memory and give back the available space
    { Ram = Ram + n;}       
    
    public int mCounter () // checking the available overall memory
    {
        return Ram + VRam;
    }
    
   public int getVRam(){return VRam;}
    
    public int getRam(){return Ram;}
    
    public void resetMem(){Ram = 4096000; VRam = 4096000; }
    
}
