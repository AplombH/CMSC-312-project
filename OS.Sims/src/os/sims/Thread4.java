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
public class Thread4 extends Thread
{ private int i;
private String []Core2Thred2;
int counter4;
String str;

    public Thread4(String [] Core2Thred2, String str, int counter4)
    {
        this.Core2Thred2=Core2Thred2;
        this.counter4= counter4;
        this.str = str;
    }

    public void run()
    {
         for (i = 0; i <30; i++){if (Core2Thred2[i].equals("null")){Core2Thred2[i] = str; counter4--;break;}}

    }
    
    
}
