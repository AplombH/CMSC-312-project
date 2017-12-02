/**
 * @author Aaron Kim, Aplomb Huang, Fofini Parry
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
import javax.swing.JOptionPane;

 /*process algorithm: 
 **system runs in loops, the loop will not exit until exit button is hit, boolean exit = false;
 **everytime a process is read, check memory size, if there's enough memory , load the process in memory, half in ram, half in virtual memory, 
 **state turn from new to ready
 **if there's enough cpu resource to run the process, process pass to thread to run, state turn into run
 **if there's interrupt, the rest of the process will pause and turn into wait state, interrupt will be loaded to memory, and the thread, execute and terminate
 **the rest of the process resumes, run till no cpu time left, process terminate. or user choose to terminate it early
 */

public class OSSims extends TimerTask{

  private OSmonitorIUG  monIUG = new OSmonitorIUG();
  int numOfCycles = Integer.parseInt(JOptionPane.showInputDialog("How many cycles do you wish to run?"));

  @Override
  public void run(){
  	numOfCycles = monIUG.refreshMonitor(numOfCycles); 
  }

    public static void main(String[] args) {

    //OSmonitorIUG  osmonitor = new OSmonitorIUG();
    OSSims ossims = new OSSims();

     Timer timer = new Timer(true);

     timer.scheduleAtFixedRate(ossims, 0, 4*1000);
    }
    
}
