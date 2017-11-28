
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
        int n = 0, io = 0, procCycle = 0, ioCycle = 0, cycles = 0;
        
        int procCount = 0;
        
        boolean go = false; boolean flag = false;
        
        CPU1 cpu1 = new CPU1();
        
        Memory mem = new Memory();
        
        
        
        Timer procTime = new Timer();
        
        Timer ioTime = new Timer();
        
        //check system condition before new process is input to the system
        
        if(mem.getRam()>200000){flag = true;}
        
        if (cpu1.getThred() > 8){go = true;}
        
        // this is the input of process cycles, or io cycles
        
        
        if (flag && go)
        { 
            if(procCycle <= cpu1.getThred())
            { n = procCycle;          
            }
            else{n = cpu1.getThred();
           
            }
            cpu1.addProcess(n,"P1");
             procCycle  = procCycle - n;
                
            procCount ++;
        
        if (cpu1.getThred()<= 8) {cpu1.fillNull();procTime.updateTimer(procCount);}
         //else repeat process
        }
         
        //memory and cpu resouurce has already reserved to handle io aka interuupts. so there's no need to check condition to run io.
        ioCycle = cycles;
        
        if(ioCycle >0){ 
        
         if(ioCycle <= cpu1.getThred()){io = ioCycle;}
         else{io = cpu1.getThred(); ioCycle = ioCycle - io;}
         cpu1.io2Process(io, "io1");
         
         cpu1.io4Process(io, "io1"); ioTime.updateTimer(1);
         
         
         }
        
       
         
         
         
         
         
         
    }
    
}
