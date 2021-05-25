
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String ID;
    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String ID)
    {
        this.name = name;
        this.ID = ID;
    }
    
    public String getName() {
        return name;    
    }
    
    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }
    
    public String getID() {
        return ID;    
    }
    
    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        int logInNameLength = 4;
        int loginIdLength = 3;
        int nameLength = name.length();
        int idLength = ID.length();

        if(nameLength <= 4){
            logInNameLength = nameLength;
        }
        if(idLength <= 3){
            idLength = idLength;
        }

        return name.substring(0,logInNameLength) + ID.substring(0,idLength);
    }
}
