/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;
    private boolean courseText;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int numberOfPages, boolean bookCourseText)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = numberOfPages;
        refNumber = "";
        borrowed = 0;
        courseText = bookCourseText;
    }
    
    /**
     * Returns the author field
     */
    public boolean isCoursetext()
    {
        return courseText;
    }
    
    
    /**
     * Returns the author field
     */
    public void borrowed()
    {
        //int borrowNumber = borrowed;
        borrowed = borrowed + 1;
    }
    
    /**
     * Returns the author field
     */
    public int getBorrowed()
    {
        return borrowed;
    }
    
    /**
     * Set the refNumber field
     */    
    public void setReferenceNumber(String ref)
    {
        if(ref.length() > 2){
            refNumber = ref;
        }
        else{
            System.out.println("Your reference number needs to be at least 3 characters");
            refNumber = "";
        }
    }
    
    /**
     * Returns the ref field
     */
    public String getRefNumber()
    {
        return refNumber;
    }  
    
    /**
     * Returns the author field
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Returns the title field
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Returns the pages field
     */
    public int getPages()
    {
        return pages;
    }
    
    /**
     * Prints the author
     */
    public void printAuthor()
    {
        System.out.println(author);
    }
    
    /**
     * Prints the author
     */
    public void printTitle()
    {
        System.out.println(title);
    }
    
    /**
     * Prints all  the details of the book
     */
    public void printDetails()
    {
        String noRef = "zzz";        
        if(refNumber.length() > 0){
            noRef = refNumber;
        }
        System.out.println("Title : " + title + ", Author: " + author + ", Pages: " + pages);
        System.out.println("Reference #: " + noRef);
        System.out.println("This book has been borrowed " + borrowed + " times");
    }

    // Add the methods here ...
}
