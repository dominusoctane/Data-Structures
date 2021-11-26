import java.util.ArrayList;

//----------------------------------------------------------------------------
//BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 7
//
//Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------


public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>{
    protected BSTNode<T> root;      // reference to the root of this BST

    boolean found;   // used by remove

    // for traversals
    protected LinkedQueue<T> inOrderQueue;    // queue of info
    protected LinkedQueue<T> preOrderQueue;   // queue of info
    protected LinkedQueue<T> postOrderQueue;  // queue of info
    
    // Creates an empty BST object.
    public BinarySearchTree() { root = null; }
    
    
    
    // A recursive method that traverses through the BST
    // to find the second largest value held by any given node.
    // It is always compared to the largest value in the BST.
    private BSTNode<T> recGetSecondLargest(BSTNode<T> node, T largest){
        if ((node.getInfo().compareTo(largest) < 0)){
            if (node.getRight() != null) {
                if((node.getRight().getInfo().compareTo(largest) == 0) && (node.getRight().getLeft() == null) && (node.getRight().getRight() == null)){
                    return node;
                }
                else {
                    return recGetSecondLargest(node.getRight(), largest);
                }
            }
            else
            	return node;
        }
        else{
            if (node.getLeft().getRight() == null) {
                return node.getLeft();
            }
            else
            	return recGetSecondLargest(node.getLeft(), largest);
        }
    }
    
    public void dequeue(T element){
    	ArrayList<T> arr = new ArrayList<T>();
    	BSTNode<T> node = root;
    	LinkedQueue<T> queue = new LinkedQueue<T>();
    	if (!contains(element)) {
    		return;
    	}
    	else {
    		
    	}
    	
    }
    // Uses the recGetSecondLargest method to get the second largest value
    public T getSecondLargest() { 
    	System.out.println("Binary Search Tree Second Largest Value:");
    	return recGetSecondLargest(root, getPredecessor(root)).getInfo(); 
    }
    
    // A breadth depth based method that uses LinkedQueues
    // to print out the values that correspond to each level
    // of the BST.
    public void traverse(BSTNode<T> nod, T element){
        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
        //int expected = 1;
        //int n = 1;
        LinkedQueue<BSTNode<T>> q = new LinkedQueue<>();
        
        if (nod != null) {
            queue.enqueue(nod);

            while (!queue.isEmpty()) {
	                
                    BSTNode<T> node = queue.dequeue();
                    
                    //System.out.print(node.getInfo().toString() + " ");
                    if (node.getInfo()!= element) {
                    	BSTNode<T> currNode = new BSTNode<T>(node.getInfo());
                        q.enqueue(currNode);
                    }
                                        
                    if(node.getLeft() != null) {
                    	queue.enqueue(node.getLeft());
                    }
                    if(node.getRight() != null) {
                    	queue.enqueue(node.getRight());
                    }

            }
            nod = null;
            while (!q.isEmpty()) {
            	add(q.dequeue().getInfo());
            }
        }
    }
    public void deque(T element) {
    	traverse(root, element);
    }
    public void traverseBreadthPrint(BSTNode<T> nod){
        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
        //int expected = 1;
        //int n = 1;
        
        if (nod != null) {
            queue.enqueue(nod);

            while (!queue.isEmpty()) {
	                
                    BSTNode<T> node = queue.dequeue();
                    
                    System.out.print(node.getInfo().toString() + " ");
                                        
                    if(node.getLeft() != null) {
                    	queue.enqueue(node.getLeft());
                    }
                    if(node.getRight() != null) {
                    	queue.enqueue(node.getRight());
                    }

            }

        }
    }
    public boolean traverseCheckLevel(BSTNode<T> nod) {
    	boolean state = true;
    	LinkedQueue<BSTNode<T>> queue = new LinkedQueue<>();
    	int expected = 1;
    	int n = 1;
    	
    	if (nod != null) {
    		queue.enqueue(nod);
    		
    		while (!queue.isEmpty()) {
    			int nodeCount = queue.size();
    			if (nodeCount != expected) {
    				state = false;
    			}
    			
    			if (nodeCount == 0)
    				break;
    			
    			while(nodeCount > 0) {
    				BSTNode<T> node = queue.dequeue();
    				    				
    				if(node.getLeft() != null) {
    					queue.enqueue(node.getLeft());
    				}
    				if(node.getRight() != null) {
    					queue.enqueue(node.getRight());
    				}
    				nodeCount--;
    			}
    			expected = (int) Math.pow(2, n);
    			n++;
    			
    		}
    	}
    	return state;
    }
    
    // Uses the traverseBreadthOrubt method to print by level
    public void printByLevel() { 
    	System.out.println("Binary Search Tree Levels:");
    	traverseBreadthPrint(root); 
    }
    
    // A recursive method that traverses through the BST
    // and looks for the leafs nodes. It prints out the leaf nodes
    public BSTNode<T> recPrintLeafNodes(BSTNode<T> node){
        if (node == null){
            return null;
        }
        else{
            BSTNode<T> tempNodeLeft = recPrintLeafNodes(node.getLeft());
            BSTNode<T> tempNodeRight = recPrintLeafNodes(node.getRight());

            if ((tempNodeLeft == null) && (tempNodeRight == null)){
                System.out.println(node.getInfo().toString());
            }
        }
        return node;
    }
    
    // Uses the recPrintLeafNodes method to print out the leaf nodes
    public void printLeafNodes() {
    	System.out.println("Binary Search Tree Leaf Nodes:");
    	recPrintLeafNodes(root); 
    }
    
    // A method that prints out the values from root to leaf order
    // from the ArrayList<T> path up to a certain index
    private void printArrayList(ArrayList<T> path, int index) {
    	for (int i = 0; i < index; i++) {
    		if ( i < (index-1))
    			System.out.print(path.get(i).toString() + ", ");
    		else
    			System.out.print(path.get(i).toString());
    	}
    	System.out.println(" ");
	}
   
    
    // A recursive method that adds the values of various nodes into an ArrayList<T>
    // which gets passed into the recursive call for the left node and the right 
    // node of the current node if the current node is not equal to null. If the
    // node is a leaf node, then it print the path from the root to that specific leaf node
    // by using the printArrayList method. The index of the ArrayList is handled with
    // int index as the counter
    public BSTNode<T> recPrintPaths(BSTNode<T> node, ArrayList<T> path, int index) {
    	if (node == null)
    		return null;
    	else {
    		path.add(index, node.getInfo());
    		index++;
    	
    		if ((node.getLeft() == null) && (node.getRight() == null)) {
    			printArrayList(path, index);
    		}
    		else {
    			recPrintPaths(node.getLeft(), path, index);    				
    			recPrintPaths(node.getRight(), path, index);
    		}
    	}
		return node;
    }
    
    // A method that prints the BST paths by using the recPrintPaths method
    public void printPaths() {
    	System.out.println("Binary Search Tree Paths:");
    	ArrayList<T> path = new ArrayList<T>();
    	recPrintPaths(root, path, 0);
    }


    // A method that determines if the BST is a full binary tree by
    // using the size, twoPower, and height methods. If the current number
    // of elements is equal to the expected number of elements, then it
    // will return. Otherwise false
	public boolean isFullBinaryTree(){
		System.out.println("Binary Search Tree full?");
        if (size() == twoPower(height(root)))
            return true;
        else
            return false;
    }
	
	// A recursive method that calculates for the sumnation of 2^n,
	// where it will calculate from the initial value of n to 0.
    public double recTwoPower(int n) {
        if (n == 0)
            return 1;
        else
            return Math.pow(2,n) + recTwoPower(n-1);
    }
    
    // Uses recTwoPower to calculate for the sumnation of 2^n
    public double twoPower(int n) { return recTwoPower(n); }
    
    // A recursive method that calculates for the height of the
    // BST, where it always goes down the longest path
    public int recHeight(BSTNode<T> node) {
        if (node == null)
            return -1;
        else{
            int leftNode = recHeight(node.getLeft());
            int rightNode = recHeight(node.getRight());
            return 1 + Math.max(leftNode,rightNode);
        }

    }

    // Uses recHeight to calculate for the height of the BST
    public int height(BSTNode<T> node) { return recHeight(root); }
    
    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty() { return (root == null); }

    private int recSize(BSTNode<T> node)
    // Returns the number of elements in tree.
    {
        if (node == null)
            return 0;
        else
            return recSize(node.getLeft()) + recSize(node.getRight()) + 1;
    }
    
    // Returns the number of elements in this BST.
    public int size()
    { return recSize(root); }

    public int size2()
    // Returns the number of elements in this BST.
    {
        int count = 0;
        if (root != null)
        {
            LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
            BSTNode<T> currNode;
            hold.push(root);
            while (!hold.isEmpty())
            {
                currNode = hold.top();
                hold.pop();
                count++;
                if (currNode.getLeft() != null)
                    hold.push(currNode.getLeft());
                if (currNode.getRight() != null)
                    hold.push(currNode.getRight());
            }
        }
        return count;
    }

    private boolean recContains(T element, BSTNode<T> node)
    // Returns true if tree contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns false.
    {
        if (node == null)
            return false;       // element is not found
        else if (element.compareTo(node.getInfo()) < 0)
            return recContains(element, node.getLeft());   // Search left subtree
        else if (element.compareTo(node.getInfo()) > 0)
            return recContains(element, node.getRight());  // Search right subtree
        else
            return true;        // element is found
    }

    public boolean contains (T element)
    // Returns true if this BST contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns false.
    {
        return recContains(element, root);
    }

    private T recGet(T element, BSTNode<T> node)
    // Returns an element e from tree such that e.compareTo(element) == 0;
    // if no such element exists, returns null.
    {
        if (node == null)
            return null;             // element is not found
        else if (element.compareTo(node.getInfo()) < 0)
            return recGet(element, node.getLeft());          // get from left subtree
        else
        if (element.compareTo(node.getInfo()) > 0)
            return recGet(element, node.getRight());         // get from right subtree
        else
            return node.getInfo();  // element is found
    }

    public T get(T element)
    // Returns an element e from this BST such that e.compareTo(element) == 0;
    // if no such element exists, returns null.
    {
        return recGet(element, root);
    }

    private BSTNode<T> recAdd(T element, BSTNode<T> node)
    // Adds element to tree; tree retains its BST property.
    {
        if (node == null)
            // Addition place found
            node = new BSTNode<T>(element);
        else if (element.compareTo(node.getInfo()) <= 0)
            node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
        else
            node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
        return node;
    }

    public void add (T element)
    // Adds element to this BST. The tree retains its BST property.
    {
        root = recAdd(element, root);
    }

    public T getPredecessor(BSTNode<T> node)
    // Returns the information held in the rightmost node in tree
    {
        while (node.getRight() != null)
            node = node.getRight();
        return node.getInfo();
    }

    private BSTNode<T> removeNode(BSTNode<T> node)
    // Removes the information at the node referenced by tree.
    // The user's data in the node referenced by tree is no
    // longer in the tree.  If tree is a leaf node or has only
    // a non-null child pointer, the node pointed to by tree is
    // removed; otherwise, the user's data is replaced by its
    // logical predecessor and the predecessor's node is removed.
    {
        T data;

        if (node.getLeft() == null)
            return node.getRight();
        else if (node.getRight() == null)
            return node.getLeft();
        else
        {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(recRemove(data, node.getLeft()));
            return node;
        }
    }

    private BSTNode<T> recRemove(T element, BSTNode<T> node)
    // Removes an element e from tree such that e.compareTo(element) == 0
    // and returns true; if no such element exists, returns false.
    {
        if (node == null)
            found = false;
        else if (element.compareTo(node.getInfo()) < 0)
            node.setLeft(recRemove(element, node.getLeft()));
        else if (element.compareTo(node.getInfo()) > 0)
            node.setRight(recRemove(element, node.getRight()));
        else
        {
            node = removeNode(node);
            found = true;
        }
        return node;
    }

    public boolean remove (T element)
    // Removes an element e from this BST such that e.compareTo(element) == 0
    // and returns true; if no such element exists, returns false.
    {
        root = recRemove(element, root);
        return found;
    }

    private void inOrder(BSTNode<T> node)
    // Initializes inOrderQueue with tree elements in inOrder order.
    {
        if (node != null)
        {
            inOrder(node.getLeft());
            inOrderQueue.enqueue(node.getInfo());
            inOrder(node.getRight());
        }
    }

    private void preOrder(BSTNode<T> node)
    // Initializes preOrderQueue with tree elements in preOrder order.
    {
        if (node != null)
        {
            preOrderQueue.enqueue(node.getInfo());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    private void postOrder(BSTNode<T> node)
    // Initializes postOrderQueue with tree elements in postOrder order.
    {
        if (node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            postOrderQueue.enqueue(node.getInfo());
        }
    }

    public int reset(int orderType)
    // Initializes current position for an iteration through this BST
    // in orderType order. Returns current number of nodes in the BST.
    {
        int numNodes = size();

        if (orderType == INORDER)
        {
            inOrderQueue = new LinkedQueue<T>();
            inOrder(root);
        }
        else
        if (orderType == PREORDER)
        {
            preOrderQueue = new LinkedQueue<T>();
            preOrder(root);
        }
        if (orderType == POSTORDER)
        {
            postOrderQueue = new LinkedQueue<T>();
            postOrder(root);
        }
        return numNodes;
    }

    public T getNext (int orderType)
    // Preconditions: The BST is not empty
    //                The BST has been reset for orderType
    //                The BST has not been modified since the most recent reset
    //                The end of orderType iteration has not been reached
    //
    // Returns the element at the current position on this BST for orderType
    // and advances the value of the current position based on the orderType.
    {
        if (orderType == INORDER)
            return inOrderQueue.dequeue();
        else
        if (orderType == PREORDER)
            return preOrderQueue.dequeue();
        else
        if (orderType == POSTORDER)
            return postOrderQueue.dequeue();
        else return null;
    }
    
    
    public void enq(T element) {
    	
    }
}
