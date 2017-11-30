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

	/*public String capturar(String datos)
	{
		if(primero == null)
		{
			primero = new NodoBanco(datos);
			ultimo = primero;
			ultimo.setNext(null);
		}
		else
		{
			actual = new NodoBanco(datos);
			ultimo.setNext(actual);   // ultimo.next = actual; // Enlace de nodos
			ultimo = actual;
			ultimo.setNext(null);
		}
		return "Cuenta Creada: "+datos;
	}*/

	public String captureSave(String data){

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
			data = "No Processes on the list";
		else{
			actual = first;
			while(actual != null){
				data = data + actual.toString() + "\n";
				actual = actual.getNext();
			}
		}
		return data;
	}

	/*public String consultProcess(String process)
	{
		String data="";
		boolean find = false;
		
		if(first == null)
			data = "VACIO";
		else
		{
			actual   = first;
			anterior = first;
			
			while(actual != null && !encontrado)
			{
				if(process.equals(process.getName()))
				{
					data = data + actual.toString() + "\n";
					find = true;
				}
				else
				{
					previous = actual;
					actual = actual.getNext();	
				}				
			}
			if(!find)
				data = "NOT_FIND";
		}		
		return data;
	}*/


}
