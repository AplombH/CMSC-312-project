/**
 * @author Aaron Kim, Aplomb Huang, Fofini
 * CMSC 312 Fall 2017 Project
 * OS simulation
 * This project is to simulate an OS's key components
 * This is the Main class with basic text file input and output.
 * All classes will be under the os.sims package in order to work
 */


package os.sims;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class OSSims {

  private OSmonitorIUG  monIUG = new OSmonitorIUG();

    public static void main(String[] args) {

     OSmonitorIUG  osmonitor = new OSmonitorIUG();

       
        int n = 0, io = 0, procCycle = 0, ioCycle = 0, cycles = 0;
        
        int procCount = 0; String str = "";
        
        boolean go = false; boolean flag = false; boolean exit = false; boolean newFile = false;
        
        CPU1 cpu1 = new CPU1();
       
        Memory mem = new Memory();
              
        Timer procTime = new Timer();
        
        Timer ioTime = new Timer();
        
     //  cpu1.addProcess(17, "Process1");
     
//     Thread1 t1 = new Thread1();
//     
//    t1.run();
       
        
        System.out.println(cpu1.getThred());
        
        System.out.println(cpu1.getMax());

        
    /*process algorithm: 
    **system runs in loops, the loop will not exit until exit button is hit, boolean exit = false;
    **everytime a process is read, check memory size, if there's enough memory , load the process in memory, half in ram, half in virtual memory, 
     **state turn from new to ready
     **if there's enough cpu resource to run the process, process pass to thread to run, state turn into run
     **if there's interrupt, the rest of the process will pause and turn into wait state, interrupt will be loaded to memory, and the thread, execute and terminate
     ** the rest of the process resumes, run till no cpu time left, process terminate. or user choose to terminate it early
     **
    **
    */
        
        
        
   
    }
    
}
