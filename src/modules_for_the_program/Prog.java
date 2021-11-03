package modules_for_the_program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Prog
{
    private String fileName = "Logs.txt";
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
                System.out.println(" Файл создан");
            } else {
                System.out.println("Файл  уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void LogsFileCheckFilling() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println(" File with logs found , non empty");
                setFlagLogsFileNonEmpty(true);
            } else if ((line = reader.readLine()) == null) {
                System.out.println("File with users found , empty");
                setFlagLogsFileNonEmpty(false);
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
                System.out.println(" File with logs found , non empty");
                setFlagUsersFileNonEmpty(true);
            }
            else if (( line = reader.readLine()) == null)
            {
                System.out.println("File with users found , empty");
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
                System.out.println(" Файл создан");
            } else {
                System.out.println("Файл  уже существует");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

