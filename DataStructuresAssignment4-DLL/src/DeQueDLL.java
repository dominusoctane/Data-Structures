
public class DeQueDLL<T> implements DequeInterface<T> {

    protected DLLNode<T> front, rear;      // reference to the front and rear of this deque
    protected int numElements = 0; 			// number of elements in this deque

    public DeQueDLL() {
        front = null;
        rear = null;
    }
    // adds a DLLNode with a value at the front of the deque
    public void enqueueFront(T element) {
            DLLNode<T> newNode = new DLLNode<T>(element);
            if(rear == null && front == null) {
            	front = newNode;
            	rear = newNode;
            }
            else {
	            front.setForward(newNode);
	            newNode.setBack(front);
	            front = newNode;    
            }
            numElements++;
    }
    // adds a DLLNode with a value at the back of the deque
    public void enqueueRear(T element) {
            DLLNode<T> newNode = new DLLNode<T>(element);
            if(rear == null && front == null) {
            	rear = newNode;
            	front = newNode;
            }
            else {
                rear.setBack(newNode);
                newNode.setForward(rear);
                rear = newNode;
            }
            numElements++;
        // TODO Auto-generated method stub
    }
    // removes the DLLNode at the front of the deque, and returns the value in that DLLNode
    public T dequeueFront(){
    	T element = null;
    	DLLNode<T> temp = null;

    	if (isEmpty()) {
    		throw new QueueUnderflowException("dequeueFront used on an empty list");
    	}
    	else {
    		element = front.getInfo();
    		if (front != null) {
    			temp = front.getBack();
        		front.setBack(null);
        		front = temp;
    		}
    		else {
    			front = null; rear = null;    			
    		}
    		numElements--;
    	}
        return element;    
    }
    // ddds a DLLNode with a value to the rear of the deque
    public T dequeueRear() {
		T element = null;
    	DLLNode<T> temp = null;

    	if (isEmpty()) {
    		throw new QueueUnderflowException("dequeueFront used on an empty list");
    	}
    	else {
    		element = rear.getInfo();
    		if (rear != null) {
    			temp = rear.getForward();
    			temp.setBack(null);
    			rear.setForward(null);
    			rear = temp;
    		}
    		else {
    			front = null; rear = null;
    		}
    		numElements--;
    	}
        return element;    
    }
    // Deque is never full
    public boolean isFull() {
        return false;
    }
    // Checks if deque is empty
    public boolean isEmpty() {
        return (numElements == 0);
    }
    // returns size of deque
    public int size() {
        // TODO Auto-generated method stub
        return numElements;
    }
    
    
    public String toString() {
    	DLLNode<T> temp = front;
    	String element = "";
    	
    	while ((temp != null)) {
    		if(temp.getBack() == null) {
    			element = temp.getInfo().toString() + element;
    		}
    		else {
        		element = "<--->" + temp.getInfo().toString() + element;
    		}
    		temp = temp.getBack();
    	}
		return element;
    }
    /*
    public DeQueDLL<T> insert(T value) {
		DeQueDLL<T> deque = new DeQueDLL<T>();
		DLLNode<T> node = front, newNode = new DLLNode<T>(value);
		DLLNode<T> tempNode = null, tempNode1 = null, tempNode2 = null, tempNode3 = null;
		if(isEmpty()) {
			deque.enqueueFront(value);
		}
		else {
			front.setForward(newNode);
			newNode.setBack(front);
			front = newNode;
			numElements++;
			
			
			while(node != null) {
				while(tempNode!= null) {
					if((int) node.getInfo() > (int) tempNode.getInfo()) {
						if((node.getForward() != null) && (node.getBack() != null) && (node.getBack().getBack() != null)) {
							tempNode1 = node.getBack();
							tempNode2 = node.getForward();
							tempNode3 = node.getBack().getBack();
							
							tempNode2.setBack(tempNode1);
							tempNode1.setForward(tempNode2);
							
							node.setBack(tempNode3);
							tempNode3.setForward(node);
							
							node.setForward(tempNode1);
							tempNode1.setBack(node);
						}
						else if((node.getForward() == null) && (node.getBack() != null) && (node.getBack().getBack() != null) ) {
							tempNode1 = node.getBack();
							tempNode3 = node.getBack().getBack();
							
							tempNode1.setBack(node);
							node.setForward(tempNode1);
							
							node.setBack(tempNode3);
							tempNode3.setForward(node);
						}
						else if ((node.getForward() == null) && (node.getBack() != null) && (node.getBack().getBack() == null) ) {
							tempNode1 = node.getBack();
							node.setForward(tempNode1);
							tempNode1.setBack(node);	
						}
						//else if ((node.getForward() != null) && (node.getBack() == null) && (node.getBack().getBack() == null) ) {
						//	tempNode1 = node.getForward();
						//}
					}
					tempNode = tempNode.getBack();
				}
				if(node.getBack() != null) {
					node = node.getBack();
				}
				else {
					break;
				}
			}
			System.out.println(front.getInfo());

			while(front != null) {
				deque.enqueueFront(front.getInfo());
				front = front.getBack();
			}
		}
		return deque;
	}
	*/
}
