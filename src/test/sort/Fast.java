package test.sort;

/**
 * <p>Title:Fast </p>
 * <p>Description: 快速排序
 * 	时间复杂度：O（n^2）</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 上午11:24:06
 */
public class Fast {

	private int[] data;
	
	public Fast(int[] data) {
		
		this.data = data;
	}
	
	/*
	 * 快速排序是对冒泡排序的一种改进。
	 * 首先在数组中选择一个基准点，然后分别从数组的两端扫描数组，
	 * 设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，如此往复循环，
	 * 直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
	 * 以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
	 */
	public void sort(int start, int end) {
		
		if(start >= end) {
			
			return;
			
		}else {
			
			int partition = divide(start, end);
			sort(start, partition - 1);
			sort(partition + 1, end);			
		}
	}
	
	public int divide(int start, int end) {
		
		int base = data[end];
		
		while(start < end) {
			
			while(start < end && data[start] <= base) {
				
				start++;
			}
			
			if(start < end) {
				
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
				end--;
			}
			
			while(start < end && data[end] >=base) {
				
				end--;
			}
			
			if(start < end) {
				
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
				start++;
			}			
		}
	
		return end;
	}
}
