package os.sims;

/*
**author Fofini Parry
*/

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import java.util.Random;
import javax.swing.JOptionPane;


public class OSmonitorIUG extends JFrame implements ActionListener
{

	private JPanel panel1, panel2, panel3;

	private JTextField tfName, tfCPUtime, tfMainMem, tfParent, tfState;

	private JButton bCreaP, bCreaIn, bTerminate, bExit;
	private JButton bNewTxt, bCreaRand, bConsult, bConsultByName;
	private JButton bReduceCPUtime, bConsByParentP, bShowMem, bReset;
	private JTextArea taData, taMonitor;

	private OSProcessAD processAD = new OSProcessAD();
	//private JTextArea 

	public OSmonitorIUG()
	{
		super("Project OS monitor");
		//1 Creating Objects


		//panelProcessTracker = new JPanel();
		panel1 		= new JPanel();
		panel2		= new JPanel();
		panel3 		= new JPanel();

		tfName 		= new JTextField();
		tfCPUtime	= new JTextField();
		tfMainMem	= new JTextField();
		tfParent	= new JTextField();
		tfState		= new JTextField();

		bCreaP 		= new JButton("Create Process");
		bCreaIn		= new JButton("Create Interrupt");
		bTerminate	= new JButton("Terminate");
		bCreaRand 	= new JButton("Create Random Processes");
		bExit		= new JButton("Exit Project");
		
		bConsult 	= new JButton("See all in MM");
		bConsultByName = new JButton("Search by Name");
		bConsByParentP = new JButton("Search by Parent");
		bReduceCPUtime = new JButton("Reduce CPUtime");
		bShowMem	= new JButton("Show Memory");
		bReset = new JButton("Reset");

		bCreaP.addActionListener(this);
		bCreaIn.addActionListener(this);
		bTerminate.addActionListener(this);
		bExit.addActionListener(this);
		bCreaRand.addActionListener(this);
		bConsult.addActionListener(this);
		bConsultByName.addActionListener(this);
		bConsByParentP.addActionListener(this);
		bReduceCPUtime.addActionListener(this);
		bShowMem.addActionListener(this);
		bReset.addActionListener(this);

		taData = new JTextArea(10,10);
		taMonitor = new JTextArea(32,50);


		//2 Adding them to the panel1 and panel2
		panel1.setLayout(new GridLayout(10,2));
		panel2.setLayout(new GridLayout(2,1));
		panel3.setLayout(new FlowLayout());

		//panelCreate

		panel1.add(new JLabel("Name :"));
		panel1.add(tfName);

		panel1.add(new JLabel("CPU time"));
		panel1.add(tfCPUtime);

		panel1.add(new JLabel("Main Memory"));
		panel1.add(tfMainMem);

		panel1.add(new JLabel("Parent Process"));
		panel1.add(tfParent);

		panel1.add(new JLabel("State"));
		panel1.add(tfState);

		panel1.add(bCreaP);
		panel1.add(bCreaIn);
		panel1.add(bConsult);
		panel1.add(bConsultByName);
		panel1.add(bConsByParentP);
		panel1.add(bTerminate);
		panel1.add(bCreaRand);
		//panel1.add(bReduceCPUtime);
		//panel1.add(bShowMem);
		panel1.add(bReset);
		panel1.add(bExit); 

		//panel3.add(panelProcessTracker);
		panel2.add(panel1);
		panel2.add(new JScrollPane(taData));

		panel3.add(panel2);
		panel3.add(new JScrollPane(taMonitor));

		taData.setText(processAD.obtainDataTxt());


		//3 Add panels to the JFrame  and make it visible

		add(panel3);
		setSize(1000,590);
		setVisible(true);

	}

	private void edit(String data){
		StringTokenizer st = new StringTokenizer(data, "_");

		tfName.setText(st.nextToken());
		tfCPUtime.setText(st.nextToken());
		tfMainMem.setText(st.nextToken());
		tfParent.setText(st.nextToken());
		tfState.setText(st.nextToken());
	}

	public String obtainData(boolean interrupt)
	{
		String data="";
			
		String pName     	= tfName.getText();
		String pCPUTime		= tfCPUtime.getText();
		String pMainMem   	= tfMainMem.getText();
		String pParent 		= tfParent.getText();
		String pState		= tfState.getText();

		if(pName.isEmpty() || pCPUTime.equals("") || pMainMem.equals("") || pParent.equals("")||pState.equals(""))
			data = "EMPTY_FIELD";
		else
		{
			try
			{
				int n = Integer.parseInt(pCPUTime);
				n = Integer.parseInt(pMainMem);
				if(interrupt == false)
					data = pName+"_"+pCPUTime+"_"+pMainMem+"_"+pParent+"_"+pState;
				else{
                                      if(Integer.parseInt(pCPUTime)< 25 ){ pCPUTime = "25";}// if cpu cycle is less than 25, convert to 25.
                                      else{if(Integer.parseInt(pCPUTime)>50){pCPUTime = "50";} // if cpu cycle is greater than 50, conver to 50
                                        
                                      } 
                                      
                                      if(Integer.parseInt(pMainMem)< 1 ){ pMainMem = "20";}// if io memory is less than 1, convert to 20 kb.
                                      else{if(Integer.parseInt(pMainMem)>200000){pMainMem = "200000";}// if io memory is greater than 200 mb, conver to 200
                                      } 
                                    
					data = pName+"_"+pCPUTime+"_"+pMainMem+"_"+"INTERRUPT"+"_"+pState;
				}
			}
			catch(NumberFormatException nfe)
			{
				data = "NO_NUMERIC";
			}
		}
		return data;
	}

	public int refreshMonitor(int numOfCycles){
		String data = "";
		//while(numOfCycles != 0){
		if(numOfCycles != 0){
			data = processAD.consult();
			data = "CYCLES: "+ numOfCycles + "\nMEMORY: "+ processAD.consultMem() +"\n"+data;
			taMonitor.setText(data);
			//HERE WE RUN THE CPU
			numOfCycles = numOfCycles - 1;
		}

		if(numOfCycles == 0){
			numOfCycles = Integer.parseInt(JOptionPane.showInputDialog("How many MORE cycles do yuo wish to have?"));
		}
		
		return numOfCycles;
	}

	public void actionPerformed(ActionEvent e)
	{
		String data = "";
		String answer = "";
		String namProcess = "";
	
		if(e.getSource() == bCreaP)
		{
			data = obtainData(false);
			
			if(data.equals("EMPTY_FIELD"))
				taData.setText("Some field is empty...");
			else
			{
				if(data.equals("NO_NUMERIC"))
					taData.setText("Main Memory and CPU time must be numeric..");
				else
				{
					namProcess = tfName.getText();
					answer = processAD.consultNameProcess(namProcess);
					
					if(answer.equals("EMPTY"))
						answer = processAD.capture(data);
					else{
						if(answer.equals("NOT_FIND"))
							answer = processAD.capture(data);
						else
							answer = "The process already exist : "+namProcess;
					}
					taData.setText(answer);
				}
			}
		}

		if(e.getSource() == bCreaIn){
			data = obtainData(true);
			
			if(data.equals("EMPTY"))
				taData.setText("Some field is empty...");
			else
			{
				if(data.equals("NO_NUMERIC"))
					taData.setText("Main Memory and CPU time must be numeric..");
				else
				{
					namProcess = tfName.getText();
					answer = processAD.consultNameProcess(namProcess);
					
					if(answer.equals("EMPTY"))
						answer = processAD.capture(data);
					else{
						if(answer.equals("NOT_FIND"))
							answer = processAD.capture(data);
						else
							answer = "The process already exist : "+namProcess;
					}
					taData.setText(answer);
				}
			}

		}

		if(e.getSource() == bConsult)
		{
			data = processAD.consult();
			taData.setText(data);
		}

		if(e.getSource() == bConsultByName)
		{
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if(data.equals("EMPTY"))
				data = "There are no processes in MM";
			else
				if(data.equals("NOT_FIND"))
					data = "NO process with that name is found: " +namProcess;
				else
					edit(data);
			taData.setText(data);
		}

		if(e.getSource() == bConsByParentP)
		{
			data = tfParent.getText();
			data = processAD.consultParentProcess(data);
			taData.setText(data);
		}

		if(e.getSource() == bReduceCPUtime)
		{
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if(data.equals("EMPTY"))
				data = "No Process on MM";
			else
				if(data.equals("NOT_FIND"))
					data = "The process was not localizated";
				else
				{
					data = processAD.reduceCPUtime(0);
				}
			taData.setText(data);
		}

		if(e.getSource() == bTerminate)
		{
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if(data.equals("EMPTY"))
				data = "The Main Memory is empty";
			else
				if(data.equals("NOT_FIND"))
					data = "THe process was not found" + namProcess;
				else
					data = processAD.terminateProcess();
			taData.setText(data); 
		}

		if(e.getSource() == bCreaRand)
		{
			Random rand = new Random();
			//int randNum = rand.nextInt(10) + 1;
			int randpName;
			int randpCPUtime;
			int randpMainMem;
			int randpParent;
			int randpState;
			//String data = "";
			
			int randNum;
			//String data = "";
			int num  = Integer.parseInt(JOptionPane.showInputDialog("Quantity of Random Process: "));
			for (int i=0; i < num; i++){

				randNum = rand.nextInt(10) + 1;
				randpName = randNum;
				
				randNum = rand.nextInt(10) + 1;
				randpCPUtime = randNum;
				
				randNum = rand.nextInt(10) + 1;
				randpMainMem = randNum;
				
				randNum = rand.nextInt(10) + 1;
				randpParent = randNum;

				//randNum = rand.nextInt(4) + 1;
				//randpState = randNum;
				
				data = "process" +randpName + "_" + randpCPUtime + "_" + randpMainMem + "_parent" + randpParent + "_" + "NEW";
				answer = processAD.capture(data);

				if(answer.equals("NO_SPACE")){
					i = num;
					taData.setText("NO SPACE, MEMORY FULL!");
				}
			}
			//taData.setText("Random Process created!");	
			
		}
		if(e.getSource() == bShowMem){
			answer = processAD.consultMem();
			taData.setText(answer);
		}

		if(e.getSource() == bReset){
			data = processAD.resetLinkedList();
			taData.setText(data);
		}

		if(e.getSource() == bExit)
		{
			System.exit(0);
		}
	}



	public static void main(String args[]){
		OSmonitorIUG  osmonitor = new OSmonitorIUG();
	}

}
