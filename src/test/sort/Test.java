package test.sort;

import org.apache.commons.lang3.StringUtils;


public class Test {

	public static void main(String[] args) {
		int[] data = {4,5,1,2,8,6,7,3,10,9};
		String dataShow = "";
		dataShow = StringUtils.join(data, ',');
		System.out.println(dataShow);
		//int count = 0;
		//StraightInsertion sort = new StraightInsertion(data, count);//直接插入排序
		//Hill sort = new Hill(data);//希尔排序
		//SimpleChoices sort = new SimpleChoices(data);//简单选择排序
		//Heap sort = new Heap(data);//堆排序
		//Bubbling sort = new Bubbling(data);//冒泡排序
		//Fast sort = new Fast(data);
		Merger sort = new Merger(data);
		//Radix sort = new Radix(data);
		sort.sort(0, data.length -1);
		//sort.sort();
		dataShow = StringUtils.join(data, ',');
		System.out.println(dataShow);
	}

}

