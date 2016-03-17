package project08_team04;

import java.util.Iterator;


/**
 * 
 * @class LinkedList [contains a collection of generic Node objects and its size]
 * @implements the generic Iterable interface]
 * @param <T> [generic Node object]
 */
public class LinkedList<T> implements Iterable <T>
{
    // keeps track of the front of the list
    private Node<T> head;
    
    // keeps track of the number of nodes in the list
    private int size;

    /**
     *  Creates an new list that is empty.
     */
    public LinkedList()
    {
        this.head = null;
        this.size = 0;
    }

    /**
     * Checks if head is pointing to any node.
     */
    public boolean isEmpty()
    {
        // If head is not pointing to any nodes, then our list is empty.
        if (this.head == null)  
            return true;

        // Otherwise, there are one or more nodes in the list.
        return false;
    }

   /**
    *  adds new object to the end of the list
    * @param theData [a generic object]
    */
    public void add(T theData)
    {
       // create a node to hold our data
        Node<T> current = new Node<T>(theData);
        
        if (this.isEmpty())
        {
            head = current;
            this.size++;
            return;
        }
           Node<T> walker = head;
       
           while(walker.getNext() != null)
            {                  
                walker = walker.getNext(); 
            }
                walker.setNext(current);                
                this.size++;                         
    }
    
    /**
     * Checks if the data exists in the list
     * @param other         a generic object we are searching for 
     * @return boolean
     */
    public T contains(T other) 
    {
        Node<T> walker = this.head;

        while (walker != null)
        {   
//            T data = walker.getData();
            
            if (walker.getData().equals(other))                        
                return walker.getData(); 
            
            walker = walker.getNext();
        } 
        return null;
    }
    
    /**
     * Gets a node at a specific index.
     * @param index     The index after the start of the list.
     */
    public Node<T> getNodeAtIndex(int index)
    {
        Node<T> walker = this.head;
        
        int i = 0;

        while(walker != null && i <= index)
        {    
            if (i == index)              
                return walker;
          
            else
                walker = walker.getNext();
       
            i++;
        }
        return null;
    }
    
    /**
     * The number of nodes in the list. 
     */
    public int size() 
    {
        return this.size;
    }

    /**
     * Use an iterator to traverse the list of Country elements and display the contents of our list.
     * String representation of the list as follows:
     * [data_0, data_1, data_2]
     */
    public String toString() 
    {      
     // Uses a StringBuffer to concatenate strings
      StringBuilder listData = new StringBuilder();
    
      listData.append("[");
      
      Iterator<T> iterator = this.iterator();
        
        while (iterator.hasNext()) 
        {
            listData.append(iterator.next());
            
            if (iterator.hasNext() != false)
            {
                listData.append(","); 
            }
        }
        
        listData.append("]");
        
        return listData.toString();      
    }
    
    /**
     * create an iterator object that starts at beginning of the list
     */
    public Iterator<T> iterator() 
    {
        return new ListIterator();
    }
    
/**
 * @class ListIterator [to traverse the collection of objects in the list]
 *  @implements [generic Iterator interface]
 *
 */
  private class ListIterator implements Iterator<T> 
  {
      /**
       *  A generic field that keeps track of the current location being traversed.
       */
      private Node<T> current;
    
       public ListIterator()
       {  
          this.current = head;
        }
     
       // test if more elements can be traversed 
        public boolean hasNext()
        {
            // check if the next node is valid
            // if node is invalid, return false
            if(current == null)
                return false;
         
            // otherwise we haven't reached the end of the list
            else
            return true;        
        }

        // return the next available element        
        public T next()
        {
            // TODO Auto-generated method stub
            if (current == null)
            {
                throw new java.util.NoSuchElementException();
            }

            // if we're here, then we're looking at a valid current node
            // so grab the data portion, to give to the caller
            T data = current.getData();

            // move in preparation for the next time.
            current = current.getNext();

            return data;  
        }  

    }
}

