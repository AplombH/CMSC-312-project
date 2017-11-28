/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.sims;

/**
 *
 * @author Aplomb
 */
public class Thread1 extends Thread
{ private int i;
private String []Core1Thred1;
int counter1;
String str;

    public Thread1(String [] Core1Thred1, String str, int counter1)
    {
        this.Core1Thred1=Core1Thred1;
        this.counter1 = counter1;
        this.str = str;
    }

    public void run()
    {
         for (i = 0; i <30; i++){if (Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1--;break;}}

    }

 
    
}
