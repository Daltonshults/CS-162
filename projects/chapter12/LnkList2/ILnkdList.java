/**
 * Write a description of class ILnkdList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ILnkdList<T>
{
    //void addFirst(T item);
    
    T removeFirst();
    
    int size();
    
    T get(int index);
    
    void addLast(T item);
}
