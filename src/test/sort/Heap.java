package test.sort;

/**
 * <p>Title:Heap </p>
 * <p>Description: 堆排序就是利用堆（假设利用大顶堆）进行排序的方法。
 * 时间复杂度为O(nlogn)堆排序也是一种不稳定的排序方法，不适合待排序序列个数较少的情况</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午3:32:52
 */
public class Heap {
	
	private int[] data;
	
	public Heap(int[] data) {
		this.data = data;
	}
	
	/*
	 * 排序算法
	 * 基本思想是，将待排序的序列构造成一个大顶堆。
	 * 此时，整个序列的最大值就是堆顶的根节点。
	 * 将它移走（其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值），
	 * 然后将剩余的 n-1 个序列重新构造成一个堆，这样就会得到 n 个元素中次大的值。
	 * 如此反复执行，便能得到一个有序序列了。
	 */
	public void sort() {
		int i;
		int temp;
		int length = data.length;
		
		for(i = length / 2 - 1; i >= 0; i--) {
			adjustHeap(i, length - 1);
		}
		
		for(i = length - 1; i >= 0; i--) {
			temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			adjustHeap(0, i - 1);
		}
	}
	
	public void adjustHeap(int i, int len) {
		int temp = data[i];
		int j;
		
		for(j = 2 * i; j < len; j *= 2) {
			
			if(data[j] < data[j + 1]) {
				j += 1;
			}
			
			if(temp >= data[j]) {
				break;
			}
			
			data[i] = data[j];
			i = j;
		}
		
		data[i] = temp;
	}

}
