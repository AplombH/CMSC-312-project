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
import java.util.StringTokenizer;
import java.util.Random;

public class OSmonitorIUG extends JFrame implements ActionListener {

	private JPanel panelProcessTracker, panelCreate, panel3;

	private JTextField tfName, tfCPUtime, tfMainMem, tfParent;
	private JTextField tfState;

	private JButton bCreateP, bCreateIn, bTerminate, bExit;
	private JButton bNewTxt, bCreateRandom, bConsult, bConsultByName;
	private JButton bReduceCPUtime, bConsByParentP;
	private JTextArea taData;

	private OSProcessAD processAD = new OSProcessAD();
	// private JTextArea

	public OSmonitorIUG() {
		super("Project OS monitor");
		// 1 Creating Objects

		panelProcessTracker = new JPanel();
		panelCreate = new JPanel();
		panel3 = new JPanel();

		tfName = new JTextField();
		tfCPUtime = new JTextField();
		tfMainMem = new JTextField();
		tfParent = new JTextField();
		tfState = new JTextField();

		bCreateP = new JButton("Create Process");
		bCreateIn = new JButton("Create Interrupt");
		bTerminate = new JButton("Terminate");
		bExit = new JButton("Exit Project");
		bNewTxt = new JButton("Upload new txt");
		bCreateRandom = new JButton("Create Random Processes");

		bConsult = new JButton("See all in MM");
		bConsultByName = new JButton("Search by Name");
		bConsByParentP = new JButton("Search by Parent");
		bReduceCPUtime = new JButton("Reduce CPUtime");

		bCreateP.addActionListener(this);
		bCreateIn.addActionListener(this);
		bTerminate.addActionListener(this);
		bExit.addActionListener(this);
		bNewTxt.addActionListener(this);
		bCreateRandom.addActionListener(this);

		bConsult.addActionListener(this);
		bConsultByName.addActionListener(this);
		bConsByParentP.addActionListener(this);
		bReduceCPUtime.addActionListener(this);

		taData = new JTextArea(10, 10);

		// 2 Adding them to the panel1 and panel2
		panelProcessTracker.setLayout(new GridLayout(7, 7));
		panelCreate.setLayout(new GridLayout(10, 2));
		panel3.setLayout(new FlowLayout());

		// panelProcessTracker
		panelProcessTracker.add(new JLabel(":)"));
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

		// panelCreate

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
		panelCreate.add(bCreateRandom);
		panelCreate.add(bExit);

		panelCreate.add(bConsult);
		panelCreate.add(bConsultByName);
		panelCreate.add(bConsByParentP);
		panelCreate.add(bReduceCPUtime);

		// panel3.add(panelProcessTracker);
		panel3.add(panelCreate);

		panel3.add(new JScrollPane(taData));

		taData.setText(processAD.obtainDataTxt());

		// 3 Add panels to the JFrame and make it visible

		add(panel3);
		setSize(1100, 350);
		setVisible(true);

	}

	private void edit(String data) {
		StringTokenizer st = new StringTokenizer(data, "_");

		tfName.setText(st.nextToken());
		tfCPUtime.setText(st.nextToken());
		tfMainMem.setText(st.nextToken());
		tfParent.setText(st.nextToken());
		tfState.setText(st.nextToken());
	}

	public String obtainData(boolean interrupt) {
		String data = "";

		String pName = tfName.getText();
		String pCPUTime = tfCPUtime.getText();
		String pMainMem = tfMainMem.getText();
		String pParent = tfParent.getText();
		String pState = tfState.getText();

		if (pName.isEmpty() || pCPUTime.equals("") || pMainMem.equals("") || pParent.equals("") || pState.equals(""))
			data = "EMPTY_FIELD";
		else {
			try {
				int n = Integer.parseInt(pCPUTime);
				n = Integer.parseInt(pMainMem);
				if (interrupt == false)
					data = pName + "_" + pCPUTime + "_" + pMainMem + "_" + pParent + "_" + pState;
				else {
					data = pName + "_" + pCPUTime + "_" + pMainMem + "_" + "INTERRUPT" + "_" + pState;
				}
			} catch (NumberFormatException nfe) {
				data = "NO_NUMERIC";
			}
		}
		return data;
	}

	public void actionPerformed(ActionEvent e) {
		String data = "";
		String answer = "";
		String namProcess = "";

		if (e.getSource() == bCreateP) {
			data = obtainData(false);

			if (data.equals("EMPTY_FIELD"))
				taData.setText("Some field is empty...");
			else {
				if (data.equals("NO_NUMERIC"))
					taData.setText("Main Memory and CPU time must be numeric..");
				else {
					namProcess = tfName.getText();
					answer = processAD.consultNameProcess(namProcess);

					if (answer.equals("EMPTY"))
						answer = processAD.capture(data);
					else {
						if (answer.equals("NOT_FIND"))
							answer = processAD.capture(data);
						else
							answer = "The process already exist : " + namProcess;
					}
					taData.setText(answer);
				}
			}
		}

		if (e.getSource() == bCreateIn) {
			data = obtainData(true);

			if (data.equals("EMPTY"))
				taData.setText("Some field is empty...");
			else {
				if (data.equals("NO_NUMERIC"))
					taData.setText("Main Memory and CPU time must be numeric..");
				else {
					namProcess = tfName.getText();
					answer = processAD.consultNameProcess(namProcess);

					if (answer.equals("EMPTY"))
						answer = processAD.capture(data);
					else {
						if (answer.equals("NOT_FIND"))
							answer = processAD.capture(data);
						else
							answer = "The process already exist : " + namProcess;
					}
					taData.setText(answer);
				}
			}

		}

		if (e.getSource() == bConsult) {
			data = processAD.consult();
			taData.setText(data);
		}

		if (e.getSource() == bConsultByName) {
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if (data.equals("EMPTY"))
				data = "There are no processes in MM";
			else if (data.equals("NOT_FIND"))
				data = "NO process with that name is found: " + namProcess;
			else
				edit(data);
			taData.setText(data);
		}

		if (e.getSource() == bConsByParentP) {
			data = tfParent.getText();
			data = processAD.consultParentProcess(data);
			taData.setText(data);
		}

		if (e.getSource() == bReduceCPUtime) {
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if (data.equals("EMPTY"))
				data = "No Process on MM";
			else if (data.equals("NOT_FIND"))
				data = "The process was not localizated";
			else {
				data = processAD.reduceCPUtime(0);
			}
			taData.setText(data);
		}

		if (e.getSource() == bTerminate) {
			namProcess = tfName.getText();
			data = processAD.consultNameProcess(namProcess);

			if (data.equals("EMPTY"))
				data = "The Main Memory is empty";
			else if (data.equals("NOT_FIND"))
				data = "THe process was not found" + namProcess;
			else
				data = processAD.terminateProcess();
			taData.setText(data);
		}

		if (e.getSource() == bCreateRandom) {
			Random rand = new Random();
			//int randNum = rand.nextInt(10) + 1;
			int randpName;
			int randpCPUtime;
			int randpMainMem;
			int randpParent;
			int randpState;
			//String data = "";
			
			int randNum = rand.nextInt(10) + 1;
			randpName = randNum;
			
			randNum = rand.nextInt(10) + 1;
			randpCPUtime = randNum;
			
			randNum = rand.nextInt(10) + 1;
			randpMainMem = randNum;
			
			randNum = rand.nextInt(10) + 1;
			randpParent = randNum;

			randNum = rand.nextInt(4) + 1;
			randpState = randNum;
			
			data = "process" +randpName + "_" + randpCPUtime + "_" + randpMainMem + "_parent" + randpParent + "_" + randpState;
			processAD.capture(data);
		}

		if (e.getSource() == bExit) {
			// answer = processAD.save();
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		OSmonitorIUG osmonitor = new OSmonitorIUG();
	}


}
