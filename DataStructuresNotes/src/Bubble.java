
public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A [] = {3,12,34,56,78,56};
		
		applyBubble(A);
		for(int i = 0; i < A.length; i++){
			System.out.println(A[i]);
	}

}
	public static void applyBubble(int A []){
		int temp;
		int n = A.length;
		for(int i = 0; i < n-2; i++){
			for(int j = 0; j < n-2; j++){
				if(A[j] > A[j+1]){
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}	
			}
		}
	}
}