import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import Forest.*;
import java.io.BufferedReader;
import java.io.File;
public class Program
{
    public static void main (String [] args)
    {
        boolean flagLogsFileNonEmpty ;
        boolean flagUsersFileNonEmpty;
        String fileName = "Logs.txt";
        String fileNameUsers = "Users.txt";
        File fileLogs = new File(fileName);  // работа по созданию или проверки существования файла с логами программы
        try (BufferedReader reader = new BufferedReader( new FileReader(fileName)))
        {
            String line;
            if ( (line = reader.readLine()) != null)
            {
                System.out.println(" File with logs found , non empty");
                flagLogsFileNonEmpty = true;
            }
            else if (( line = reader.readLine()) == null)
            {
                System.out.println("File with users found , empty");
                flagLogsFileNonEmpty = false;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        File fileUser = new File(fileNameUsers);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameUsers)))
        {
            String line ;
            if ( (line = reader.readLine()) != null)
            {
                System.out.println("File with users found , non empty");
                flagUsersFileNonEmpty = true;
            }
            else if ( (line = reader.readLine()) == null)
            {
                System.out.println("File with users found , empty");
                flagUsersFileNonEmpty = false;
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Forest.Herbivores a = new Forest.Herbivores("fff" , 12);
        Predators b = new Predators("dd" , 18);
        //b.anihilationAnimals(b , a);
        Grass m = new Grass ("Трава") ;
        a.addEdiblePlant(m);
        a.checkEdibilityPlant(m);
    }
}
