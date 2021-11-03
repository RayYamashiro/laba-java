import java.io.*;
import java.util.*;
import Forest.*;
import java.util.Date;
import modules_for_the_program.*;

public class Program
{
    public static void main (String [] args)
    {

        Prog a = new Prog();
        a.LogsFileCheckCreation();
        a.UserFileCheckCreation();
        a.LogsFileCheckFilling();
        a.UserFileCheckFilling();
        a.getFlagLogsFileNonEmpty();
        a.getFlagUsersFileNonEmpty();
        if (a.getFlagUsersFileNonEmpty() != true) {
            System.out.println("Нет пользователей,необходимо создание нового");
            User user = new User();
            user.CreateUser();
        }

    }
}
