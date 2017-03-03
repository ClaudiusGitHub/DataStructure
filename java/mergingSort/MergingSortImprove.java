package mergingSort;

/**
 * 
 * @author Claudius
 * 该算法为归并排序改进版，使用非递归实现,通过循环归并
 * 首先归并0，1  2,3  4,5  6,7  8,9 ，，，，，，                          该过程对应为mergeSort中while循环的第一个mergePass
 * 然后归并 0 1,2 3      4 5,6 7    8 9,10 11  ，，，， 该过程对应为mergeSort中while循环的第一个mergePass
 * 
 */
public class MergingSortImprove {
	public void mergeSort(int [] array) {
		if (array==null || array.length <=1) {
			return;
		}
		int step = 1;
		int length = array.length;
		int end = length -1 ;                            //最后一个下标
		int [] newArray = new int[length];
		while( step < length){                           //之所以要两个mergePass，就是为了能够让数组重新赋值回原array
			mergePass(array, newArray, step, end);
			step *= 2;
			mergePass(newArray, array, step, end);
			step *= 2;
		}
	}
	/**
	 * 从头到尾按照step的长度进行归并。即 0 到step-1与step+1到2*step-1进行归并 
	 * @param array       原数组
	 * @param newArray    存储新值的数组
	 * @param step        当前步长
	 * @param end         最后一个下标
	 */
	public void mergePass(int [] array, int[] newArray ,int step,int end ){
		int index = 0;
		while(index <= end - 2*step){                                                //从头到尾循环，直到最后没法凑成一对用来归并的step
			merge(array, newArray, index, index + step -1, index + 2 * step - 1);
			index += 2*step;
		}
		if (index <= end -step) {                                                    //剩下超过一个step的长度，那么归并当前step与剩下不到一个step的子段
			merge(array, newArray, index, index+step-1, end);
		}else { 
			while(index <= end){                                                     //剩下不足或者仅仅一个step的时候（因为之前归并已经保证了这段有序），所以直接添加到后面
		 		newArray[index] =array[index];
				index++;
			}
		}
	}
	/**
	 *  基本的merge函数，跟之前两个相同，只是改了参数名字便于理解
	 * @param array
	 * @param newArray
	 * @param begin
	 * @param middle
	 * @param end
	 */
	public void merge(int [] array, int [] newArray,int begin ,int middle ,int end){
		int left ,right, index;
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
	}
}
