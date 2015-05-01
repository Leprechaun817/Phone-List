import java.io.*;
public class PhoneList implements Serializable
{
    private String name;
    private String phoneNum;

    public PhoneList(String n, String pn)
    {
        name = n;
        phoneNum = pn;
    }

    public void displayList()
    {
        System.out.println("Your friend's name is: " + name);
        System.out.println("Your friend's phone number is: " + phoneNum);
    }
}
