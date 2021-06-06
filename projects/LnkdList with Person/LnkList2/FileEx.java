import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import org.junit.Assert;

/**
 * Write a description of class FileIOExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileEx
{
    public static final Random rnd = new Random();
     /**
      * A main to demonstrate that it works!
      */
    public static void main(String args[]) {
        try
        {
            writeText("int.txt"); //Creates 10 random ints and saves them to int.txt
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("Before Doubling: ");
        LnkdList<Integer> list1 = read("int.txt"); //create a LnkdList from the int.txt file created form writeText()
        var tmp2 = list1.getStart(); //getting a tmp variable to hold start
        
        do {
            System.out.println(tmp2.getData()); //printing the list before doubling
            tmp2 = tmp2.getNext();            
        } while (tmp2 != list1.getStart());
        
        System.out.println("\nAfter Doubling: ");
        LnkdList<Integer> list = readAndDouble("int.txt");
        var tmp = list.getStart();
        do {
            System.out.println(tmp.getData()); //printing the list after doubli
            tmp = tmp.getNext();
        } while (tmp != list.getStart());
        
        System.out.println(tmp2.getData() * 2 == tmp.getData());
    }
    
    /**
     * Creates a LnkdList of Integers from a file does not double them. 
     */
    public static LnkdList<Integer> read(String name) {
        LnkdList<Integer> numbers = new LnkdList<>();
        
        try
        {
            Files.lines(new File(name).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .map(s -> Integer.parseInt(s))
                    .forEach(s -> numbers.add(s));
                    
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return numbers;
    }

    /**
     * Creates a LnkdList of integers from a file and it doubles the integer values. 
     */
    public static LnkdList<Integer> readAndDouble(String name) {
        LnkdList<Integer> numbers = new LnkdList<>();
        
        try
        {
            Files.lines(new File(name).toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .map(s -> Integer.parseInt(s))
                    .forEach(s -> numbers.add(s * 2));
                    
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return numbers;
    }
    
    /**
     *writes 10 random ints to a file. 
     */
    public static void writeText(String name) throws IOException {
        try{
            PrintWriter fileout = new PrintWriter(new FileWriter(name));
            
            for (int i = 1; i <= 10; i++) {
                fileout.println(rnd.nextInt(100) +1);
            }
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    /**
     * writes ints currently in a LnkdList to a file. 
     */
    public static void writeInts(LnkdList<Integer> intList) throws IOException {
        var tmp = intList.getStart();
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("int.txt"));
            do {                    
                fileout.println(tmp.getData());
                    
                tmp = tmp.getNext();                    
            } while (tmp != intList.getStart());
                
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
