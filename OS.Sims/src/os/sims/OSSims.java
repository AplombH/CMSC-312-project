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
public class OSSims {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CPU1 cpu1 = new CPU1();
        
        
        cpu1.addProcess(1,"P1");
        
        cpu1.addProcess(1, "P4");
        
         System.out.println("updated resources: core1 tred1: " + cpu1.checker(1));
         
         cpu1.addProcess(2, "P2");
         
         System.out.println("updated resources: core1 tred2: " + cpu1.checker(2));
         
        // cpu1.addProcess(3, "P3");
         
         //cpu1.addProcess(3, "P5");
         
         System.out.println("updated resources: core2 tred1: " + cpu1.checker(3));
         
        // cpu1.addProcess(4, "P6");
         
         //cpu1.addProcess(4, "p7");
         
        // cpu1.addProcess(4, "P8");
         
         System.out.println("updated resources: core2 tred2: " + cpu1.checker(4));
         
         
         System.out.println(cpu1.getMax());
         
         cpu1.delProcess(1,"P1");
         
          System.out.println("updated resources: core1 tred1: " + cpu1.checker(1));
        
        
        
        
        
    }
    
}
