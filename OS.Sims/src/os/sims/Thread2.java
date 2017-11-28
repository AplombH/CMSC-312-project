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
public class Thread2 extends Thread
{ private int i;
private String []Core1Thred2;
int counter2;
String str;

    public Thread2(String [] Core1Thred2, String str, int counter2)
    {
        this.Core1Thred2=Core1Thred2;
        this.counter2 = counter2;
        this.str = str;
    }

    public void run()
    {
         for (i = 0; i <30; i++){if (Core1Thred2[i].equals("null")){Core1Thred2[i] = str; counter2--;break;}}

    }

 

    
       

}
