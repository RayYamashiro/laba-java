package modules_for_the_program;

import Forest.Animals;

import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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


    public void CreateUser() {
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
                            UserStatus = Status.Admin;
                            return;
                        }
                        System.out.println("Пароль неверный. Попробуйте еще раз или создайте обычного пользователя");
                        System.out.println("Для создания обычного пользователя нажмите 1 , для продолжения попытки угадывания - любую другую цифру");
                        int key1 = Integer.parseInt(reader1.readLine());
                        if (key1 == 1) {
                            user_pass.put(userName, password);
                            Date date = new Date();
                            log.WriteToLog("Создан пользователь" + " " + getUserName() + " " + date.toString() + "\n");
                            UserStatus = Status.User;
                            return;
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
    }

    public void EnterUser() {
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

    public void PrintToDatabase() {
        try {
            PrintWriter pw = new PrintWriter(getFileNameUsers());
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
}

enum Status {
    Admin,
    User
}
