package test.sort;

/**
 * <p>Title:Bubbling </p>
 * <p>Description: 冒泡排序
 * 时间复杂度为O(n^2),空间复杂度为O(1),它是一种稳定的排序算法。</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 上午11:11:13
 */
public class Bubbling {
	
	private int[] data;
	
	public Bubbling(int[] data) {
		
		this.data = data;
	}
	
	/*
	 * 设排序表长为n，从后向前或者从前向后两两比较相邻元素的值，如果两者的相对次序不对(A[i-1]> A[i])，则交换它们，其结果是将最小的元素交换到待排序序列的第一个位置，我们称它为一趟冒泡。
	 * 下一趟冒泡时，前一趟确定的最小元素不再参与比较，待排序序列减少一个元素，每趟冒泡的结果把序列中最小的元素放到了序列的”最前面”。
	 */
	public void sort() {
		
		int j;
		int k;
		int temp;
		int flag = data.length;
		
		while(flag > 0) {
			k = flag;
			flag = 0;
			
			for(j = 1; j < k; j++) {
				
				if(data[j-1] > data[j]) {
					
					temp = data[j-1];
					data[j-1] = data[j];
					data[j] = temp;
					flag = j;
				}
			}
		}
		
	}

}
