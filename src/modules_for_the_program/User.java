package modules_for_the_program;

import Forest.Animals;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User extends Prog {
    private String userName;
    private String password;
    private Status UserStatus;
    private HashMap<String, String> user_pass = new HashMap<String, String>();
    private HashMap<String, String> admin_pass = new HashMap<String, String>();
    private Logs log = new Logs();
    private boolean EnterUser = false;

    public User(String tempName, String tempPas, Status a)
    {
        userName = tempName;
        password = tempPas;
        UserStatus = a;
    }
    public User()
    {
    }
    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String temp_pas) {
        this.password = temp_pas;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_pass(HashMap temp) {
        user_pass = temp;
    }

    public Map getUser_pass() {
        return user_pass;
    }

    public void setAdmin_pass(HashMap temp) {
        admin_pass = temp;
    }

    public Map getAdmin_pass() {
        return admin_pass;
    }

    public Status getUserStatus() {
        return UserStatus;
    }

    public  void setUserStatus(Status a)
    {
        UserStatus = a;
    }

    public void  setEnterUser(boolean a)
    {
        EnterUser = a;
    }
    public boolean getEnterUser()
    {
        return  EnterUser;
    }

    public User CreateUser() {
        System.out.println("Введите login нового пользователя");
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            while (user_pass.containsKey(line) || admin_pass.containsKey(line)) {
                System.out.println("Такой пользователь существует, введите другой логин");
                line = reader.readLine();
            }
            setUserName(line);
            String pass;

            System.out.println("Введите пароль нового пользователя");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            pass = reader1.readLine();
            setPassword(pass);
            System.out.println("Какой уровень доступа у пользователя admin или user?");
            System.out.println("Для admin введите 1 , а для user 2");
            int key = Integer.parseInt(reader1.readLine());
            switch (key) {
                case (1):
                    System.out.println("Вы выбрали аdmin");
                    //System.out.println("Введите пароль для доступа к созданию admin");
                    //String pas_adm = reader1.readLine();
                    String pas_adm;

                    do {
                        System.out.println("Введите пароль для доступа к созданию admin");
                        pas_adm = reader1.readLine();
                        if (pas_adm.equals(admin_pas)) {

                            admin_pass.put(userName, password);
                            Date date = new Date();
                            log.WriteToLog("Создан пользователь с правами admin" + " " + getUserName() + " " + date.toString() + "\n");

                            User user =new User(userName , password , Status.Admin);
                            return user;
                        }
                        System.out.println("Пароль неверный. Попробуйте еще раз или создайте обычного пользователя");
                        System.out.println("Для создания обычного пользователя нажмите 1 , для продолжения попытки угадывания - любую другую цифру");
                        int key1 = Integer.parseInt(reader1.readLine());
                        if (key1 == 1) {
                            user_pass.put(userName, password);
                            Date date = new Date();
                            log.WriteToLog("Создан пользователь" + " " + getUserName() + " " + date.toString() + "\n");
                            User user =new User(userName , password , Status.User);
                            return user;
                        }
                    } while (!pas_adm.equals(admin_pas));


                    break;

                case (2):
                    user_pass.put(userName, password);
                    Date date = new Date();
                    log.WriteToLog("Создан пользователь" + " " + getUserName() + " " + date.toString() + "\n");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public void NewUser() {
        int flag = 0;  //флаг нужен для цикла, чтобы пользователь при ошибке ввода смог попробовать снова , при значении флага 1 программа считает, что вход выполнен
        int cancelEnter = 1; // флаг нужен для выхода из цикла, если пользователь больше не захотел пробовать ввести логин
        do {


            try {

                System.out.println("Введите login  пользователя");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String tempUserName = reader.readLine();
                if (user_pass.containsKey(tempUserName)) {
                    System.out.println("Введите пароль ");
                    String pass = reader.readLine();
                    if (admin_pass.containsValue(pass)) {
                        System.out.println("Произошел вход в учетную запись пользователя под логином " + tempUserName);
                        Date date = new Date();
                        log.WriteToLog("Произведен вход в учетную запись пользователя " + " " + tempUserName + " " + date.toString() + "\n");
                        flag = 1;
                    }
                } else if (admin_pass.containsKey(tempUserName)) {
                    System.out.println("Введите пароль ");
                    String pass = reader.readLine();
                    if (admin_pass.containsValue(pass)) {
                        System.out.println("Произошел вход в учетную запись админа  под логином " + tempUserName);
                        Date date = new Date();
                        log.WriteToLog("Произведен вход в учетную запись админа " + " " + tempUserName + " " + date.toString() + "\n");
                        reader.close();
                        flag = 1;
                    }
                } else {
                    System.out.println("Такого пользователя не существует. Хотите повторить попытку? Чтобы продолжить - нажмите на любую цифру. Для выхода нажмите 1");
                    cancelEnter = Integer.parseInt(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (flag != 1 || cancelEnter != 1);
    }
*/
    public void PrintToDatabase() {
        try {
            PrintWriter pw = new PrintWriter(getFileNameUsers());   // чистим все, что было в базе данных для корректной записи новой базы
            pw.close();
            // create new BufferedWriter for the output file
            BufferedWriter bf = new BufferedWriter(new FileWriter(getFileNameUsers(), true)); // для последовательной записи в файл

            // iterate map entries
            for (Map.Entry<String, String> entry :
                    user_pass.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"     // записываем в буфер
                        + entry.getValue());

                // new line
                bf.newLine();
            }

            bf.flush();  // запись в файл
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            // create new BufferedWriter for the output file
            BufferedWriter bf = new BufferedWriter(new FileWriter(getFileNameUsers(), true)); // для последовательной записи в файл
            bf.newLine();        // разделяем user и admin в базе данных
            bf.newLine();
            // iterate map entries
            for (Map.Entry<String, String> entry :
                    admin_pass.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"
                        + entry.getValue());

                // new line
                bf.newLine();
            }

            bf.flush();  // запись в файл
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileUser()))) {

            String line = reader.readLine();

            while (!line.isEmpty()) {

                String[] strings;
                String delimiter = ":"; //разделитель
                strings = line.split(delimiter);
                user_pass.put(strings[0], strings[1]);
                line = reader.readLine();
            }
            while(line.isEmpty())
            {
                line = reader.readLine();
            }
            while (line != null) {

                String[] strings;
                String delimiter = ":"; //разделитель
                strings = line.split(delimiter);
                admin_pass.put(strings[0], strings[1]);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException i)
        {
            return;
        }
    }

    public void ChangePassword(User user)
    {
        if(user_pass.containsKey(user.getUserName()))
        {
            if(user_pass.containsValue(user.getPassword()))
            {
                try {
                    System.out.println("Введите новый пароль");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String newPass = reader.readLine();
                    user_pass.put(user.getUserName(), newPass);
                    System.out.println("Пароль был изменен");
                    Date date = new Date();
                    log.WriteToLog("Был изменен пароль в учетной записи" + " " + user.getUserName() + " " + date.toString() + "\n");
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Такого пользователя нет");
            return;
        }
        if(admin_pass.containsKey(user.getUserName()))
        {
            if(admin_pass.containsValue(user.getPassword()))
            {
                try {
                    System.out.println("Введите новый пароль");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String newPass = reader.readLine();
                    admin_pass.put(user.getUserName(), newPass);
                    System.out.println("Пароль был изменен");
                    Date date = new Date();
                    log.WriteToLog("Был изменен пароль в учетной записи c уровнем доступа admin" + " " + user.getUserName() + " " + date.toString() + "\n");
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Такого пользователя нет");
                return;
            }
        }
    }
    public void ChangeLogin(User user)
    {
        if(user_pass.containsKey(user.getUserName()))
        {
            if(user_pass.containsValue(user.getPassword()))
            {
                try {
                    System.out.println("Введите новый login");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String newLog = reader.readLine();
                    String pass = user_pass.get(user.getUserName());
                    user_pass.remove(user.getUserName());
                    user_pass.put(newLog , pass);
                    System.out.println("Логин был изменен");
                    Date date = new Date();
                    log.WriteToLog("Был изменен логин в учетной записи" + " " + user.getUserName() + " "  + "новый логин-" + " " + newLog + date.toString() + "\n");
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Такого пользователя нет");
            return;
        }
        if(admin_pass.containsKey(user.getUserName()))
        {
            if(admin_pass.containsValue(user.getPassword()))
            {
                try {
                    System.out.println("Введите новый login");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String newLog = reader.readLine();
                    String pass = admin_pass.get(user.getUserName());
                    admin_pass.remove(user.getUserName());
                    admin_pass.put(newLog , pass);
                    System.out.println("Логин был изменен");
                    Date date = new Date();
                    log.WriteToLog("Был изменен логин в учетной записи c уровнем доступа admin" + " " + user.getUserName() + " "  + "новый логин-" + " " + newLog + date.toString() + "\n");
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Такого пользователя нет");
            return;
        }
    }
    public void PrintAllUsers()
    {
        ArrayList<String> values = new ArrayList<>(user_pass.keySet());
        System.out.println("Все пользователи с правом доступа user:" + " " + values);
        ArrayList<String> values1 = new ArrayList<>(admin_pass.keySet());
        System.out.println("Все пользователи с правом доступа admin:" + " " + values1);
    }
    public void DeleteUser(User user)
    {
        try {
            System.out.println("Вы хотите удалить свою учетную запись или другую? " +
                    "Для удаления своей учетной записи нажмите 1, для удаления чужой записи нажмите 2, если вы хотите оставить все как есть нажмите 0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int keySw = 0;
            String key = reader.readLine();
            do {
                switch (key) {
                    case("1"):
                        if(user.getUserStatus() == Status.Admin)
                        {
                            admin_pass.remove(user.getUserName());
                            System.out.println("Был удален пользователь" + user.getUserName() + " " + "Производится выход из программы");
                            Date date = new Date();
                            log.WriteToLog("Был удален пользователь c уровнем доступа admin" + " " + user.getUserName() + " " + date.toString() + "\n");
                        }
                        if(user.getUserStatus() == Status.User)
                        {
                            user_pass.remove(user.getUserName());
                            System.out.println("Был удален пользователь" + user.getUserName() + " " + "Производится выход из программы");
                            Date date = new Date();
                            log.WriteToLog("Был удален пользователь" + " " + user.getUserName() + " " + date.toString() + "\n");
                        }
                        System.exit(0);
                        break;
                    case("2"):
                        if(user.getUserStatus() == Status.Admin)
                        {
                            System.out.println("Введите login пользователя, которого вы хотите удалить");
                            String tempLog = reader.readLine();
                            if(user_pass.containsKey(tempLog))
                            {
                                user_pass.remove(user.getUserName());
                                System.out.println("Был удален пользователь" + user.getUserName() );
                                Date date = new Date();
                                log.WriteToLog("Был удален пользователь" + " " + user.getUserName() + " " + date.toString() + "\n");
                            }
                            if(admin_pass.containsKey(tempLog))
                            {
                                admin_pass.remove(user.getUserName());
                                System.out.println("Был удален пользователь с уровнем доступа admin" + user.getUserName() );
                                Date date = new Date();
                                log.WriteToLog("Был удален пользователь с уровнем доступа admin" + " " + user.getUserName() + " " + date.toString() + "\n");
                            }
                        }
                        else {
                            System.out.println("Вы не обладаете достаточным уровнем доступа к данной функции");
                            Date date = new Date();
                            log.WriteToLog("Была попытка удаления чужого аккаунта из учетной записи" + " " + user.getUserName() + " " + date.toString() + "\n");
                            break;
                        }
                        break;
                    case("0"):
                        keySw = 1;
                        break;
                    default:
                        System.out.println("Введено не то число");
                        break;
                }
            }while (keySw !=1);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public User EnterUser()
    {
        int flag = 0;
        do {
            try {
                System.out.println("Происходит вход в учетную запись. " + "\n" + "Введите login");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String tempLogin = reader.readLine();
                System.out.println("Введите пароль");
                String tempPas = reader.readLine();
                if (user_pass.containsKey(tempLogin) && user_pass.containsValue(tempPas)) {
                    System.out.println("Вход произведен в учетную запись" + tempLogin);
                    Date date = new Date();
                    log.WriteToLog("Выполнен вход в учетную запись" + " " + tempLogin + " " + date.toString() + "\n");
                    User user = new User(tempLogin, tempPas, Status.User);
                    EnterUser = true;
                    return user;
                } else if (admin_pass.containsKey(tempLogin) && admin_pass.containsValue(tempPas)) {
                    System.out.println("Вход произведен в учетную запись" + " " +  tempLogin);
                    Date date = new Date();
                    log.WriteToLog("Выполнен вход в учетную запись с уровнем доступа admin" + " " + tempLogin + " " + date.toString() + "\n");
                    User user = new User(tempLogin, tempPas, Status.Admin);
                    EnterUser = true;
                    return  user;
                } else {
                    System.out.println("Вход не был произведен. Возможна ошибка в логине / пароле или пользователь не существует." + "\n"
                                        + "Хотите попробовать снова? Если да - нажмите 1 , если вы хотите выйти из программы - нажмите любую другую цифру. ");
                    Date date = new Date();
                    log.WriteToLog("Выполнен вход в учетную запись  " + " " + tempLogin + " " + "не произведен"  + " " + date.toString() + "\n");
                    String flag1 = reader.readLine();
                    if(flag1.equals("1"))
                    {
                        flag = 0;
                    }
                    else
                    {
                        flag = 1;
                        System.exit(0);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (flag != 1);
        return null;
    }
}

enum Status {
    Admin,
    User
}
