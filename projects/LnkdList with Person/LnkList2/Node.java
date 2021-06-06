
/**
 * This class is used to store data in a LnkdList. Each node is connected to
 * two other nodes. A previous and a next node.
 *
 * @Dalton Shults
 * @0.2
 */
public class Node<T>
{
    private T data;
    private Node<T> next;
    private Node<T> prev;
    
    public Node(T data) {
        this.data = data;
        next = null;
        prev = null;
    }
    
    /**
     * Sets the the next Node in the list. 
     * @param a Node that is being assigned as the next Node. 
     */
    public void setNext(Node<T> node) {
        this.next = node;        
    }
    
    /**
     * Sets the previous Node in the list. 
     * @param the Node that is being assigned as the previous Node. 
     */
    public void setPrev(Node<T> node) {
        prev = node;
    }
    
    /**
     * Returns the stored within the node. 
     * @return the stored data. 
     */
    public T getData() {
     return data;    
    }
    
    /**
     * Returns the object stored at the next Node. 
     * @return the Node stored in next. 
     */
    public Node getNext() {
        return next;    
    }
    
    /**
     * Returns the node stored in the prev Node. 
     * @return the Node stored in prev. 
     */
    public Node getPrev() {
        return prev;    
    }
    
    /**
     * Allows access to change the data at a specific node of the LnkdList. 
     * @param the data that is replacing the old data. 
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Returns a true boolean if the next field is not null.
     * @return true if next field contains another node. v  
     */
    public boolean hasNext() {
        
        if (next != null) {
            return true;    
        }else {
            return false;
        }        
    }
}
