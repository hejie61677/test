package test.sort;

/**
 * <p>Title:Merger </p>
 * <p>Description: 归并排序
 * 		时间复杂度为O(nlogn) 空间复杂度为O(n+logn) 归并排序是一种比较占内存，但却效率高且稳定的算法</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午4:47:31
 */
public class Merger {
	
	private int[] data;
	
	public Merger(int[] data) {
		
		this.data = data;
	}
	
	/*
	 * 排序算法
	 * 基本原理：对于给定的一组记录，利用递归与分治技术将数据序列划分成为越来越小的半子表，在对半子表排序，最后再用递归方法将排好序的半子表合并成为越来越大的有序序列。 
	 * （1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列 
	 * （2）设定两个指针，最初位置分别为两个已经排序序列的起始位置 
	 * （3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置 
	 * （4）重复步骤3直到某一指针达到序列尾 
	 * （5）将另一序列剩下的所有元素直接复制到合并序列尾
	 */
	public void sort(int left, int right) {
		
		int center = (left + right) / 2;
		
		if(left < right) {
			
			sort(left, center);
			sort(center + 1, right);
			merge(left, center, right);			
		} 
	}
	
	public void merge(int left, int center, int right) {

		int[] temp = new int[right - left + 1];
		int i = left;
		int j = center + 1;
		int k = 0;

		while (i <= center && j <= right){

			if (data[i] < data[j]) {
				
				temp[k++] = data[i++];

			} else {

				temp[k++] = data[j++];

			}
		}

		while (i <= center) {

			temp[k++] = data[i++];

		}

		while (j <= right) {

			temp[k++] = data[j++];

		}

		for (int k2 = 0; k2 < temp.length; k2++){

			data[k2 + left] = temp[k2];

		}
	}
}
