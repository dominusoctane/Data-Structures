
public class test {
	public static void main(String args[]) {
		Hash h = new Hash();
		
		int[] ar = {3,2,1,4};
		int[] arr = new int[ar.length];
		arr = h.linearProbe(ar);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		

	}
	

}
