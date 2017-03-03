package mergingSort;

/**
 * 
 * @author Claudius
 * 这个算法的实现，使用了n+logn的额外空间复杂度，主要是在merge中新建数组并且又赋值给了原数组。增加了时间复杂度。
 * 否则不赋值给原数组的话，原数组中的对应子段还是无需的，后续的merge将毫无意义
 */
public class MergingSort {
	/**
	 * 归并排序
	 * @param array
	 */
	public void sort(int [] array) {
		if (array==null || array.length <= 1) {
			return ;
		}
		int length = array.length;
		msort(array, 0,length-1);
	}

	/**
	 *   调整并规整array中begin到end的值，将他们在array中排为有序序列
	 * @param array    数组
	 * @param begin    开始下标
	 * @param end      结束下标
	 */
	public void msort(int [] array,int begin ,int end ) {
		if (begin == end) {                                                    //当前子段只剩下一个
			return; 
		}
		int middle = (begin + end)/2;                                          //取前后下标的中点
		msort(array,begin, middle);                                            //递归，排序左半段
		msort(array,middle + 1, end);                                          //递归，排序右半段
		merge(array,begin,middle,end);                                         //合并左右两个半段，变为有序序列
	}

	/**
	 *   合并两段有序序列，左半端为begin-middle，右半段为middle+1 - end
	 * @param array       数组 
	 * @param begin       开始下标
	 * @param middle      分段点
	 * @param end         结束下标
	 */
	public void merge(int [] array,int begin ,int middle ,int end){
		int left ,right, index;
		int newArray[] = new int [end + 1];                                              //用来存储有序新值的数组
		for( left = begin, right = middle + 1 , index = begin; left <= middle && right <= end; index++ ){  //同时从两个子段开始遍历
			if (array[left] < array[right]) {                                                              //选取两个子段中较小的一个值赋值给新数组的下标
				newArray[index] = array[left++];                                                           //然后将该下标的值赋值到newArray中，然后两个下标各+1
			}
			else {
				newArray[index] = array[right++];
			}
		}
		
		while(left <= middle){                                                          //要么是左边要么是右边，将剩下的直接赋值到newArray中
			newArray[index ++] =array[left++];
		}
		while(right <= end){
			newArray[index ++] =array[right++];
		}
		while(begin <= end){                    //将当前存储的有序序列，重新赋值给原array
			array[begin] = newArray[begin];
			begin++;
		}
		
	}
}
