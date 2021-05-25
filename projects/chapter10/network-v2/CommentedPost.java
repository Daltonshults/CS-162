import java.util.ArrayList;

/**
 * Write a description of class CommentedPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommentedPost extends Post
{
    // instance variables - replace the example below with your own
    private int likes;
    private ArrayList<String> comments;
    /**
     * Constructor for objects of class CommentedPost
     */
    public CommentedPost(String author)
    {
        super(author);
        comments = new ArrayList<>();
        likes = 0;
    }
    
    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }
    
    /**
    * Record that a user has withdrawn his/her 'Like' vote.
    */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }
    
    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }
    
    @Override
    public void display() {
        //super.display();
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
}
