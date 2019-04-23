package test.multithreading;

public class TThread2 implements Runnable {
	private int accountNum;
	private String name;
	
	public TThread2(int accountNum, String name) {
		this.accountNum = accountNum;
		this.name = name;
	}
	
	public void run() {
		name = Thread.currentThread().toString();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TThreadUtil tThreadUtil = new TThreadUtil(accountNum, name);
		tThreadUtil.payStockFunds();
	}
	
}
