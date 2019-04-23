package test.sort;

/** 
 * <p>Title:StraightInsertion </p>
 * <p>Description:直接插入排序   
 * 空间复杂度为O(1) 时间复杂度O(n²) 平均复杂度为O(n²)直接插入排序是稳定的</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午5:07:05
 */
public class StraightInsertion {
	
	private int[] data;
	private int count;
	
	public StraightInsertion(int[] data, int count) {
		this.data = data;
		this.count = count;
	}
	
	/*
	 * 排序算法
	 * 具体流程如下：
	 * 1、首先比较数组的前两个数据，并排序；
	 * 2、比较第三个元素与前两个排好序的数据，并将第三个元素放入适当的位置；
	 * 3、比较第四个元素与前三个排好序的数据，并将第四个元素放入适当的位置；
	 * ......
	 * 4、直至把最后一个元素放入适当的位置。
	 */
	public void sort() {
		
		int temp;
		int length = data.length;
		int j;
		
		for(int i = 1; i < length; i++){
			
			temp = data[i];
						
			for(j = i-1; j >= 0; j--) {
				
				count ++;
				
				if(temp < data[j]) {
					data[j+1] = data[j];
				} else {
					break;
				}
			}
			
			data[j+1] = temp;
		}
		
		System.out.println("花费次数：" + count);
	}
}
