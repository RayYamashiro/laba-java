package modules_for_the_program;

import Forest.Grass;
import Forest.Herbivores;
import Forest.Predators;
import Forest.Trees;

import java.io.*;
import java.util.Date;

public class Prog {
    private String fileName = "Logs.txt";
    private String fileNameSettings = "Settings.txt";
    private File fileSettings = new File(getFileNameSettings());
    private File fileLogs = new File(getFileName());
    private boolean flagLogsFileNonEmpty;
    private String fileNameUsers = "Users.txt";
    private File fileUser = new File(getFileNameUsers());
    private boolean flagUsersFileNonEmpty;
    //private Logs a = new Logs();

    //private Predators p = new Predators();




    public final String admin_pas = "1111";

    public String getFileName() {
        return fileName;
    }

    public File getFileLogs() {
        return fileLogs;
    }

    public String getFileNameSettings() {
        return fileNameSettings;
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

    public String getFileNameUsers() {
        return fileNameUsers;
    }

    public File getFileUser() {
        return fileUser;
    }

    public void setFlagUsersFileNonEmpty(boolean flag) {
        this.flagUsersFileNonEmpty = flag;
    }

    public boolean getFlagUsersFileNonEmpty() {
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


    public void UserFileCheckFilling() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileUser()))) {
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println(" Файл с пользователями найден , не пустой");
                setFlagUsersFileNonEmpty(true);
            } else if ((line = reader.readLine()) == null) {
                System.out.println("Файл с пользователями найден, пустой");
                setFlagUsersFileNonEmpty(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UserFileCheckCreation() {
        try {
            if (fileUser.createNewFile()) {
                System.out.println(" Файл с пользователями создан");
            } else {
                System.out.println("Файл с пользователями уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EnterMenu(User user) {
        int flag = 0;
        while (flag != 1) {
            try {
                System.out.println("Вход в учетную запись.............1" + "\n"
                        + "Выход из программы................2" + "\n");

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String l = reader.readLine();
                switch (l) {
                    case ("1"):
                        user.EnterUser();
                        flag = 1;
                        break;
                    case ("2"):
                        Date date = new Date();
                        Logs a = new Logs();
                        a.WriteToLog("***** Завершение работы программы + " + " " + date.toString() + "*****" + "\n" + "\n");
                        System.exit(0);
                        break;
                    default:
                        flag = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void MainMenu(User u)
    {
        int flag = 0;

        while (flag != 1) {
            try
            {
                System.out.println("Сменить пароль....................1" + "\n"
                                 + "Сменить логин.....................2" + "\n"
                                 + "Добавить пользователя.............3" + "\n"
                                 + "Добавить хищника..................4" + "\n"
                                 + "Добавить травоядное...............5" + "\n"
                                 + "Добавить дерево...................6" + "\n"
                                 + "Добавить траву....................7" + "\n"
                                 + "Вывод всех пользователей..........8" + "\n"
                                 + "Вывод всех объектов...............9" + "\n"
                                 + "Пожирание травоядного.............10" + "\n"
                                 + "Удаление пользователя.............11" + "\n"
                                 + "Выход из программы................12" + "\n"
                );
                Predators p = new Predators();
                Herbivores h = new Herbivores();
                Grass g = new Grass();
                Trees t = new Trees();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int flag1 = 0;
                while(flag1 != 1) {
                    String l = reader.readLine();
                    switch (l) {
                        case ("1"):
                            u.ChangePassword(u);
                            break;
                        case ("2"):
                            u.ChangeLogin(u);
                            break;
                        case ("3"):
                            u.CreateUser();
                            break;
                        case ("4"):

                            p.CreatePredator();
                            break;
                        case ("5"):
                            h.CreateHerbivores();
                            break;
                        case ("6"):
                            t.addTree();
                            break;
                        case ("7"):
                            g.addGrass();
                            break;
                        case ("8"):
                            u.PrintAllUsers();
                            break;
                        case ("9"):

                            p.PrintAllPredators();
                            System.out.println("\n");
                            h.PrintAllHerbivores();
                            System.out.println("\n");
                            t.PrintAllTrees();
                            System.out.println("\n");
                            g.PrintAllGrass();
                            System.out.println("\n");
                            break;
                        case ("10"):
                            p.anihilationAnimals();
                            break;
                        case ("11"):
                            u.DeleteUser(u);
                        case ("12"):
                            Logs logs = new Logs();
                            Date date = new Date();
                            logs.WriteToLog("***** Завершение работы программы + " + " " + date.toString() + "*****" + "\n" + "\n");
                            System.exit(0);
                    }
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

}

