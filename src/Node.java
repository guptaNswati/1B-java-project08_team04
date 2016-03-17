/**
 * One object of class Node<T> contains data of type T and a pointer of type Node<T>.
 * @author Shiva
 */

public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	/**
	 * Constructs a node object that 
	 * contains data and points to null.
	 * @param data   contains data 
	 */
	public Node(T data){
		this.data = data;
		setNext(null);
	}
	
	/**
	 * Constructs a node to hold the data
	 * and point to another node.
	 * @param data	 contains data
	 * @param other object of type Node<T>
	 */
	public Node(T data,  Node<T> other){
		this.data = data;
		setNext(other);
		
	}
	

	/**
	 * returns data object of type T
	 * @return data  contains data
	 */
	public T getData() {
		return data;
	}

	/**
	 * returns next  object of type Node<T>
	 * @return  next  points to next node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * sets value of Node<T> object next
	 * @param next  points to next node
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * Returns string representation of node
	 */
	public String toString(){
		String info = " ";
		info += this.data;
		return info;
	}
	
}

