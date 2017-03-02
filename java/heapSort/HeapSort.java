package heapSort;

public class HeapSort {
	/**
	 * 
	 * @param array 需要排序的数组
	 * 对数组进行排序
	 */
	public void sort(int [] array){
		if (array == null || array.length <=1) {
			return;
		}
		build(array);
		for(int i = array.length - 1;i > 0;i--){
			swap(array, i, 0);
			adjust(array, 0, i);
		}
	}
	/**
	 *  构建最大堆
	 * @param array  需要排序的数组
	 * 
	 *
	 */
	public void build(int [] array) {
		int length = array.length;		
		for (int fatherIndex = length/2 - 1;fatherIndex >= 0;fatherIndex--){      //从最后一个值的father值开始调整，直到0
			adjust(array, fatherIndex ,length);
		}
	}
	/**
	 *  调整当前father与son值，如果进行了交换，则继续调整son与其son的值
	 * @param array     数组
	 * @param fatherIndex  需要排序的下标值 
	 * @param length    需要排序的数组最大长度
	 */
	public void adjust(int [] array,int fatherIndex,int length) {
		int  son = fatherIndex * 2 + 1;                             //son是当前fatherIndex对应的左孩子
		if (son < length-1 && array[son] < array[son + 1]) {        //如果有右孩子，则选择其中值较大的孩子
			son = son + 1;
		}
		if ( son < length  && array[son] > array [fatherIndex]) {   //如果son的值大于father，则交换father与son的值，由于son变小了，所以要继续调整son与其孩子的值，直到
			swap(array, son, fatherIndex);                          //超过了需要调整的最大长度或者son大于其孩子的值
			adjust(array, son , length);
		}
		
	}
	/**
	 *  交换值
	 * @param array
	 * @param index1
	 * @param index2
	 */
	public void swap(int [] array,int index1,int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
} 
