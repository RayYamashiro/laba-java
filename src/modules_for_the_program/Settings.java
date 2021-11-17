package modules_for_the_program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void ReadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileSettings()))) {
            String line = reader.readLine();
            String[] strings;
            String delimiter = ":"; //разделитель
            strings = line.split(delimiter); // разделение строки с по разделителю
            if (strings[0].equals("Logs"))  // ищем параметр Logs
            {
                if (strings[1].equals("true")) {
                    Logs = true;
                } else if (strings[1].equals("false")) {
                    Logs = false;
                } else {
                    Logs = true;
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
                    AutoTests = true;
                } else if (strings1[1].equals("false")) {
                    AutoTests = false;
                } else {
                    AutoTests = true;
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать параметр Autotests " + " " + date.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ChangeSettingFile() {
        try {
            int flag = 1;
           // if (u.getUserStatus() == Status.Admin) {
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
                                    boolean temp_log = true;
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
                                        Date date = new Date();
                                        a.WriteToLog("Изменение настройки Logs на true " + " " + date.toString() + "\n");
                                    }
                                    break;
                                case("2"):

                                    break;
                                default:
                                    System.out.println("Выбрана не та цифра");
                                    break;
                            }
                            break;

                        case("2"):

                            break;
                        case("0"):
                            flag = 0;
                            break;
                        default:
                            System.out.println("Выбрана не та цифра");
                            break;
                    }

                } while (flag != 0);
            //} else {
            //    System.out.println("У Вас нет доступа к изменению файла настройки");
            //}
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void PrintSettingFile() {
        System.out.println("Считывание файла настроек : " + "\n" + " Logs - " + " " + Logs + "\n" + "Autotests - " + " " + AutoTests);
    }
}