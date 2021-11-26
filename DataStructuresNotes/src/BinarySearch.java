
public class BinarySearch {
	
	boolean binarySearch(int target, int first, int last, int[] arr) {
		int midpoint =(first + last) / 2 ;
		if (first>last) {
			return false;
		}
		else {
			if (target == arr[midpoint]) {
				return true;
			}
			else {
				if (target > arr[midpoint]) {
					return binarySearch(target, midpoint + 1, last, arr);
				}
				else {
					return binarySearch(target, first, last - 1, arr);
					
				}
			}
		}
		
	}

}
