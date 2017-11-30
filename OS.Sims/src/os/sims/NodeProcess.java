package os.sims;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

import java.util.StringTokenizer;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NodeProcess{
	//Name of the process
	private String 	pName;
	//CPU time requires, or number of Cycles
	//This could aldo be permament of not
	private String 	pCPUtime;
	//Space necessary on the main memory
	private String 	pMainMemory;
	//Files that the process requires Cache-MainMemory-Disk-Total
	//private String 	pStorageFiles;
	//No idea
	//private String 	iodevices;
	//Process at which it belongs
	private String 	parentProcess;
	//State, NEW, READY, WAIT, RUN, EXIT
	private String  pState;

	//num of cycles it has gone thruo


	//private InputReader next;
	private NodeProcess next;

	public NodeProcess(){
		this.pName 			= "";
		this.pCPUtime 		= "";
		this.pMainMemory 	= "";
		//this.pStorageFiles 	= "";
		//this.iodevices	 	= "";
		this.parentProcess	= "";
		this.pState			= "";
	}

	public NodeProcess(String data){
		StringTokenizer st = new StringTokenizer(data,"_");

		this.pName 			= st.nextToken();
		this.pCPUtime	 	= st.nextToken();
		this.pMainMemory  	= st.nextToken();
		//this.pStorageFiles 	= st.nextToken();
		//this.iodevices		= st.nextToken();
		this.parentProcess 	= st.nextToken();
		this.pState 		= st.nextToken();
	}

	//Accesors
	public String getPName(){
		return this.pName;
	}
	public String getPCPUtime(){
		return this.pCPUtime;
	}
	public String getPMainMemory(){
		return this.pMainMemory;
	}
	/*public String getPStorageFiles(){
		return this.pStorageFiles;
	}
	public String getIODevices(){
		return this.iodevices;
	}*/
	public String getParentProcess(){
		return this.parentProcess;
	}
	public String getPState(){
		return this.pState;
	}
	public NodeProcess getNext(){
		return this.next;
	}

	//Mutators
	public void setPName(String strPName){
		this.pName = strPName;
	}
	public void setPCPUtime(String strPCPUtime){
		this.pCPUtime = strPCPUtime;
	}
	public void setPMainMemory(String strPMainMem){
		this.pMainMemory = strPMainMem;
	}
	/*public void setPStorageFiles(String strPStorage){
		this.pStorageFiles = strPStorage;
	}
	public void setIODevices(String strIODev){
		this.iodevices = strIODev;
	}*/
	public void setParentProcess(String strPP){
		this.parentProcess = strPP;
	}
	public void setPState(String strPState){
		this.pState = strPState;
	}
	public void setNext(NodeProcess node){
		this.next = node;
	}

	public String toString(){
		//return this.pName+"_"+this.pCPUtime+"_"+this.pMainMemory+"_"
		//	+this.pStorageFiles+"_"+this.iodevices+"_"+this.parentProcess+"_"+this.pState;

			return this.pName+"_"+this.pCPUtime+"_"+this.pMainMemory+"_"
			+this.parentProcess+"_"+this.pState;
	}
}
