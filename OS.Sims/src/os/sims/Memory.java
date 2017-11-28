
package os.sims;

/**
 *
 * @author APLOMB
 */
public class Memory {
    
//    private int cache1 = 64;
//    
//    private int cache2 = 256;
//    
//    private int cache3 = 2048;
    
    private int Ram = 4096000;
    
    private int VRam = 4096000;
    
    public Memory(){}
    
    public int converter(String str, int n)
    { int quote = 0;
        
        if(str.equalsIgnoreCase("mb")){n= n*1000;}
    
    
        if(n%64 == 0){quote = n/64;}
        else{quote = (n/64)+1; }
        
        return quote;}
    
    public void add2Mem(int n)
    {  if(n >= 20000){Ram = Ram - 20000; VRam = VRam - (n-20000);}
       else{Ram = Ram - n;}
    
    }
    
    public void io2Mem (int n)
    { Ram = Ram - n;    }
    
    public void del4Mem(int n)
    {  if(n >= 20000){Ram = Ram + 20000; VRam = VRam + (n-20000);}
       else{Ram = Ram + n;}
    
    }
    
    public void io4Mem (int n)
    { Ram = Ram + n;}       
    
    public int mCounter ()
    {
        return Ram + VRam;
    }
    
    
    
    
}
