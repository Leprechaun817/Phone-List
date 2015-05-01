import java.io.*;
import java.util.Scanner;

public class CreatePhoneList
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("PhoneList.dat"));

        final int SIZE = 10;
        String[] names = new String[SIZE];
        String[] numbers = new String[SIZE];
        PhoneList[] pList = new PhoneList[SIZE];

        for(int i = 0; i < SIZE; i++)
        {
            int x = i + 1;
            System.out.println("Please enter friend #" + x + "'s name.");
            names[i] = input.nextLine();
            System.out.println("Please enter friend #" + x + "'s phone number.");
            numbers[i] = input.nextLine();
            System.out.print("\n");
        }

        for(int i = 0; i < SIZE; i++)
        {
            pList[i] = new PhoneList(names[i], numbers[i]);
            output.writeObject(pList[i]);
        }
        output.close();
    }
}
