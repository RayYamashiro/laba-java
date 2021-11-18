package Forest;

import modules_for_the_program.Logs;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Grass extends Plants
{
    private Logs l = new Logs();
    public Grass()
    {

    }
    public Grass(String name)
    {
        setPlant_name(name);
    }
    ArrayList<String> grass = new ArrayList<>();

    public void addGrass()
    {
        int flag = 0;
        try {
            while (flag != 1) {


                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String temp_name = reader.readLine();
                if (grass.equals(temp_name)) {
                    System.out.println("Такое растение уже существует. Попробуйте еще раз - для этого введите цифру 1. Чтобы выйти - выберите другую цифру ");
                }
                else{
                    grass.add(temp_name);
                    Date date = new Date();
                    l.WriteToLog("Добавлено новое растение типа Grass " + " " + temp_name + " " + date.toString() + "\n");
                }

            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void GrassReadDatabase()
    {
        try {
            if (getFileGrass().createNewFile()) {
                //System.out.println(" Файл логов создан");
            } else {
                //System.out.println("Файл логов уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileNameGrass()))) {

            String line = reader.readLine();

            while (!line.isEmpty()) {
                grass.add(line);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void GrassWriteDatabase()
    {
        try {
            FileWriter writer = new FileWriter(getFileNameGrass());
            for(String str: grass) {
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
}
