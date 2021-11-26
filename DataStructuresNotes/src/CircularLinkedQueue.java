
public class CircularLinkedQueue<T> implements QueueInterface<T> {

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		LLNode<T> newNode = new LLNode<T> (element);

			//makes the newNode be linked to what rear is linked to, which is the "front".
			//newNode.setLink(rear.getLink());
			//makes the rear linked to the newNode
			//rear.setLink(newNode);
			//makes the new rear be newNode
			//rear = newNode;
			//numElements++;
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
