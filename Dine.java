/* Program for the classic dining philosopher problem in operating system */
package javacodes;


public class Dine{
    
	public static void main(String[] args){

		int x=10;

		Log.msg(String.valueOf(x));
 		/* Initializing 5 chopsticks */
		Chopstick[] chopistics = new Chopstick[5];

		for(int i=0; i< chopistics.length; i++){
                    
			chopistics[i] = new Chopstick("C: "+i);
		}
                
		// Initialising five philosophers and their corresponding positions 
		Philosopher[] philosophers = new Philosopher[5];
                
		philosophers[0] = new Philosopher("P: 0 - ", chopistics[0], chopistics[1]);
                
		philosophers[1] = new Philosopher("P: 1 - ", chopistics[1], chopistics[2]);
                
		philosophers[2] = new Philosopher("P: 2 - ", chopistics[2], chopistics[3]);
                
		philosophers[3] = new Philosopher("P: 3 - ", chopistics[3], chopistics[4]);
                
		philosophers[4] = new Philosopher("P: 4 - ", chopistics[4], chopistics[0]);

		for(int i=0;i<philosophers.length;i++){
                    
			Log.msg("Thred "+ i);
                        
			Thread t= new Thread( philosophers[i]);
                        
			t.start();
		}
 	}
}

//Class for philosophers
class Philosopher extends Thread
{
	private Chopstick leftChopistick;
        
	private Chopstick rightChopistick;

	private String name;
        
	private int state;

	public Philosopher ( String name, Chopstick left, Chopstick right){
            
		this.state = 1;
                
		this.name = name;
                
		leftChopistick = left;
                
		rightChopistick = right;
	}
 
	public void eat()
	{
	// While eating, every philosopher pics up the left chopstick first and the the right chopstick. If the philosopher gets both the chopsticks
	// he eats for 1000 ms and then releases the chopsticks
	//Else he waits for chopsticks to be free
		if(! leftChopistick.used){
                    
			if(!rightChopistick.used){
                            
				leftChopistick.take();
                                
				rightChopistick.take();

				Log.msg(name + " : Eat");
				
				Log.Delay(1000);

				leftChopistick.release();
                                
		 		rightChopistick.release();
			}
		}		
		think();
	}

	public void think(){
            
		 	this.state = 1;
                        
		 	Log.msg(name + " : Think");
                        
		 	Log.Delay(1000);
		
	}

	public void run(){
            
		for(int i=0; i<=10; i++){
                    
			eat();
		}
	}
}

class Log{

	public static void msg(String msg){
            
		System.out.println(msg);
	}
	public static void Delay(int ms){
		try{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex){ }
	}
}

//Class for chopstick that provides use and release functionalities to pilosophers
class Chopstick{

	public boolean used;
        
	public String name;

	public Chopstick(String name){
            
		this.name = name;
	}
	//method to reserve the chopstick for use
	public synchronized void take() {
            
		Log.msg ("Used :: " + name );
                
		this.used = true;
	}
	
	//method to release the chopstick for use
	public synchronized void release() {
            
		Log.msg ("Released :: " + name );
                
		this.used = false ;
	}
}
