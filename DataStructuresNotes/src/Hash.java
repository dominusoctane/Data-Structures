
public class Hash {
	public int[] linearProbe(int[] arr) {
		int[] a = new int[arr.length];
		int len = arr.length;
		int x = 0;
		
		for (int y = 0; y < len; y++) {
			System.out.println(a[y]);
			//a[y] = 0;
		}
		int j = 0;
		for (int i = 1; i < len; i++) {
			for (int k = 1; k < len; k++) {
				if (i == (arr[k] % len)) {
					a[i] = arr[k] % len;
				}
				else {
					x = recCheck(arr,k);
					a[x] = arr[k] % len; 
				}
			}
			
		}
		
		
		
		return a;
		
	}
	
	public int recCheck(int[] arr, int i) {
		if (arr[i] != 0) {
			if (i == arr.length - 1) {
				return recCheck(arr, 0);
			}
			else {
				return i;
			}
		}
		else {
			return recCheck(arr, i+1);
		}
	}

}
