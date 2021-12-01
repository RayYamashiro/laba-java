package Forest;

import modules_for_the_program.Logs;
import modules_for_the_program.Settings;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Trees extends Plants
{
    private Logs l = new Logs();
    ArrayList<String> trees = new ArrayList<>();
    public Trees()
    {

    }
    public Trees(String name)
    {
        setPlant_name(name);
    }

    public void addTree(Settings s)
    {
        int flag = 0;
        try {
            while (flag != 1) {


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String temp_name = reader.readLine();
                if (trees.equals(temp_name)) {
                    System.out.println("Такое растение уже существует. Попробуйте еще раз - для этого введите цифру 1. Чтобы выйти - выберите другую цифру ");
                }
                else{
                    trees.add(temp_name);
                    if(s.getLogs() == true) {
                        Date date = new Date();
                        l.WriteToLog("Добавлено новое растение типа Trees " + " " + temp_name + " " + date.toString() + "\n");
                    }
                }

            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void TreesReadDatabase()
    {
        try {
            if (getFileTrees().createNewFile()) {
                //System.out.println(" Файл логов создан");
            } else {
                //System.out.println("Файл логов уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileNameTrees()))) {

            String line = reader.readLine();

            while (!line.isEmpty()) {
                trees.add(line);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void TreesWriteDatabase()
    {
        try {
            FileWriter writer = new FileWriter(getFileNameTrees());
            for(String str: trees) {
                writer.write(str + "\n");
            }
            writer.close();
        }catch (FileNotFoundException n)
        {
            n.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void PrintAllTrees()
    {
        System.out.println(trees.toString());
    }
}
