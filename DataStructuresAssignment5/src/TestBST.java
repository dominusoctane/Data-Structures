import java.util.ArrayList;

public class TestBST {
    public static void main(String args[]){
        BinarySearchTree<Integer> a = new BinarySearchTree<Integer>();
        a.add(5);
        a.add(3);
        a.add(8);
        a.add(2);
        a.add(4);
        a.add(7);
        a.add(9);
        a.add(1);
        //a.deque(9);
        a.printByLevel();
        /*

        System.out.println(a.twoPower(a.height(a.root)));
        

        
        System.out.println(a.getSecondLargest());
        
        space();
        
        a.printByLevel();
        
        space();

        a.printPaths();
        
        space();
        
        a.printLeafNodes();
        
        space();
        
        System.out.println(a.traverseCheckLevel(a.root));
*/

    }
    
  // For spacing purposes
  public static void space() {
	  System.out.println("\n");
	  
  }  
    
}
