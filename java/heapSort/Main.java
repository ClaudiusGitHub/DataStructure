package heapSort;

public class Main {
	public static void main(String [] args) {
		HeapSort hp = new HeapSort();
		int [] array = {2,3,55,79,2,6,4,10,7,8};
		hp.sort(array);
		for(int i : array){
			System.out.println(i);
		}
	}
}
