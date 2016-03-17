import java.awt.Component;
import java.util.Iterator;

/**
 * One object of class CountryList stores a linked list of Node<T> objects.
 * @author Shiva
 */
public class LinkedList<T> implements Iterable {
	private Node<T> head;
	private int size;
	

/**
 * Nested class, iterates over elements of LinkedList class
 * @author Shiva
 */
	public class ListIterator implements Iterator<T>{
		private Node<T> current;
		
		/**
		 * Constructs an interator that points
		 * to the head of the list
		 */
		public ListIterator(){
			current = head;
		}
		
		/**
		 * Returns the next object in 
		 * the list
		 * @return data  data portion of node
		 */
		public T next(){
			T data = current.getData();
			current = current.getNext();
			return data;
		}

		/**
		 * checks if list has an element
		 */
		@Override
		public boolean hasNext() {
			if(current == null){
				return false;
			}
			return true;
		}
		
	}

	/**
	 * Constructs a linked list with
	 * head point null 
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	

	/**
	 * Adds a new data object to the CountryList.
	 * @param data   data portion of the Node
	 */
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		size++;
	}
	
	
	/**
	 * Calls the equals() method and checks if
	 * data exists in the linked list
	 * @param element   data requested by user
	 * @return element object of type T
	 */
	public T contains(T element) {
		if (isEmpty()) {
			System.err.print("List is empty!");
			return null;
		}
		else{
		Node<T> current = head;
		while (current != null) {
			if (current.getData().equals(element)) {
				return current.getData();
			} 
			current = current.getNext();
			}
		}
		return null;
	} 
	
	
	/**
	 * Returns a string representation of all the
	 * nodes in the linked list
	 */
	public String toString() {
		String info = " ";
		Iterator<T> llIterator = iterator();
		while(llIterator.hasNext()){
			info += llIterator.next() + "\n";
		}
	return info;
	}

	/**
	 * Returns true if linked list is empty
	 * @return  true
	 */
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns size of the linked list.
	 * @return size  length of linked list
	 */
	public int size() {
		return size;
	}

	
	/**
	 * Returns a new ListIterator
	 * @return ListIterator() iterator that points
	 * to head of list
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}


	public Node<T> getNodeAtIndex(int index) {
		Node<T> temp = this.head;
		int counter = 0;
		while(temp!= null && counter <= index){
			if(counter==index){
				return temp;
			}
			else{
				temp = temp.getNext();
				counter++;
			}
		}
		return null;
	}


		
}


