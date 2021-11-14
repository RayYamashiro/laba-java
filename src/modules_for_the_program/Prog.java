package modules_for_the_program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Prog
{
    private String fileName = "Logs.txt";
    private String fileNameSettings = "Settings.txt";
    private File fileSettings = new File(getFileNameSettings() );
    private File fileLogs = new File(getFileName());
    private boolean flagLogsFileNonEmpty;
    private String fileNameUsers = "Users.txt";
    private File fileUser = new File(getFileNameUsers());
    private boolean flagUsersFileNonEmpty;
    public  final  String admin_pas = "1111";
    public String getFileName()
    {
        return fileName;
    }
    public File getFileLogs() {
        return fileLogs;
    }
    public String getFileNameSettings ()
    {
        return fileNameSettings ;
    }
    public File getFileSettings() {
        return fileSettings;
    }
    public boolean getFlagLogsFileNonEmpty() {
        return flagLogsFileNonEmpty;
    }
    public void setFlagLogsFileNonEmpty(boolean temp) {
        this.flagLogsFileNonEmpty = temp;
    }

    public String getFileNameUsers()
    {
        return fileNameUsers;
    }
    public File getFileUser()
    {
        return fileUser;
    }
    public void setFlagUsersFileNonEmpty(boolean flag)
    {
        this.flagUsersFileNonEmpty = flag;
    }
    public boolean getFlagUsersFileNonEmpty()
    {
        return flagUsersFileNonEmpty;
    }

    public void LogsFileCheckCreation() {
        try {
            if (getFileLogs().createNewFile()) {
                System.out.println(" Файл логов создан");
            } else {
                System.out.println("Файл логов уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void LogsFileCheckFilling() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println(" Файл с логами найден, не пустой");
                setFlagLogsFileNonEmpty(true);
            } else if ((line = reader.readLine()) == null) {
                System.out.println("Файл с логами найден, пустой");
                setFlagLogsFileNonEmpty(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SettingFileCheckCreation() {
        try {
            if (getFileSettings().createNewFile()) {
                System.out.println(" Файл настроек создан");
            } else {
                System.out.println("Файл настроек уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void UserFileCheckFilling()
    {
        try (BufferedReader reader = new BufferedReader( new FileReader(getFileUser())))
        {
            String line;
            if ( (line = reader.readLine()) != null)
            {
                System.out.println(" Файл с пользователями найден , не пустой");
                setFlagUsersFileNonEmpty(true);
            }
            else if (( line = reader.readLine()) == null)
            {
                System.out.println("Файл с пользователями найден, пустой");
                setFlagUsersFileNonEmpty(false);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void UserFileCheckCreation ()
    {
        try
        {
            if (fileUser.createNewFile()) {
                System.out.println(" Файл с пользователями создан");
            } else {
                System.out.println("Файл с пользователями уже существует");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



}

