package quickSort;



public class Main {
	public static void main(String [] args) {
		QuickSort hp = new QuickSort();
		int [] array = {2,2,3,55,79,10,7,8};
		hp.qSort(array,0,array.length-1);
		for(int i : array){
			System.out.println(i);
		}
	}
}
