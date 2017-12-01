
package os.sims;

/**
 *
 * @author Aaron
 */
public class CPU extends Thread {
	// private int i;
	// private String[] Core1Thred1;
	int counter1;
	String str;

	private NodeProcess run1 = new NodeProcess();
	private NodeProcess run2 = new NodeProcess();
	private NodeProcess run3 = new NodeProcess();
	private NodeProcess run4 = new NodeProcess();

	public CPU() {	} // defult constructor

	public CPU( String str, int counter1) {
		// this.Core1Thred1 = Core1Thred1;
		this.counter1 = counter1;
		this.str = str;
	}

	public void add(NodeProcess node1) {
		if (run1 != null)
			setRun1(node1);
		else if (run2 != null)
			setRun2(node1);
		else if (run3 != null)
			setRun3(node1);
		else if (run4 != null)
			setRun4(node1);
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

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// for (i = 0; i <30; i++){if (Core1Thred1[i].equals("null")){Core1Thred1[i] =
		// str; counter1--;break;}}

	}

	// my first thread
	Thread t1 = new Thread() {

		public void run() {

			for (int i = 1; i <= 10; i++) {
				System.out.println("Thread 1: " + i);
			}
		}
	};

	// my second thread
	Thread t2 = new Thread() {

		public void run() {

			for (int i = 1; i <= 10; i++) {
				System.out.println("Thread 2: " + i);
			}
		}
	};

	// Third Thread
	Thread t3 = new Thread() {

		public void run() {
			
			int cpuTime1 = run1.getPCPUtimeInt();
			System.out.println("CPU TIME LEFT: " + cpuTime1);
			while (cpuTime1 > 0) {
				cpuTime1--;
				run1.setPCPUtime(cpuTime1);
				System.out.println("CPU TIME LEFT: " + cpuTime1);
			}

		}
	};

	// Fourth Thread
	Thread t4 = new Thread() {

		public void run() {

			// Work here

		}

	};

	public String working() {
		return ("IT WORKS");
	}

}
