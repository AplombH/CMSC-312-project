package os.sims;

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

public class OSmonitorIUG extends JFrame implements ActionListener
{

	private JPanel panelProcessTracker, panelCreate, panel3;

	private JTextField tfName, tfCPUtime, tfMainMem, tfParent;
	private JTextField tfState;

	private JButton bCreateP, bCreateIn, bTerminate, bExit;
	private JButton bNewTxt;
	private JTextArea taData;

	private OSProcessAD processAD = new OSProcessAD();
	//private JTextArea 

	public OSmonitorIUG()
	{
		super("Project OS monitor");
		//1 Creating Objects


		panelProcessTracker = new JPanel();
		panelCreate 		= new JPanel();
		panel3 				= new JPanel();

		tfName 		= new JTextField();
		tfCPUtime	= new JTextField();
		tfMainMem	= new JTextField();
		tfParent	= new JTextField();
		tfState		= new JTextField();

		bCreateP 	= new JButton("Create Process");
		bCreateIn	= new JButton("Create Interrupt");
		bTerminate	= new JButton("Terminate");
		bExit		= new JButton("Exit Project");
		bNewTxt		= new JButton("Upload new txt");

		bCreateP.addActionListener(this);
		bCreateIn.addActionListener(this);
		bTerminate.addActionListener(this);
		bExit.addActionListener(this);
		bNewTxt.addActionListener(this);

		taData = new JTextArea(10,10);


		//2 Adding them to the panel1 and panel2
		panelProcessTracker.setLayout(new GridLayout(7,7));
		panelCreate.setLayout(new GridLayout(8,2));
		panel3.setLayout(new FlowLayout());


		//panelProcessTracker
		panelProcessTracker.add(new JLabel("Attributes/Process"));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("Name: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("CPU: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("Main Memory: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("Parent Process: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("State: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		panelProcessTracker.add(new JLabel("Cycles Runned: "));
		panelProcessTracker.add(new JLabel("P 1"));
		panelProcessTracker.add(new JLabel("P 2"));
		panelProcessTracker.add(new JLabel("P 3"));
		panelProcessTracker.add(new JLabel("P 4"));
		panelProcessTracker.add(new JLabel("P 5"));
		panelProcessTracker.add(new JLabel("P 6"));

		//panelCreate

		panelCreate.add(new JLabel("Name :"));
		panelCreate.add(tfName);

		panelCreate.add(new JLabel("CPU time"));
		panelCreate.add(tfCPUtime);

		panelCreate.add(new JLabel("Main Memory"));
		panelCreate.add(tfMainMem);

		panelCreate.add(new JLabel("Parent Process"));
		panelCreate.add(tfParent);

		panelCreate.add(new JLabel("State"));
		panelCreate.add(tfState);

		panelCreate.add(bCreateP);
		panelCreate.add(bCreateIn);
		panelCreate.add(bTerminate);
		panelCreate.add(bNewTxt);
		panelCreate.add(bExit);

		panel3.add(panelProcessTracker);
		panel3.add(panelCreate);

		panel3.add(new JScrollPane(taData));

		//taData.setText(processAD.obtenerDatosTxt());


		//3 Add panels to the JFrame  and make it visible

		add(panel3);
		setSize(900,400);
		setVisible(true);

	}

	/*private String obtainData()
	{
			String data="";
			
			String pName     	= tfName.getText();
			String pCPUTime		= tfCPUtime.getText();
			String pMainMem   	= tfMainMem.getText();
			String pParent 		= tfParent.getText();
			String pState		= tfState.getText();

			if(pName.isEmpty() || pCPUTime.equals("") || pMainMem.equals("") || pParent.equals("")||pState.equals(""))
				data = "EMPTY";
			else
			{
				try
				{
					int n = Integer.parseInt(pCPUTime);
					n = Integer.parseInt(pMainMem);
					data = pName+"_"+pCPUTime+"_"+pMainMem+"_"+pParent+"_"+pState;
				}
				catch(NumberFormatException nfe)
				{
					data = "NO_NUMERIC";
				}
			}
			return data;
		}*/

	public void actionPerformed(ActionEvent e)
	{
		String data = "";
		String answer = "";
		String namProcess = "";
	
		/*if(e.getSource() == bCapturar)
		{
			data = obtainData();
			
			if(data.equals("EMPTY"))
				taData.setText("Some field is empty...");
			else
			{
				if(datos.equals("NO_NUMERIC"))
					taData.setText("Main Memory and CPU time must be numeric..");
				else
				{
					namProcess = tfName.getText();
					answer = bancoad.consultProcess(namProcess);
					
					if(answer.equals("VACIO"))
						answer = processAD.captureSave(data);
					else{
						if(answer.equals("NOT_FIND"))
							answer = processAD.captureSave(data);
						else
							answer = "The process already exist : "+namProcess;
					}
					taData.setText(answer);
				}
			}
		}*/

		if(e.getSource() == bExit)
		{
			//answer = processAD.save();
			System.exit(0);
		}
	}

	public static void main(String args[]){
		OSmonitorIUG  osmonitor = new OSmonitorIUG();
	}

}
