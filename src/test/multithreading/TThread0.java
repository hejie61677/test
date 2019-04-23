package test.multithreading;

public class TThread0 {

	public static void main(String[] args) {
		TThread1 t1 = new TThread1(10, Thread.currentThread().toString());
		t1.start();
		TThread1 t2 = new TThread1(10, Thread.currentThread().toString());
		t2.start();
		TThread1 t3 = new TThread1(10, Thread.currentThread().toString());
		t3.start();

	}

}
