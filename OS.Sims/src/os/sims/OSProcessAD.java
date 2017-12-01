package os.sims;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

import java.util.StringTokenizer;

/*
**@author Fofini
*/

public class OSProcessAD{
	private BufferedReader archiveEnter;
	private PrintWriter archiveExit;
    private CPU cpu1 = new CPU();
	private NodeProcess first, last, actual;
	private NodeProcess previous;
	private Memory memory = new Memory();
	private int mem, memOfPro;
	private String str;
	private StringTokenizer st;

	public String capture2(String data){

		if(first == null){
				first = new NodeProcess(data);
				last = first;
				last.setNext(null);

				mem  = Integer.parseInt(first.getPMainMemory());
				memory.add2Mem(mem*1000);
			}
			else{
				actual = new NodeProcess(data);
				last.setNext(actual);
				last = actual;
				last.setNext(null);

				mem  = Integer.parseInt(actual.getPMainMemory());
				memory.add2Mem(mem*1000);
			}

		str = Integer.toString(memory.mCounter());
		return "Process Created: " + data + "\nthe ram is:" + str;
	}

	public String capture(String data){
		st = new StringTokenizer(data,"_");
		//this is name
		str = st.nextToken();
		//this is CPU time
		str = st.nextToken();
		//this is Main memory
		str = st.nextToken();

		memOfPro = Integer.parseInt(str);
<<<<<<< HEAD
		mem = memory.mCounter() - 200000;
                
=======
		mem = memory.getRam() - 200000;
>>>>>>> 08fae7f7cf361001e33b74f92323d6170a68830b

		//this is Parent Process, it can be INTERRUPT
		str  = st.nextToken();

		if(str.equals("INTERRUPT")){
			data = capture2(data);
		}
		else{
			if(mem >= memOfPro && memory.getRam() > 200000){
				data = capture2(data);
			}
			else{
				data = "NO_SPACE";
			}
		}
		
		return data;
	}
//This is a test
	public String saveOnTextFile(){

		String response = "";
		String data = "";
		try{
			if(first == null)
				response = "There are no Processes";
			else{
				archiveExit = new PrintWriter("Processes.txt");
				actual = first;
				while(actual != null){
					archiveExit.println(actual.toString());
					actual = actual.getNext();
					response = "The Processes we saved correctly on the .txt";
				}
				archiveExit.close();
			}
		}
		catch(IOException ioe){
			response = "Error, IOException\n" + ioe;
		}
		return response;
	}

	public String consult(){
		String data = "";

		if(first == null)
			data = "No Processes on the Main Memory";
		else{
			actual = first;
			while(actual != null){
				data = data + actual.toString() + "\n";
				actual = actual.getNext();
			}
		}
		return data;
	}

	public String reduceCPUtime(int reduce){
		String data = "";
		int currentValue;

		actual.setNumCycles(1);

		reduce = Integer.parseInt(JOptionPane.showInputDialog("Give the quantity: "));
		currentValue = Integer.parseInt(actual.getPCPUtime());

		currentValue = currentValue - reduce;

		if(currentValue <= 0)
			data = terminateProcess();
		else
			actual.setPCPUtime(Integer.toString(currentValue - reduce));

		data = data +"\nThe CPU time was reduced";

		return data;
	}

	public String consultNameProcess(String process)
	{
		String data="";
		boolean find = false;
		
		if(first == null)
			data = "EMPTY";
		else
		{
			actual   = first;
			previous = first;
			
			while(actual != null && !find)
			{
				if(process.equals(actual.getPName()))
				{
					data = actual.toString();
					find = true;
				}
				else{
					previous = actual;
					actual = actual.getNext();	
				}				
			}
			if(!find)
				data = "NOT_FIND";
		}		
		return data;
	}

	public String consultParentProcess(String parent)
	{
		String data = "";
		boolean find = false;

		if(first == null)
			data = "No process in Main Memory";
		else
		{
			actual = first;

			while(actual != null)
			{
				if(parent.equals(actual.getParentProcess()))
				{
					data = data + actual.toString() + "\n";
					find = true;
				}
				actual = actual.getNext();
			}

			if(!find)
				data = "None with that Parent: " + parent;
		}
		return data;
	}

	public String obtainDataTxt(){
		String response = "";
		String data = "";

		try{
			archiveEnter = new BufferedReader(new FileReader("Processes.txt"));

			try{
				while((data = archiveEnter.readLine()) != null)
				{
					response = capture(data);
					if(response.equals("NO_SPACE"))
						return response;
				}
				response = "Data read correctly from the txt";
			}
			catch(IOException ioe){
				response = "Error: " + ioe;
			}
		}
		catch(FileNotFoundException fe){
			response = "Error: FileNotFoundException\n" +fe;
		}
		return response;
	}

	public String terminateProcess(){

		memory.del4Mem(Integer.parseInt(actual.getPMainMemory())*1000);
		
		if(first == actual)
			first = first.getNext();
		else
		{
			if(last == actual)
			{
				last = previous;
				last.setNext(null);
			}
			else
				previous.setNext(actual.getNext());
		}
		return "Process Terminated";

	}
        
        public String add2CPU()
        {String state = "Ready";
         //CPU cpu1 = new CPU(NodeProcess.cputime);
          state = "Run";
            return state;
        }
}
