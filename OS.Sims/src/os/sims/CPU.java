
//package os.sims;

/**
 *
 * @author Aplomb
 */
public class CPU extends Thread {
	// private int i;
	// private String[] Core1Thred1;
	int counter1;
	String str;

	private NodeProcess run1 = null;
	private NodeProcess run2 = null;
	private NodeProcess run3 = null;
	private NodeProcess run4 = null;

	int counter = 200;

	public CPU() {

	}

	public CPU(String[] Core1Thred1, String str, int counter1) {
		// this.Core1Thred1 = Core1Thred1;
		this.counter1 = counter1;
		this.str = str;
	}

	public void add(NodeProcess node1) {
		if (run1 == null)
			setRun1(node1);
		else if (run2 == null)
			setRun2(node1);
		else if (run3 == null)
			setRun3(node1);
		else if (run4 == null)
			setRun4(node1);
	}

	public boolean isFull() {
		if ((run1 == null) || (run2 == null) || (run3 == null) || (run4 == null))
			return false;
		else
			return true;
	}

	public void setCounter(int count) {
		this.counter = count;
	}

	/**
	 * @return the run1
	 */
	public NodeProcess getRun1() {
		return run1;
	}

	/**
	 * @param run1
	 *            the run1 to set
	 */
	public void setRun1(NodeProcess run1) {
		this.run1 = run1;
	}

	/**
	 * @return the run2
	 */
	public NodeProcess getRun2() {
		return run2;
	}

	/**
	 * @param run2
	 *            the run2 to set
	 */
	public void setRun2(NodeProcess run2) {
		this.run2 = run2;
	}

	/**
	 * @return the run3
	 */
	public NodeProcess getRun3() {
		return run3;
	}

	/**
	 * @param run3
	 *            the run3 to set
	 */
	public void setRun3(NodeProcess run3) {
		this.run3 = run3;
	}

	/**
	 * @return the run4
	 */
	public NodeProcess getRun4() {
		return run4;
	}

	/**
	 * @param run4
	 *            the run4 to set
	 */
	public void setRun4(NodeProcess run4) {
		this.run4 = run4;
	}

	public void run() {

		// int i = 0;
		// while (i < counter) {
		// System.out.println("BEFORE TEST: " + run1.toString());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// i++;
		// }
	}

	// my first thread
	Thread t1 = new Thread() {

		public void run() {

			if (run1 != null) {
				// System.out.println("PAST IF LOOP");
				int cpuTime1 = run1.getPCPUtimeInt();
				// System.out.println("CPU TIME LEFT: " + cpuTime1);
				cpuTime1--;
				run1.setPCPUtimeInt(cpuTime1);
				System.out.println("CPU TIME LEFT: " + cpuTime1);
				System.out.println("AFTER TEST: " + run1.toString());
				if (run1.getPCPUtimeInt() == 0) {
					run1.setPState("EXIT");
					run1 = null;
					System.out.println("AFTER TEST: " + run1.toString());
				}
			}
			System.out.println("END OF THREAD 1");
		}
	};

	// my second thread
	Thread t2 = new Thread() {

		public void run() {

			if (run2 != null) {
				// System.out.println("PAST IF LOOP");
				int cpuTime2 = run2.getPCPUtimeInt();
				// System.out.println("CPU TIME LEFT: " + cpuTime1);
				cpuTime2--;
				run2.setPCPUtimeInt(cpuTime2);
				//System.out.println("CPU TIME LEFT: " + cpuTime2);
				//System.out.println("AFTER TEST: " + run2.toString());
				if (run2.getPCPUtimeInt() == 0) {
					run2.setPState("EXIT");
					run2 = null;
					//System.out.println("AFTER TEST: " + run2.toString());
				}
			}
			//System.out.println("END OF THREAD 2");
		}
	};

	// Third Thread
	Thread t3 = new Thread() {

		public void run() {
			//System.out.println("START OF THREAD 3");
			if (run3 != null) {
				// System.out.println("PAST IF LOOP");
				int cpuTime3 = run3.getPCPUtimeInt();
				// System.out.println("CPU TIME LEFT: " + cpuTime1);
				cpuTime3--;
				run3.setPCPUtimeInt(cpuTime3);
				//System.out.println("CPU TIME LEFT: " + cpuTime3);
				//System.out.println("AFTER TEST: " + run3.toString());
				if (run3.getPCPUtimeInt() == 0) {
					run3.setPState("EXIT");
					run3 = null;
					//System.out.println("AFTER TEST: " + run3.toString());
				}
			}
			//System.out.println("END OF THREAD 3");
		}
	};

	// Fourth Thread
	Thread t4 = new Thread() {

		public void run() {

			if (run4 != null) {
				// System.out.println("PAST IF LOOP");
				int cpuTime4 = run4.getPCPUtimeInt();
				// System.out.println("CPU TIME LEFT: " + cpuTime1);
				cpuTime4--;
				run4.setPCPUtimeInt(cpuTime4);
				//System.out.println("CPU TIME LEFT: " + cpuTime4);
				//System.out.println("AFTER TEST: " + run4.toString());
				if (run4.getPCPUtimeInt() == 0) {
					run4.setPState("EXIT");
					run4 = null;
					//System.out.println("AFTER TEST: " + run4.toString());
				}
			}
			//System.out.println("END OF THREAD 4");

		}

	};

	public String working() {
		return ("IT WORKS");
	}

}
