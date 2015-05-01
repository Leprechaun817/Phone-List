import java.io.*;
import java.util.Scanner;
public class DisplayNumbers
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        final int SIZE = 10;
        boolean finished = false;
        boolean found = false;
        int i;
        String answer;
        char ans;
        Scanner input = new Scanner(System.in);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("PhoneList.dat"));

        PhoneList[] pList = new PhoneList[10];

        try
        {
            for(i = 0; i < SIZE; i++)
            {
                pList[i] = new PhoneList("", "");
                pList[i] = (PhoneList)in.readObject();
            }
            
            while(finished == false)
            {
                System.out.println("Please enter the name of the person whose phone number you want to find.");
                answer = input.nextLine();

                
                for(i = 0; i < SIZE; i++)
                {
                    if(pList[i].getName().equals(answer))
                    {
                        found = true;
                        break;
                    }
                }

                if(found == true)
                {
                    System.out.println("We found the person your looking for");
                    System.out.println("The person's phone number is: " + pList[i].getPhoneNum());
                    found = false;
                }
                else
                {
                    System.out.println("We couldn't find who you were looking for...");
                    found = false;
                }


                System.out.println("Do you want to search for somebody else -- y or n");
                answer = input.nextLine();
                ans = answer.charAt(0);
                if(ans == 'n' || ans == 'N')
                {
                    finished = true;
                }
                else
                {}
            }
        }
        catch(EOFException e)
        {
            in.close();
        }
    }
}