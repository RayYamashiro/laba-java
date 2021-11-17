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
        Logs logs = new Logs();
        Settings e = new Settings();
        User user = new User();
        Date date = new Date();
        logs.WriteToLog( "***** Начало работы программы + " +  " " + date.toString() +" " +  "*****" + " \n");
        a.LogsFileCheckCreation();
        a.UserFileCheckCreation();
        a.LogsFileCheckFilling();
        a.UserFileCheckFilling();
        a.getFlagLogsFileNonEmpty();
        a.getFlagUsersFileNonEmpty();
        a.SettingFileCheckCreation();
        e.ReadFile();
        if(a.getFlagUsersFileNonEmpty() == false ) {
            user.CreateUser();
        }
        user.ReadDatabase();
        e.ChangeSettingFile();
        //user.CreateUser();
        //user.PrintToDatabase();
        //user.ReadDatabase();
        //System.out.println(user.toString());
        /*
        if (a.getFlagUsersFileNonEmpty() != true) {
            System.out.println("Нет пользователей,необходимо создание нового");
            User user = new User();
            user.CreateUser();
        }

         */
        logs.WriteToLog( "***** Завершение работы программы + " +  " " + date.toString() + "*****" +"\n" + "\n" );
    }
}
