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


public class OSSims {

    public static void main(String[] args) {
        
       // OSmonitorIUG  osmonitor = new OSmonitorIUG();
        
        int n = 0, io = 0, procCycle = 0, ioCycle = 0, cycles = 0;
        
        int procCount = 0; String str = "";
        
        boolean go = false; boolean flag = false; boolean exit = false; boolean newFile = false;
        
        CPU1 cpu1 = new CPU1();
       
        Memory mem = new Memory();
              
        Timer procTime = new Timer();
        
        Timer ioTime = new Timer();
        
       cpu1.addProcess(17, "Process1");
       
        
        System.out.println(cpu1.getThred());
        
        System.out.println(cpu1.getMax());
        
        
   //     do{
            
            
            
        //check system condition before new process is input to the system
        
        //main program will run in loops until the exit signal is sent to it.
        
    //    if(mem.getRam()>200000){flag = true;}
        
    //    if (cpu1.getThred() > 8){go = true;}
        
        // this is the input of process cycles, or io cycles
        
        
//        if (flag && go)
//        { 
//            if(procCycle <= cpu1.getThred())
//            { n = procCycle;          
//            }
//            else{n = cpu1.getThred();
//           
//            }
//            cpu1.addProcess(n,"P1");
//             procCycle  = procCycle - n;
//                
//            procCount ++;
        
      //  if (cpu1.getThred()<= 8) {cpu1.fillNull();procTime.updateTimer(procCount);}
         //else repeat process
       // }
         
        //memory and cpu resouurce has already reserved to handle io aka interuupts. so there's no need to check condition to run io.
//        ioCycle = cycles;
//        
//        if(ioCycle >0){ 
//        
//         if(ioCycle <= cpu1.getThred()){io = ioCycle;}
//         else{io = cpu1.getThred(); ioCycle = ioCycle - io;}
//         cpu1.io2Process(io, "io1");
//         
//         cpu1.io4Process(io, "io1"); ioTime.updateTimer(1);
//         
//         
//         }
        
       // if(newFile){textReader(str);}//if in the UI, user select read new file, then the method will run.
        
       // }while(exit);
    }
    
    //Randomizer, from GUI add number of Cycles, which makes and adds proccesses according to number of cycles.
//    public static void randomizer(int randomCycle){
//    	Random rand = new Random();
//    	int i =0;
//    	int  randNum = rand.nextInt(10) + 1;
//		String randpName; 
//		String randpCPUtime; 	
//		String randpMainMemory; 
//		String randparentProcess;
//		String randpState;
//    	while (i < randomCycle) {
//    		randpName = (String) randNum;
//    		randNum = rand.nextInt(10) + 1;
//    		
//    		randpCPUtime = (String) randNum;	
//    		randNum = rand.nextInt(10) + 1;
//    		
//    		randpMainMemory = (String) randNum;
//    		randNum = rand.nextInt(10) + 1;
//    		
//    		//randparentProcess
//    		
//    		randpState = (String) randNum;
//    		randNum = rand.nextInt(10) + 1;
//    		
//    		//What ever calls the object....Seems to cannot find it....
//    		
//    		i++;;
//    		System.out.println ("Number of Cycles " + i);
//    	}  	
//        
//    } 
    
    
 //   public static void textReader(String str)
//    {
//         String fileName = str + ".txt"; // The name of the file to open.
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = 
//                new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = 
//                new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//               // here is the operation of where we store the information in the line
//            }   
//
//            // Always close files.
//            bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                "Unable to open file '" + 
//                fileName + "'");                
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error reading file '" 
//                + fileName + "'");                  
//            // Or we could just do this: 
//            // ex.printStackTrace();
//        }
//    }
//    
}
