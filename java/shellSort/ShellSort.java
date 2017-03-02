package shellSort;


/**
 * 
 * @author Claudius
 *  希尔排序，与插入排序类似 ，但是对于大于当前值的后移不是后移一位，而是后移increment位，遍历完成后会做到大概基本有序，然后减小increment，再次进行遍历，直到最后increment为1（此时等效于插入排序）.
 *	跳跃式的插入减少了不必要的匹配。
 */
public class ShellSort {
	public void sort(int[] array) {
		int length = array.length;
		int increment = length;
		do {                                //最外圈循环，一次次减少increment的值，直到最后increment的值为1（此时等同于插入排序）
			increment = increment / 3 + 1;
			for (int index = increment; index < length; index++) {       //从increment+1开始遍历到最后一位   index为当前下标
				int record = array[index];								 //记录当前值
				int position = index - increment ;						 //当前下标的前increment的位
				for (; position >= 0 && array[position] > record ; position -= increment) {       //跳跃式的比较并插入，如果小，则后移increment位
					array[position + increment] = array[position];
				}
				array[position + increment] = record;                    //最后在适当的位置赋值为当前下标代表的值
			}
		} while (increment > 1);   
	}
}
