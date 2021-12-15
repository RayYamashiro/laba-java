package Forest;

import modules_for_the_program.Logs;
import modules_for_the_program.Settings;

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
    public ArrayList getGrass() {
        return grass;
    }
    public void addGrass(Settings s)
    {
        int flag = 0;
        try {
            while (flag != 1) {

                System.out.println("Введите название травы");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String temp_name = reader.readLine();
                if (grass.equals(temp_name)) {
                    System.out.println("Такое растение уже существует. Попробуйте еще раз - для этого введите цифру 1. Чтобы выйти - выберите другую цифру ");
                }
                else{
                    grass.add(temp_name);
                    if(s.getLogs()== true) {
                        Date date = new Date();
                        l.WriteToLog("Добавлено новое растение типа Grass " + " " + temp_name + " " + date.toString() + "\n");
                        flag = 1;
                    }
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
                line = reader.readLine();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException i) {
            return;
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
    public void PrintAllGrass()
    {
        System.out.println("Все растения типа Grass:" + " " + grass.toString());
    }

    public void Laba4_list(int count)
    {
        ArrayList<Integer> same_number = new ArrayList<>();
        Date date = new Date();
        Grass p = new Grass();
        String str = "";
        String filename = "test_list"+count+".txt";
        StringBuffer strBuffer = new StringBuffer(str);
        String str0 = ( "Start program" + " " + date.toString()  + "\n" + "HashMap" + "\n" );
        strBuffer.append(str0);

        int total_count = count;
        long totalTime = 0;
        long estimatedTime = 0;
        //long all_time = 0;

        for(int i =0 ; i < total_count ; i++)
        {
            int temp_number = (int) (Math.random()*1000000);
            estimatedTime = System.nanoTime();
            int str4 =temp_number;
            p.getGrass().add(str4);
            //long av = System.nanoTime() - startTime;
            //all_time += av;
            estimatedTime = System.nanoTime() - estimatedTime;
            totalTime = totalTime + estimatedTime;
            String str2 = str + "add ID = " + i  + ", " + estimatedTime + "\n" ;
            strBuffer.append(str2);
        }

        strBuffer.append("addTotalCount" + " " + total_count + "\n" );
        strBuffer.append("addTotalTime " + totalTime + "\n");
        long finish1 = totalTime/total_count;
        strBuffer.append( "addMedianTime " + finish1 + "\n" + "\n");
        //all_time = 0;
        estimatedTime = 0;

        int total_remove = (int) total_count / 10;
        long totalTime1 = 0;
        for(int i =0 ; i < total_remove; i++)
        {

            int temp_number = (int) (Math.random()*total_count-1);

            if(same_number.contains(temp_number))
            {
                i--;
                continue;
            }
            long startTime = System.nanoTime();
            same_number.add(temp_number);
            estimatedTime = System.nanoTime();
            //long avm = System.nanoTime() - startTime;
            int id = (int) p.getGrass().get(temp_number);
            String str4 = temp_number + "";
            p.getGrass().remove(str4);
            //long av = System.nanoTime() - startTime ;
            //all_time += av;
            estimatedTime = System.nanoTime() - estimatedTime;
            totalTime1 = totalTime1 + estimatedTime;
            String str2 = str + "remove ID = " + temp_number  + ", " + estimatedTime + "\n" ;
            strBuffer.append(str2);
        }
        //long tot1 = System.nanoTime() - totalTime1;
        //estimatedTime = System.nanoTime() - startTime;
        strBuffer.append("removeTotalCount" + " " + total_remove + "\n" );
        strBuffer.append("removeTotalTime " + totalTime1 + "\n");
        //long finish = all_time/total_remove;
        strBuffer.append("removeMedianTime " + totalTime1/total_remove + "\n" + "\n");

        String str10 = ( "Finish program" + " " + date.toString()  + "\n");

        strBuffer.append(str10);
        try {
            FileWriter writer = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(filename);   // чистим все, что было в базе данных для корректной записи новой базы
            pw.close();
            //BufferedWriter bf = new BufferedWriter(new FileWriter("test10.txt", true));
            writer.write(strBuffer.toString());
            writer.flush();
        }catch (FileNotFoundException e)
        {
            try {
                File file10 = new File(filename);
                file10.createNewFile();
            }catch (IOException er)
            {
                er.printStackTrace();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
