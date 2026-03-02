import java.util.concurrent.atomic.AtomicInteger;

public class SharedSync
{
	private static int x = 0;
	private static Object lock = new Object ();

	public static void main (String[] args) throws InterruptedException
	{
		x = 0;
		Thread t1 = new Thread (new Adder());
		Thread t2 = new Thread (new Adder());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println ("x = " + x);
	}

	private static class Adder implements Runnable
	{
		public void run()
		{
			for (int i = 0; i < 500000; i++)
			{
				synchronized (lock){
					x++;
				}
			}
		}
	}

}
