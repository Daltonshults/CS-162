
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public void setNext(Node<T> node) {
        this.next = node;        
    }
    
    public void setPrev(Node<T> node) {
        prev = node;
    }
    
    public T getData() {
     return data;    
    }
    
    public Node getNext() {
        return next;    
    }
    
    public Node getPrev() {
        return prev;    
    }
    
    public boolean hasNext() {
        if (next != null) {
            return true;    
        }else {
            return false;
        }
        
    }
}
