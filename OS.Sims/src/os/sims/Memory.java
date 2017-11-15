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
public class Memory {
    
    private int cache1 = 64;
    
    private int cache2 = 256;
    
    private int cache3 = 2048;
    
    private int Ram = 4096000;
    
    private int VRam = 4096000;
    
    public Memory(){}
    
    public int converter(int n)
    { int quote = 0;
        if(n%64 == 0){quote = n/64;}
        else{quote = (n/64)+1; }
        
        return quote;}
    
    
    public int mCounter ()
    {
        return Ram + VRam;
    }
    
    
}
