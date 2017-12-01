package os.sims;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class OSProcessAD{
	private BufferedReader archiveEnter;
	private PrintWriter archiveExit;

	private NodeProcess first, last, actual;
	private NodeProcess previous;

	public String capture(String data){

		if(first == null){
			first = new NodeProcess(data);
			last = first;
			last.setNext(null);
		}
		else{
			actual = new NodeProcess(data);
			last.setNext(actual);
			last = actual;
			last.setNext(null);
		}
		return "Process Created: " + data;
	}

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

		reduce = Integer.parseInt(JOptionPane.showInputDialog("Give the quantity: "));
		currentValue = Integer.parseInt(actual.getPCPUtime());

		actual.setPCPUtime(Integer.toString(currentValue - reduce));

		data = "The CPU time was reduced";

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
}
