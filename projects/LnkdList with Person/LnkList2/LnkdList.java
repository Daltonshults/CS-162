
/**
 * This Class links Nodes together to form a data structure that is circular
 * and doubly linked. You have access to prev and next. 
 *
 * @Dalton Shults
 * @V0.2
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
    
    /**
     * Adds to the end of the list. 
     * @param the data being appended to the end of the list. 
     */
    public boolean add(T t) {
         return addLast(t);    
    }
    
    /**
     * adds at a certain index within your list if index is out of range adds to the beginning of the list. 
     */
    public boolean add(int index, T data) {
        boolean ret = false;
        Node<T> node = new Node(data);
       
        if(index < size() && index >= 0) {
            
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
                ret = true;
            } else{               
                addFirst(data); 
                ret = true; //incrementing handled by method
            }
            
        } else {
            addFirst(data);
            ret = true;
        }
        return ret;
    }

    /**
     * Adds data to the front of the list.
     */
    public boolean addFirst(T data){
        boolean ret = false;
        Node<T> node = new Node(data);
        
        if(start != null) {
            Node<T> tmp = start.getPrev();
            
            start.setPrev(node);
            node.setPrev(tmp);
            
            tmp.setNext(node);
            node.setNext(start);
            ret = true;
        } else if (start == null) {
            node.setPrev(node);
            node.setNext(node);
            ret = true;
        }
        start = node;
        
        size += 1;
        return ret;
    }

    
    /**
     * Adds data to the end of the list. 
     */
    public boolean addLast(T data){
        boolean ret = false;
        Node<T> node = new Node(data);
        if (start == null) {
            start = node;
            start.setPrev(node);
            start.setNext(node);
            ret = true;
        } else {
            Node<T> tmp = start.getPrev();
            tmp.setNext(node);
            node.setPrev(tmp);
            node.setNext(start);
            start.setPrev(node);
            ret = true;
        }
        size += 1;
        return ret;
    }
    
    /**
     * returns the size of the linked list. 
     * @return the size of the list. 
     */
    public int size() {
        return size;    
    }
    
    public T remove(int index) {
        Node<T> tmp = null;
        
        if (size() == 0 || index < 0) {
            return null;
        } else if(size() == 1) {
            tmp = start;
            start = null;
            size = 0;
            return tmp.getData();
            
        } else if(index == 0) {
            tmp = start;
            
            removeFirst();
            
            size -= 1;
            
            return tmp.getData();
            
        }else {
            var rNode = getNode(index);
            tmp = rNode;
            
            var next = rNode.getNext();
            var prev = rNode.getPrev();
        
            next.setPrev(prev);
        
            prev.setNext(next);
            size -= 1;
            return tmp.getData();
        }
    }
    
    /**
     * Removes the first object from the list and returns it. 
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
     * removes the last Object from the list and returns it. 
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

    /**
     * Get's the object stored at the specific index. 
     * @param index of the Object that is being returned. 
     * @return the Object stored at the specific index is returned
     */
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
    
    /**
     * Gets the node at the specific index. 
     * @param the index of which node is returned
     * @return the node at a specific index. 
     */
    public Node<T> getNode(int index) {
        T data = null;
        Node<T>  tmp = start;

        if (index < size && index >= 0) {
            int count = 0;

            while (count < index) {
                tmp = tmp.getNext();
                count += 1;
            }

        }

        return tmp;
    }
    
    /**
     * Returns the data at the last node in the list. 
     * @return the data stored in the last node. 
     */
    public T getLast() {
        if (size > 1) {
            
            Node<T> tmp = start.getPrev();
            return tmp.getData();
            
        } else if (size == 1) {
            
            return start.getData();    
        }
        
        return null;
    }
    
    /**
     * Returns the data stored at the first item of the list. 
     * @return the data stored at the beginning of the list. 
     */
    public T getFirst() {
        if (size >= 1) {
            return start.getData();    
        } else return null; 
    }
    
    /**
     * clears the entire list and resets size back to 0.
     */
    public void clear() {
        start = null;
        size = 0;
    }
    
    /**
     * Checks to see if an object is contained within the linked list. 
     * @param the data that is being compared to every item in the list. 
     * @return if the data is contained return true else false. 
     */
    public boolean contains(T data) {
        var tmp = start;
        boolean isHere = false;
        
        do {
            if(tmp.getData().equals(data)) {
                isHere = true;
                return isHere;
            }
            
            tmp = tmp.getNext();
        } while (tmp != start);
        
        return isHere;
    }
    
    /**
     * Sets the data at a node at a specific index. 
     * @param the index of the object being modified. 
     * @param the data that is replacing the previous data. 
     */
    public boolean set(int index, T data) {
        boolean ret = false;
        
        if(index >= 0 && index < size()) {
            var tmp = getNode(index);
            tmp.setData(data);
            ret = true;
        }
        
        return ret;
    }

    /**
     * return the Node at start;
     */
    public Node<T> getStart() {
        return start;
    }

    
    /**
     * Returns a string representation of the LnkdList
     * @return a string representation of the LnkdList
     */
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
