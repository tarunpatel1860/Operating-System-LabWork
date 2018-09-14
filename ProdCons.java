
import java.util.ArrayList;
import java.util.*;

public class ProdCons{
    public static void main(String[] args) {
        
    List <Integer> b = new ArrayList <Integer> ();
    Thread p= new Thread( new Producer(b));
    Thread c= new Thread( new Consumer(b));
    
    p.start();
    c.start();
    
    }
}

class Producer implements Runnable
{
    List<Integer> b = null;
    private int i=0;
    final int maxs=5;
    
    Producer( List<Integer> b)
    {
        this.b=b;
    }        

public void Produce(int i) throws InterruptedException
{
    synchronized(b)
    {
        while(b.size()==maxs)
        {
           System.out.println("Producer is waiting");
           b.wait();
        }
    }
    
    synchronized(b)
    {   System.out.println("Producer is producing");
        b.add(i);
        Thread.sleep(500);
        b.notify();
    }    
    
}

public void run()
{
    try{
        while(true)
        {
            i++;
            Produce(i);
        }
    }
    
    catch(Exception e)
    {
        System.out.println(" Exception !!!!! " + e);
        
    }
}
}




class Consumer implements Runnable
{
    List<Integer> b = null;
    private int i=0;
    final int maxs=5;
    
    Consumer( List<Integer> b)
    {
        this.b=b;
    }        

public void Consume(int i) throws InterruptedException
{
    synchronized(b)
    {
        while(b.isEmpty()==true)
        {
           System.out.println("Consumer is waiting");
           b.wait();
        }
    }
    
    synchronized(b)
    {   System.out.println("Consumer is consuming");
        b.remove(0);
        Thread.sleep(500);
        b.notify();
    }    
    
}

public void run()
{
    try{
        while(true)
        {
            i++;
            Consume(i);
        }
    }
    
    catch ( Exception e)
    {
        System.out.println(" Exception !!!!" + e);
        
    }
}
}
