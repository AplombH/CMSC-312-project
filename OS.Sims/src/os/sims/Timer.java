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
    
    private double time;
      
    public Timer(){}
    
    public void startTimer()
    { time = 0;}
    
    public double getTimer()
    {return time;}
    
    public void updateTimer(int t)
    {time = time + 3 + (t*0.05);}
    
    public void resetTimmer(){time = 0;}
    
    
    
}
