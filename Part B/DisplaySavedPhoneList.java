import java.io.*;

public class DisplaySavedPhoneList
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        final int SIZE = 10;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("PhoneList.dat"));
        PhoneList[] pList = new PhoneList[SIZE];

        try
        {
            for(int i = 0; i < SIZE; i++)
            {
                pList[i] = new PhoneList("", "");
                pList[i] = (PhoneList)in.readObject();
                pList[i].displayList();
            }
        }
        catch(EOFException e)
        {
            in.close();
        }
    }
}