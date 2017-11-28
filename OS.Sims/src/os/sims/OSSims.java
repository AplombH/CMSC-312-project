
package os.sims;

/**
 *
 * @author APLOMB
 */
public class OSSims {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0, io = 0;
        
        CPU1 cpu1 = new CPU1();
        
        Memory mem = new Memory();
        
        if(mem.getRam()>200000){}
        
        if (cpu1.getThred() > 8){
        cpu1.addProcess(n,"P1");
        
         cpu1.addProcess(15, "P2");
        
         cpu1.addProcess(21, "P2");}
         
        
        
         cpu1.io2Process(io, "io");
         
         
         
         
          
        
        //here I want to add if cpu1.checker 1,2,3,4 equal 1, then new processes need to wait till either one free up
        
        
        // here I want to add, if ram and virtual memory is about to be full, new process need to wait
        
        // basically we can loop the add and del process, update memory status and counter, that's it.
        
        
        
        
    }
    
}
