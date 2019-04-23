package test.multithreading;

public class TThreadUtil {
	private int accountNum;
	private String name;
	
	public TThreadUtil(int accountNum, String name) {
		this.accountNum = accountNum;
		this.name = name;
	}
	
	public void payStockFunds() {
		while(!isSellingEmpty()) {
			accountNum -= 1;
			System.out.println(name + " : The remaining " + accountNum +  " pieces.");
		}
			
		System.out.println("Sold out!!!");
	
	}
	
	public boolean isSellingEmpty() {
		return accountNum <= 0 ? true : false;
	}
}
