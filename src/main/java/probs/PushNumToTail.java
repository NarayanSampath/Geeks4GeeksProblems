import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Test {
	// Write a code to shift zeroes to the end of the array var array =[4,0,1,0,6]
	// Output [4,1,6,0,0]
	public static void main(String[] args) {
		System.out.println("new arrayList = " + pushZeroToLast(new ArrayList(Arrays.asList(4, 0, 1, 0, 6))));
	}

	private static List<Integer> pushZeroToLast(List<Integer> array) {
		List<Integer> newArrayList = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) != 0) {
				newArrayList.add(array.get(i));
			}
		}
		if (newArrayList.size() < array.size()) {
			for (int i = newArrayList.size(); i < array.size(); i++) {
				newArrayList.add(0);
			}
		}
		return newArrayList;
	}

	private static List<Integer> pushZeroToLast1(List<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == 0) {
				array.remove(i);
				array.add(0);
			}
		}
		return array;
	}

}
