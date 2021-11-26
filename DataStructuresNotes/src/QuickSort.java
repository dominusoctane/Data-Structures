import java.util.Arrays;
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The given input to test for the quick sort 
		int [] input = { 9, 5, 6, 2, 1, 4, 7};
		// A system out print that prints the array before the sort method occurs
		System.out.println("Before Sorting: " + Arrays.toString(input));
		// Sort the method using the quick sort algorithm 
		Sort(input);
		// A system out print line that prints the final solution after sorting
		System.out.println("After Sorting: " + Arrays.toString(input));

	}
 
	// This method sorts using the quick sort method 
	public static void Sort(int [] array){
		quickSort(array, 0, array.length - 1);
	}
	
	// The recursive method for the quick sort 
	// Recursive method is used to call the left side first to the partition
	// Then the recursive method is used to call the right side to the partition
	public static void quickSort(int [] array, int start, int end){
		int index = partition(array, start, end);
		if(start < index - 1){
			quickSort(array, start, index - 1);
		}
		if(end > index){
			quickSort(array, index, end);
		}
	}
		
		// This divides the array from the left side that has numbers less than
		// Then divides the array from the right side that has numbers greater than
		public static int partition(int[] array, int left, int right){
			int middle = array[left];
			// Searching for numbers that are greater than the middle number 
			while (left <= right){
				while(array[left] < middle){
					left++;
				}
				// Searching for numbers that are less than the middle number 
				while(array[right] > middle){
					right--;
				}
				// This swaps the value depending on with side is bigger or smaller
				if(left <= right){
					int temp = array[left];
					array[left] = array[right];
					array[right] = temp;
					// This increments the left and decrements the right 
					left++;
					right--;
				}
			}
			return left;
}
		
}
