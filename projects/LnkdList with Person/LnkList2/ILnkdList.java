/**
 * Write a description of class ILnkdList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ILnkdList<T>
{
    T removeFirst();
    
    int size();
    
    T get(int index);
    
    boolean addLast(T item);
    
    boolean add(int index, T data);
    
    boolean add(T t);
    
    boolean addFirst(T data);
    
    T remove(int index);
    
    T removeLast();
    
    Node<T> getNode(int index);
    
    T getLast();
    
    T getFirst();
    
    void clear();
    
    boolean contains(T data);
    
    boolean set(int index, T data);
    
    Node<T> getStart();
}
