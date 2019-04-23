package test.sort;

/**
 * 
 * <p>Title:SimpleChoices </p>
 * <p>Description: 简单选择排序  
 * 直接选择排序是一种不稳定的排序方法 时间复杂度为O(n2) 空间复杂度为O(1)</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 上午11:39:08
 */
public class SimpleChoices {
	
	private int[] data;
	
	public SimpleChoices(int[] data) {
		this.data = data;
	}
	
	/*
	 * 排序算法
	 * 基本原理如下：
	 * 对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录的位置与第一个记录的位置交换；
	 * 接着对不包括第一个记录以外的其他记录进行第二次比较，得到最小记录并与第二个位置记录交换；
	 * 重复该过程，知道进行比较的记录只剩下一个为止。
	 */
	public void sort() {
		
		int temp;
		int flag;
		
		for(int i = 0; i < data.length; i++) {
			
			temp = data[i];
			flag = i;
			
			for(int j = i + 1; j < data.length; j++) {
				if(temp > data[j]) {
					temp = data[j];
					flag = j;
				}
			}
			
			if(flag != i) {
				data[flag] = data[i];
				data[i] = temp;
			}
		} 
	}

}
