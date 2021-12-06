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
        Settings s = new Settings();
        User user = new User();
        Date date = new Date();
        Predators p = new Predators();
        Herbivores h = new Herbivores();
        Grass g = new Grass();
        Trees t = new Trees();
        /*
        a.LogsFileCheckCreation();
        a.UserFileCheckCreation();
        a.LogsFileCheckFilling();
        a.UserFileCheckFilling();
        a.getFlagLogsFileNonEmpty();
        a.getFlagUsersFileNonEmpty();
        a.SettingFileCheckCreation();
        s.ReadFile(s);
        p.PredatorsReadDatabase();
        h.HerbivoresReadDatabase();
        g.GrassReadDatabase();
        t.TreesReadDatabase();
        if(s.getLogs() == true) {
            logs.WriteToLog("***** Начало работы программы  " + " " + date.toString() + " " + "*****" + " \n");
        }
        if(a.getFlagUsersFileNonEmpty() == false ) {
            user.CreateUser(user,s);
        }
        user.ReadDatabase();
        s.ReadFile(s);
        s.PrintSettingFile();
        a.EnterMenu(user,s);
        s.SettingMenu(user, s);
        while (true) {
            a.MainMenu(user , s ,p ,h ,g , t);
        }
        //user.CreateUser();
        //user.PrintToDatabase();
        //user.ReadDatabase();
        //System.out.println(user.toString());

         */
        // для Hashmap
        p.Laba4(10);
        p.Laba4(100);
        p.Laba4(1000);
        p.Laba4(10000);
        p.Laba4(100000);

        g.Laba4_list(10);
        g.Laba4_list(100);
        g.Laba4_list(1000);
        g.Laba4_list(10000);
        g.Laba4_list(100000);

    }
}
