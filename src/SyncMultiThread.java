


/*
 * With Synchronization
 * so output should be consistent - one thread should finsih before the other
 */


class TableSync {
	
	synchronized void printTable(int n) { // synchronized keyword to ensure consistency
		for (int i = 1; i <= 5; i++) {
			System.out.println(n*i);
		}
		try {
			Thread.sleep(400); // try catch bloch to handle exceptions when it sleeps
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

//first thread
class MyThread1 extends Thread{  // interit from the superclass
	
	TableSync t = new TableSync (); // create an instance of the class TAableSync
	
	@Override
	public void run() {  
		t.printTable(5);  // to call the class method
	}
}

//second thread
class MyThread2 extends Thread{
	
	TableSync t = new TableSync ();
	
	@Override
	public void run() { 
		t.printTable(100);
	}
}


public class SyncMultiThread {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1 ();  //create an instance of the class Mythtread to call the superclass methods
		MyThread2 t2 = new MyThread2 ();
		t1.start();
		t2.start();
	}
}

