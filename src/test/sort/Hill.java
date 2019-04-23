package test.sort;

/**
 * <p>Title:Hill </p>
 * <p>Description: 希尔排序   
 * 希尔排序并不稳定,O(1)的额外空间,时间复杂度为O(n²)</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午8:18:49
 */
public class Hill {
	
	private int[] data;
	
	public Hill(int[] data) {
		this.data = data;
	}
	
	/*
	 * 排序算法
	 * 具体流程如下：
　　	 * 1、将包含n个元素的数组，分成n/2个数组序列，第一个数据和第n/2+1个数据为一对...
　　	 * 2、对每对数据进行比较和交换，排好顺序；
　　	 * 3、然后分成n/4个数组序列，再次排序；
　　	 * 4、不断重复以上过程，随着序列减少并直至为1，排序完成。
	 */
	public void sort() {
		
		int length = data.length;
		int temp;
		int j;
		
		for(int counter = length / 2; counter > 0; counter /= 2) {
			
			for(int i = counter; i < length; i++) {
				
				temp = data[i];
				
				for(j = i - counter; j >= 0; j -= counter) {
					
					if(temp < data[j]) {
						data[j + counter] = data[j];
					} else {
						break;
					}					
				}
				
				data[j + counter] = temp;
			}			
		}		
	}
}
