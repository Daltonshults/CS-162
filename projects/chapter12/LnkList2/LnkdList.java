
/**
 * Write a description of class LnkdList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LnkdList<T> implements ILnkdList<T>
{
    private Node<T> start;
    private int size;

    /**
     * Constructor for objects of class LnkdList
     */
    public LnkdList() {
        start = null;
        size = 0;
    }
    
    public void add(T t) {
        addFirst(t);    
    }
    
    /**
     * adds at a certain index within your list if index is out of range adds to the beginning of the list. 
     */
    public void add(int index, T data) {
        Node<T> node = new Node(data);
       
        if(index < size && index >= 0) {
            
            if(size >= 1 && index > 0) {
                Node<T> tmp = start;
                Node<T> tmp2 = start.getNext(); 
                
                for (int i = 1; i < index; i += 1) {
                    tmp = tmp.getNext();
                    tmp2 = tmp2.getNext();
                }
                
                tmp2.setPrev(node);
                tmp.setNext(node);
                node.setPrev(tmp);
                node.setNext(tmp2);
                
                size += 1;                
            } else{               
                addFirst(data);    //incrementing handled by method
            }
            
        } else {
            addFirst(data);    
        }
    }

    /**
     * Adds data to the front of the list.
     */
    public void addFirst(T data){
        Node<T> node = new Node(data);
        
        if(start != null) {
            Node<T> tmp = start.getPrev();
            start.setPrev(node);
            node.setPrev(tmp);
            tmp.setNext(node);
            node.setNext(start);
        } else if (start == null) {
            node.setPrev(node);
            node.setNext(node);
            
        }
        //node.setNext(start);
        start = node;
        
        size += 1;
    }

    
    /**
     * Adds data to the end of the list. 
     */
    public void addLast(T data){
        Node<T> node = new Node(data);
        if (start == null) {
            start = node;
            start.setPrev(node);
            start.setNext(node);
        } else {
            Node<T> tmp = start.getPrev();
            tmp.setNext(node);
            node.setPrev(tmp);
            node.setNext(start);
            start.setPrev(node);

        }
        size += 1;
    }

    public int size() {
        return size;    
    }
    
    /**
     * Removes the first object from the list. 
     */
    public T removeFirst(){
        Node<T> tmp;
        Node<T> tmp2 = null;
        
        
        if(size > 1) {
            tmp = start.getNext();
            Node<T> tmp3 = start.getPrev();
            
            tmp.setPrev(tmp3);
            tmp3.setNext(tmp);
            
            tmp2 = start;
            start = tmp;
            
            size -= 1;
            
            return tmp2.getData();
        } else if (size == 1)  {
            tmp = start;
            start = null;
            size -= 1;
            return tmp.getData();
        }
        

        return null;
    }
    
    /**
     * removes the last Object from the list. 
     */
    public T removeLast() {
        if (size > 1) {
            Node<T> tmp = start.getPrev();
            Node<T> tmp2 = tmp.getPrev();
            
            start.setPrev(tmp2);
            tmp2.setNext(start);
            
            size -= 1;
            
            return tmp.getData();
        } else if (size == 1) {
            Node<T> tmp = start;
            
            start = null;
            size -= 1;
            
            return tmp.getData();
        }
        
        return null;
    }
    
    // /**
     // * removes the last Object from the list. 
     // */
    // public T removeLastORIGINAL() {
        // Node<T> tmp = start;
        
        // if(start != null & start.getNext() != null) {            
            // while(tmp.getNext() != null) {
                // tmp = tmp.getNext();
                
                // if(tmp.getNext() == null) {
                    // Node<T> tmp2 = tmp.getPrev();
                    // tmp2.setNext(null);
                    // tmp.setPrev(null);
                    // return tmp.getData();
                // }
            // }
        // } else if(start != null && start.getNext() == null) {
            // start = null;
            // return tmp.getData();
        // }
        // return null;
    // }
    

    public T get(int index) {
        T data = null;

        if (index < size && index >= 0) {
            Node<T>  tmp = start;
            int count = 0;

            while (count < index) {
                tmp = tmp.getNext();
                count += 1;
            }

            data = tmp.getData();
        }

        return data;
    }
    
    public T getLast() {
        if (size > 1) {
            Node<T> tmp = start.getPrev();
            return tmp.getData();    
        } else if (size == 1) {
            return start.getData();    
        }
        
        return null;
    }
    
    public T getFirst() {
        if (size >= 1) {
            return start.getData();    
        } else return null; 
    }
    
    public void clear() {
        start = null;
        size = 0;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();  
        Node<T> temp = start; 

        while (temp != null) {
            sb.append(temp.getData() + " ");
            temp = temp.getNext();
        }

        return sb.toString();
    }
}
