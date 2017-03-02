package shellSort;

import java.lang.reflect.Array;

public class Main {
	public static void  main(String [] args) {
		ShellSort st = new ShellSort();
		int [] array = {2,3,4,5,3,1,2,54,6,71,12,4};
		st.sort(array);
		for(int t:array)
			System.out.println(t);
	}
}
