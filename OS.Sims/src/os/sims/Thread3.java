/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.sims;

public class Thread3 extends Thread
{ private int i;
private String []Core2Thred1;
int counter3;
String str;

    public Thread3(String [] Core2Thred1, String str, int counter3)
    {
        this.Core2Thred1=Core2Thred1;
        this.counter3 = counter3;
        this.str = str;
    }

    public void run()
    {
         for (i = 0; i <30; i++){if (Core2Thred1[i].equals("null")){Core2Thred1[i] = str; counter3--;break;}}

    }
}
