package mergingSort;

/**
 * 
 * @author Claudius
 * 这个算法的实现，使用了n*logn的额外空间复杂度，主要是在每次msort过程中新建数组，将每个子段sort到newArray里，再把newArraymerge到aimArray里，避免了merge中重新赋值给原array的时间复杂度
 */
public class MergingSort2 {
	/**
	 * 归并排序
	 * @param array
	 */
	public void sort(int [] array) {
		if (array==null || array.length <= 1) {
			return ;
		}
		int length = array.length;
		msort(array,array, 0,length-1);  // 传入的不是数组长度，而是最后一个下标值
	}

	/**
	 *  调整并规整array中begin到end的值，将他们在有序的排列到aimArray中
	 * @param array
	 * @param aimArray
	 * @param begin
	 * @param end
	 */
	public void msort(int [] array,int[] aimArray, int begin ,int end ) {
		if (begin == end) {                                                       //当前子段只剩下一个
			aimArray[begin] = array[begin];
			return;
		}
		int [] newArray = new int[array.length];
		int middle = (begin + end)/2;                                                   //取前后下标的中点
		msort(array,newArray,begin, middle);                                            //递归，排序左半段，并赋值到newArray中
		msort(array,newArray,middle + 1, end);                                          //递归，排序右半段，并赋值到newArray中
		merge(newArray,aimArray,begin,middle,end);                                      //将newArray中的值合并到aimArray中
	}


	/**
	 * 合并两段有序序列，左半端为begin-middle，右半段为middle+1 - end,将array中合并到aimArray中
	 * @param newArray           存储数据数组
	 * @param aimArray           合并后的数组
	 * @param begin              开始下标
	 * @param middle             分段下标
	 * @param end                结束下标
	 */
	public void merge(int [] newArray, int [] aimArray,int begin ,int middle ,int end){
		int left ,right, index;
		for( left = begin, right = middle + 1 , index = begin; left <= middle && right <= end; index++ ){  //同时从两个子段开始遍历
			if (newArray[left] < newArray[right]) {                                                              //选取两个子段中较小的一个值赋值给新数组的下标
				aimArray[index] = newArray[left++];                                                           //然后将该下标的值赋值到newArray中，然后两个下标各+1
			}
			else {
				aimArray[index] = newArray[right++];
			}
		}
		
		while(left <= middle){                                                          //要么是左边要么是右边，将剩下的直接赋值到newArray中
			aimArray[index ++] =newArray[left++];
		}
		while(right <= end){
			aimArray[index ++] =newArray[right++];
		}
//		while(begin <= end){                    //将当前存储的有序序列，重新赋值给原array               该算法使用了较多的空间复杂度，避免了赋值过程
//			newArray[begin] = aimArray[begin];
//			begin++;
//		}
		
	}
}