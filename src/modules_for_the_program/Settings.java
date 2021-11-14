package modules_for_the_program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

public class Settings extends Prog {
    private boolean Logs;
    private boolean AutoTests;
    private Logs a = new Logs();
    public void setLogs(boolean temp_log)
    {
        this.Logs = temp_log;
    }
    public boolean getLogs()
    {
        return Logs;
    }
    public void setAutoTests(boolean autoTests)
    {
        this.AutoTests = autoTests;
    }
    public boolean getAutoTests()
    {
        return  AutoTests;
    }

    public Settings()
    {
        Logs = true;
        AutoTests = true;
    }

    public void ReadFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileSettings()))) {
            String line = reader.readLine();
            StringBuffer buffer = new StringBuffer(line);
            String LogsWord = "Logs:";
            boolean foundWordLog = Pattern.matches(LogsWord , buffer);
            if(foundWordLog == true)
            {
                buffer.delete(buffer.length() - LogsWord.length()-1 , buffer.length() ); // удаление из строки Logs:
                String newLine = buffer.toString();
                if(newLine == "true")
                {
                    setLogs(true);
                    System.out.println("Все прочитано начальника");
                }
                else if (newLine == "false")
                {
                    setLogs(false);
                    System.out.println("Мы в жопе");
                }
                else
                {
                    setLogs(true);
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать поле logs, быор поставлено значение true " + " " +  date.toString() + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PrintSettingFile()
    {

    }
}
