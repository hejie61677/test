package test.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Title:Radix </p>
 * <p>Description: 基数排序  时间复杂度：O(nlog2n)</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午5:31:00
 */
public class Radix {
	
	private int[] data;
	
	public Radix(int[] data) {
		
		this.data = data;
	}
	
	/*
	 * 排序算法
	 * 基数排序不是基于排序关键字来比较排序项，而是基于排序关键字的结构。对于排序关键字中的每一个数字或字符的每一种可能取值，都会创建一个单独的队列。队列的数目就称为基数。
	 * 例如：要排序全部由小写字母组成的字符串，则基数就是26，就会用到26个单独的队列。如果对十进制数进行排序，则基数应该是10。
	 * 注：此例适用于多个3位整数排序
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		String temp;
		int numObj;
		int digit;
		int num;
		Queue<Integer>[] digitQueue = (LinkedList<Integer>[])(new LinkedList[10]);

		for(int digitVal = 0; digitVal <= 9; digitVal++) {

			digitQueue[digitVal] =(Queue<Integer>)(new LinkedList<Integer>());
		}

		for(int pos = 0; pos <= 3; pos++) {

			for(int scan = 0; scan <data.length; scan++) {
				
				temp = String.valueOf(data[scan]);
				digit = Character.digit(temp.charAt((3 - pos)), 10);
				digitQueue[digit].add(new Integer(data[scan]));
			}

			num = 0;
			
			for(int digitVal = 0; digitVal <= 9; digitVal++) {
				
				while(!(digitQueue[digitVal]).isEmpty()) {
					
					numObj = digitQueue[digitVal].remove();
					data[num] = numObj;
					num++;
				}
			}

		}
	}
}
