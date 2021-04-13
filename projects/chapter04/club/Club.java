import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> memberList; 
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        memberList = new ArrayList<>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(String name, int month, int year)
    {
        memberList.add(new Membership(name, month, year));
    }
    /**
     * Adds multiple members to the member
     */
    
    public void testMembers() {
        join("Jim", 11, 1990);
        join("Bob", 11, 1990);
        join("Kim", 12, 11966);
        join("Phil", 12, 1966);
        join("Bb", 11, 1990);
    }
    
    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return memberList.size();
    }
    
    /**
    * Determine the number of members who joined in the given
    * month.
    * @param month The month we are interested in.
    * @return The number of members who joined in that month.
    */
    public int joinedInMonth(int month) {
        int x = 0;
        if((month < 1) || (month > 12)) {
            System.out.println("The month you have entered is not valid.");
        }
        for(Membership member : memberList) {
            if(month == member.getMonth()) {
                x = x + 1;
                System.out.println("Member: " + member);
            }
        }
        return x;
    }
    
    public int example(int max) {
        int sum = 0;
        int counter = 1;
        while(sum < max) {
            sum += counter;
            counter += 1;
        }
        return counter;
    }
    
    /**
    * Remove from the club’s collection all members who
    * joined in the given month,
    * and return them stored in a separate collection object.
    * @param month The month of the membership.
    * @param year The year of the membership.
    * @return The members who joined in the given month and year.
    */
    public ArrayList<Membership> purge(int month, int year) {
        if((month < 1) || (month > 12)) {
            System.out.println("The month you have entered is not valid.");
        }
        //checking for valid month
        if(year < 1) {
            System.out.println("The year you have entered is not valid.");    
        }
        //checking for valid year// kind of
        var tempList = new ArrayList<Membership>(memberList);
        // creating a temporary ArrayList
        
        for(Membership member : tempList) { // iterating over that list
            if(month == member.getMonth() && year == member.getYear()) { // checking parameters against our memberList
                System.out.println("Member: " + member.getName() + " removed");
                memberList.remove(member); // Removing the member from the original list
            }
        }

        
        return memberList;     // returning original list
    }
}
