
//package os.sims;

/**
 *
 * @author Aplomb
 */
public class CPU extends Thread {

	private NodeProcess run1 = null;
	private NodeProcess run2 = null;
	private NodeProcess run3 = null;
	private NodeProcess run4 = null;
	private NodeProcess interrupt = null;

	private boolean critOpen = true;
	private boolean open1 = false;
	private boolean open2 = false;
	private boolean open3 = false;
	private boolean open4 = false;

	int counter = 200;

	public CPU() {

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

	public void addInterrupt(NodeProcess nodeI) {
		if (interrupt == null)
			interrupt = nodeI;
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

	/**
	 * @return the interrupt
	 */
	public NodeProcess getInterrupt() {
		return interrupt;
	}

	/**
	 * @param interrupt
	 *            the interrupt to set
	 */
	public void setInterrupt(NodeProcess interrupt) {
		this.interrupt = interrupt;
	}

	public void run() {

		// System.out.println("BEFORE TEST: " + run1.toString());
		if (interrupt == null) {
			t1.run();
			t2.run();
			t3.run();
			t4.run();
		}

		// Pretend this is thread1
		else {
			int cpuTimeI = interrupt.getPCPUtimeInt();
			cpuTimeI--;
			interrupt.setPCPUtimeInt(cpuTimeI);
			//System.out.println("CPU TIME LEFT: " + cpuTimeI);
			//System.out.println("AFTER TEST INTERRUPT: " + interrupt.toString());
			if (interrupt.getPCPUtimeInt() == 0) {
				interrupt.setPState("EXIT");
				interrupt = null;
			}
		}
	}

	// my first thread
	Thread t1 = new Thread() {

		public void run() {

			if (run1 != null) {
				//if (!run1.getCritStart())
					//System.out.println("CRIT START IS FALSE");
				if (run1.getCritStart() && critOpen) {
					critOpen = false;
					open1 = true;
				}
				if (run1.getCritStart() && open1) {
					int cpuTime1 = run1.getPCPUtimeInt();
					cpuTime1--;
					run1.setPCPUtimeInt(cpuTime1);
					//System.out.println("CPU TIME LEFT: " + cpuTime1);
					//System.out.println("AFTER TEST: " + run1.toString());
					if (!(run1.getCritStart())) {
						critOpen = true;
						//System.out.println("THE GATE IS NOW OPEN1");
						open1 = false;
					}
					if (run1.getPCPUtimeInt() == 0) {
						run1.setPState("EXIT");
						run1 = null;
					}
				} else if (!(run1.getCritStart())) {
					int cpuTime1 = run1.getPCPUtimeInt();
					cpuTime1--;
					run1.setPCPUtimeInt(cpuTime1);
					//System.out.println("CPU TIME LEFT: " + cpuTime1);
					//System.out.println("AFTER TEST: " + run1.toString());
					if (run1.getPCPUtimeInt() == 0) {
						run1.setPState("EXIT");
						run1 = null;
					}
				}
			}
			//System.out.println("END OF THREAD 1");
		}
	};

	// my second thread
	Thread t2 = new Thread() {

		public void run() {

			if (run2 != null) {
				//if (!run2.getCritStart())
					//System.out.println("CRIT START IS FALSE");
				if (run2.getCritStart() && critOpen) {
					critOpen = false;
					open2 = true;
				}
				if (run2.getCritStart() && open2) {
					int cpuTime2 = run2.getPCPUtimeInt();
					cpuTime2--;
					run2.setPCPUtimeInt(cpuTime2);
					//System.out.println("CPU TIME LEFT: " + cpuTime2);
					//System.out.println("AFTER TEST: " + run2.toString());
					if (!(run2.getCritStart())) {
						critOpen = true;
						//System.out.println("THE GATE IS NOW OPEN2");
						open2 = false;
					}
					if (run2.getPCPUtimeInt() == 0) {
						run2.setPState("EXIT");
						run2 = null;
					}
				} else if (!(run2.getCritStart())) {
					int cpuTime2 = run2.getPCPUtimeInt();
					cpuTime2--;
					run2.setPCPUtimeInt(cpuTime2);
					//System.out.println("CPU TIME LEFT: " + cpuTime2);
					//System.out.println("AFTER TEST: " + run2.toString());
					if (run2.getPCPUtimeInt() == 0) {
						run2.setPState("EXIT");
						run2 = null;
					}
				}
			}
			//System.out.println("END OF THREAD 2");
		}
	};

	// Third Thread
	Thread t3 = new Thread() {

		public void run() {

			if (run3 != null) {
				//if (!run3.getCritStart())
					//System.out.println("CRIT START IS FALSE");
				if (run3.getCritStart() && critOpen) {
					critOpen = false;
					open3 = true;
				}
				if (run3.getCritStart() && open3) {
					int cpuTime3 = run3.getPCPUtimeInt();
					cpuTime3--;
					run3.setPCPUtimeInt(cpuTime3);
					//System.out.println("CPU TIME LEFT: " + cpuTime3);
					//System.out.println("AFTER TEST: " + run3.toString());
					if (!(run3.getCritStart())) {
						critOpen = true;
						//System.out.println("THE GATE IS NOW OPEN3");
						open3 = false;
					}
					if (run3.getPCPUtimeInt() == 0) {
						run3.setPState("EXIT");
						run3 = null;
					}
				} else if (!(run3.getCritStart())) {
					int cpuTime3 = run3.getPCPUtimeInt();
					cpuTime3--;
					run3.setPCPUtimeInt(cpuTime3);
					//System.out.println("CPU TIME LEFT: " + cpuTime3);
					//System.out.println("AFTER TEST: " + run3.toString());
					if (run3.getPCPUtimeInt() == 0) {
						run3.setPState("EXIT");
						run3 = null;
					}
				}
			}
			//System.out.println("END OF THREAD 3");
		}
	};

	// Fourth Thread
	Thread t4 = new Thread() {

		public void run() {

			if (run4 != null) {
				//if (!run4.getCritStart())
					//System.out.println("CRIT START IS FALSE");
				if (run4.getCritStart() && critOpen) {
					critOpen = false;
					open4 = true;
				}
				if (run4.getCritStart() && open4) {
					int cpuTime4 = run1.getPCPUtimeInt();
					cpuTime4--;
					run4.setPCPUtimeInt(cpuTime4);
					//System.out.println("CPU TIME LEFT: " + cpuTime4);
					//System.out.println("AFTER TEST: " + run4.toString());
					if (!(run4.getCritStart())) {
						critOpen = true;
						if(critOpen)
						//System.out.println("THE GATE IS NOW OPEN4");
						open4 = false;
					}
					if (run4.getPCPUtimeInt() == 0) {
						run4.setPState("EXIT");
						run4 = null;
					}
				} else if (!(run4.getCritStart())) {
					int cpuTime4 = run4.getPCPUtimeInt();
					cpuTime4--;
					run4.setPCPUtimeInt(cpuTime4);
					//System.out.println("CPU TIME LEFT: " + cpuTime4);
					//System.out.println("AFTER TEST: " + run4.toString());
					if (run4.getPCPUtimeInt() == 0) {
						run4.setPState("EXIT");
						run4 = null;
					}
				}
			}
			//System.out.println("END OF THREAD 4");
		}

	};

}
