package modules_for_the_program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Date;
import java.io.*;
import java.util.regex.Pattern;

public class Settings extends Prog {
    private boolean Logs;
    private boolean AutoTests;
    private Logs a = new Logs();
    private User u = new User();

    public void setLogs(boolean temp_log) {
        this.Logs = temp_log;
    }

    public boolean getLogs() {
        return Logs;
    }

    public void setAutoTests(boolean autoTests) {
        this.AutoTests = autoTests;
    }

    public boolean getAutoTests() {
        return AutoTests;
    }

    public Settings() {
        Logs = true;
        AutoTests = true;
    }

    public Settings ReadFile(Settings s) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileSettings()))) {
            String line = reader.readLine();
            String[] strings;
            String delimiter = ":"; //разделитель
            strings = line.split(delimiter); // разделение строки по разделителю
            if (strings[0].equals("Logs"))  // ищем параметр Logs
            {
                if (strings[1].equals("true")) {
                    s.Logs = true;
                } else if (strings[1].equals("false")) {
                    s.Logs = false;
                } else {
                    s.Logs = true;
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать параметр Logs " + " " + date.toString());
                }
            }
            String line1 = reader.readLine();
            String[] strings1;
            strings1 = line1.split(delimiter);
            if (strings1[0].equals("Autotests"))  // ищем параметр Logs
            {
                if (strings1[1].equals("true")) {
                    s.AutoTests = true;
                } else if (strings1[1].equals("false")) {
                    s.AutoTests = false;
                } else {
                    s.AutoTests = true;
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать параметр Autotests " + " " + date.toString());
                }
            }
        return  s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Settings ChangeSettingFile(User user, Settings s) {
        try {
            int flag = 1;
             if (user.getAdmin_pass().containsKey(user.getUserName())) {
                do {
                    System.out.println("Для изменения параметра Logs - напишите 1 , для изменения параметра Autotests напишите 2. Чтобы оставить все как есть напишите 0");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String line = reader.readLine();
                    switch(line)
                    {
                        case ("1"):
                            System.out.println("На какой параметр вы хотите заменить? Для выбора true нажмите 1. Для выбора false нажмите 2 ");
                            String key = reader.readLine();
                            switch (key)
                            {
                                case("1"):
                                    if (Logs == true)
                                    {
                                        System.out.println("Замена не нужна");
                                    }
                                    else
                                    {
                                        String newLine = "Logs:true";

                                        BufferedReader reader1 = new BufferedReader(new FileReader(getFileSettings()));
                                        String oldLine = reader1.readLine();
                                        StringBuilder sb = new StringBuilder(oldLine);
                                        sb.replace(0 , 12, newLine);
                                        String line2 = reader1.readLine();
                                        BufferedWriter bf = new BufferedWriter(new FileWriter(getFileSettings()));
                                        PrintWriter pw = new PrintWriter(getFileSettings());   // чистим все, что было в базе данных для корректной записи новой базы
                                        pw.close();
                                        bf.write(sb.toString());
                                        bf.newLine();
                                        bf.write(line2);
                                        bf.flush();
                                        s.Logs = true;
                                        Date date = new Date();
                                        a.WriteToLog("Изменение настройки Logs на true " + " " + date.toString() + "\n");
                                    }
                                    break;
                                case("2"):
                                    if (s.Logs == false)
                                    {
                                        System.out.println("Замена не нужна");
                                    }
                                    else
                                    {
                                        String newLine = "Logs:false";

                                        BufferedReader reader1 = new BufferedReader(new FileReader(getFileSettings()));
                                        String oldLine = reader1.readLine();
                                        StringBuilder sb = new StringBuilder(oldLine);
                                        sb.replace(0 , 12, newLine);
                                        String line2 = reader1.readLine();
                                        BufferedWriter bf = new BufferedWriter(new FileWriter(getFileSettings()));
                                        PrintWriter pw = new PrintWriter(getFileSettings());   // чистим все, что было в базе данных для корректной записи новой базы
                                        pw.close();
                                        bf.write(sb.toString());
                                        bf.newLine();
                                        bf.write(line2);
                                        bf.flush();
                                        s.Logs = false;
                                        Date date = new Date();
                                        a.WriteToLog("Изменение настройки Logs на false " + " " + date.toString() + "\n");
                                    }
                                    break;
                                default:
                                    System.out.println("Выбрана не та цифра");
                                    break;
                            }
                            break;

                        case("2"):
                            System.out.println("На какой параметр вы хотите заменить? Для выбора true нажмите 1. Для выбора false нажмите 2 ");
                            String key1 = reader.readLine();
                            switch (key1)
                            {
                                case("1"):
                                    if (s.AutoTests == true)
                                    {
                                        System.out.println("Замена не нужна");
                                    }
                                    else
                                    {
                                        String newLine = "Autotests:true";

                                        BufferedReader reader1 = new BufferedReader(new FileReader(getFileSettings()));
                                        String line2 = reader1.readLine();
                                        String oldLine = reader1.readLine();
                                        StringBuilder sb = new StringBuilder(oldLine);
                                        sb.replace(0 , 18, newLine);
                                        BufferedWriter bf = new BufferedWriter(new FileWriter(getFileSettings()));
                                        PrintWriter pw = new PrintWriter(getFileSettings());   // чистим все, что было в базе данных для корректной записи новой базы
                                        pw.close();
                                        bf.write(line2);
                                        bf.newLine();
                                        bf.write(sb.toString());
                                        bf.flush();
                                        s.AutoTests = true;
                                        Date date = new Date();
                                        a.WriteToLog("Изменение настройки Autotests на true " + " " + date.toString() + "\n");
                                    }
                                    break;
                                case("2"):
                                    if (s.AutoTests == false)
                                    {
                                        System.out.println("Замена не нужна");
                                    }
                                    else
                                    {
                                        String newLine = "Autotests:false";

                                        BufferedReader reader1 = new BufferedReader(new FileReader(getFileSettings()));
                                        String line2 = reader1.readLine();
                                        String oldLine = reader1.readLine();
                                        StringBuilder sb = new StringBuilder(oldLine);
                                        sb.replace(0 , 18, newLine);

                                        BufferedWriter bf = new BufferedWriter(new FileWriter(getFileSettings()));
                                        PrintWriter pw = new PrintWriter(getFileSettings());   // чистим все, что было в базе данных для корректной записи новой базы
                                        pw.close();
                                        bf.write(line2);
                                        bf.newLine();
                                        bf.write(sb.toString());
                                        bf.flush();
                                        s.AutoTests = false;
                                        Date date = new Date();
                                        a.WriteToLog("Изменение настройки Autotests на false " + " " + date.toString() + "\n");
                                    }
                                    break;
                                default:
                                    System.out.println("Выбрана не та цифра");
                                    break;
                            }

                            break;
                        case("0"):
                            flag = 0;
                            break;
                        default:
                            System.out.println("Выбрана не та цифра");
                            break;
                    }

                } while (flag != 0);
            } else {
                System.out.println("У Вас нет доступа к изменению файла настройки");
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return s;
    }

    public void PrintSettingFile() {
        System.out.println("Считывание файла настроек : " + "\n" + " Logs - " + " " + Logs + "\n" + "Autotests - " + " " + AutoTests + "\n");
    }

    public void SettingMenu(User user , Settings s)
    {
        try {
            PrintSettingFile();
            System.out.println("Хотите ли вы изменить настройки? Если да - выберите 1, если нет - выберите другую цифру" + "\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String l = reader.readLine();
            switch (l){
                case("1"):
                    if(user.getEnterUser() == false) {
                        user.EnterUser(user, s);
                    }
                    ChangeSettingFile(user , s);
                    break;
                default:
                    return;
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}