package mergingSort;

public class Main {
	public static void main(String args[]) {
		int [] array = {2,4,3,33,6,7,5,22,11};
		MergingSortImprove mm = new MergingSortImprove();
		mm.mergeSort(array);
//		MergingSort mm =new MergingSort();
//		mm.sort(array);
//		MergingSort2 ms = new MergingSort2();
//		ms.sort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}


}
