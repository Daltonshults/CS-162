
/**
 * Write a description of class RecursionEx here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecursionEx
{
    public static void main(String[] args) {
        String s = ex1("ABCDE");
        ex1(s);
        System.out.println(s);
        s = rev(s);
        System.out.println(s);
    }
    
    public static String ex1(String s) {
        String r = "";
        
        for(int i = s.length() - 1; i >= 0; i--) {
            r = r + s.charAt(i);
        }
        
        return r;    
    }
    
    public static String rev(String s) {
        if(s.length() < 2) return s;
        else{ 
            int len = s.length();
            return s.substring(len - 1) + rev(s.substring(0, len - 1));
        }
    }
}
