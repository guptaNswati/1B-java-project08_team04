package project08_team04;

/**
 * 
 * @class Node[contains a generic object and an object of parameterized Node type.

 * @member data [A generic variable]
 * @param <T> [A parameterized variable called "next"]
 */
public class Node<T>
{
    private T data; 
    private Node<T> next;

    /**
     * Constructs an object to hold the data
     * and point to null as the next node.
     * @param theData [a generic object ]
     */
    public Node(T theData) 
    {
        this.data = theData;
        this.next = null;
    }

    /**
     * Constructs an object to hold the data
     * and point to another element as the next node.
     * @param theData           The data portion of this node which is a generic object
     * @param another       The node following this node which is an object of parameterized Node type.
     */
    public Node(T theData, Node<T> another) 
    {
        this.data = theData;
        this.next = another;
    }
    
    /**
     * Mutator method returns the data portion of the node.
     * @return
     */
    public T getData()
    {   return this.data; }

    /** 
     * Mutator method sets the next node.
     * @param another       The node following this node.
     */
    public void setNext(Node<T> another)
    {   this.next = another; }

    /**
     * Mutator method get the next node.
     * @return the next node
     */
    public Node<T> getNext()
    {   return this.next; }
    
    /**
     * String representation of the node as follows:
     * data
     */
    public String toString()
    {
        String result = "";
        result += this.data;
        return result;
    }
}


