package quickSort;

import java.lang.reflect.Array;

public class QuickSort {
	/**
	 * 首先对整个数组进行大小分割，并将分割下标返回，然后依次递归调用分别对左半和右半进行大小分割
	 * @param array 需要排序的数组
	 * @param begin 开始下标
	 * @param end   结束下标
	 */
	public void qSort (int [] array,int begin,int end){
		if (begin >= end) {
			return;
		}
		int part =partition(array, begin, end);
		qSort(array, begin, part-1);
		qSort(array, part+1, end);
	}
	/**
	 * 对array数组进行分割，左起left右起right
	 * @param array 数组
	 * @param left  开始下标
	 * @param right 结束下标
	 * @return      分割点下标
	 */
	public int partition(int []array ,int left,int right ){
		int partValue = array[left];                                   //取left为分割值
		while(left<right){                                             //保证左端小于右端
			while(left<right && array[right] >= partValue){            //从右端比较，若右端均大于分割值，则右端递减
				right--;
			}
			array[left] = array[right];                                //将右端小于分割值的值赋值给左端
			while(left<right && array[left] <= partValue)              //同理比较左端
				left++;
			array[right] = array[left];
		}
		array[left] = partValue;
		return left;
	}
}
