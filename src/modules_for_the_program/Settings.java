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
            String [] strings;
            String delimiter = ":" ; //разделитель
            strings = line.split(delimiter); // разделение строки с по разделителю
            if(strings[0].equals("Logs"))  // ищем параметр Logs
            {
                if(strings[1].equals("true"))
                {
                    Logs = true;
                }
                else if(strings[1].equals("false"))
                {
                    Logs = false;
                }
                else
                {
                    Logs = true;
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать параметр Logs " + " " + date.toString());
                }
            }
            String line1 = reader.readLine();
            String [] strings1;
            strings1 = line1.split(delimiter);
            if(strings1[0].equals("Autotests"))  // ищем параметр Logs
            {
                if(strings1[1].equals("true"))
                {
                    AutoTests = true;
                }
                else if(strings1[1].equals("false"))
                {
                    AutoTests = false;
                }
                else
                {
                    AutoTests = true;
                    Date date = new Date();
                    a.WriteToLog("Невозможно считать параметр Autotests " + " " + date.toString());
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
