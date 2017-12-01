
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

    public Thread1()
    {
        this.Core1Thred1=Core1Thred1;
        this.counter1 = counter1;
        this.str = str;
    }

    public void run()
    {
        
 
            t1.start();
            t2.start();
// for (i = 0; i <30; i++){if (Core1Thred1[i].equals("null")){Core1Thred1[i] = str; counter1--;break;}}

    }
    
    // my first thread
    Thread t1 = new Thread(){
         public void run(){
 
            for(int i = 1;i <= 5000;i++)
            {
                System.out.println(i);
            }           
         }
     };
    
     // my second thread
    Thread t2 = new Thread(){
 
         public void run(){
 
            for(int i = 5001;i <= 10000;i++)
            {
                System.out.println(i);
            }           
         }
     };
 
       
           
        

 
    
}
