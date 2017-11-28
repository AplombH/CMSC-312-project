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
public class Timer {
    
    private int times;
      
    public Timer(){}
    
    public void setCounter( int t)
    { times = t;}
    
    public int getCounter(String str)
    {return times;}
    
    public void updateCounter(int t)
    {times = times - t;}
    
    
    
}
