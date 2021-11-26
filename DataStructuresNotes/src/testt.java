
public class testt {

	public static void main(String[] args) {
		
		LLNode<String> one = new LLNode<String>("ok");
		LLNode<String> two = new LLNode<String>("ww");
		one.setLink(two);
		
		
		while (one != null) {
			System.out.println(one.getInfo());
			one = one.getLink();
		}
		doTowers(4,1,2,3,0);
		
		

	}
	
	static void recInsertEnd(String newInfo, LLNode<String> listRef) {
		if (listRef.getLink() != null) {
			recInsertEnd(newInfo, listRef.getLink());
			
		}
		else {
			listRef.setLink(new LLNode<String>(newInfo));
			
		}
		
	}
	
	static void ins(String newInfo, LLNode<String> front, LLNode<String> current) {
		
	}
	
	public static void doTowers(int n, int startPeg, int auxPeg, int endPeg, int t) {
		if (n==1) {
			System.out.println("Move ring " + n + " from peg " + startPeg + " to peg " + endPeg +" "+ t++);
		}
		else {
			doTowers(n - 1, startPeg, endPeg, auxPeg, t);
			System.out.println("Move ring " + n + " from peg " + startPeg + " to peg " + endPeg +" "+ t++);
			doTowers(n - 1, auxPeg, startPeg, endPeg, t);
		}
	}

}
