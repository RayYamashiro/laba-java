package Forest;

import modules_for_the_program.Logs;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Herbivores extends Animals
{
    ArrayList<String> edible = new ArrayList<String>();
    ArrayList<String> non_edible = new ArrayList<String>();
    private Map<String, Integer> herbivores = new HashMap<String, Integer>();
    private Logs log = new Logs();
    public Herbivores(String name , int size)
    {
        setAnim_name(name);
        setAnim_size(size);
    }
    public Herbivores()
    {
    }
    public void addEdiblePlant (Plants a) // можно писать вместо trees plants так как он является суперклассом для дерева
    {
        edible.add(a.getPlant_name());
    }
    public void setHerbivores(HashMap temp) {
        herbivores= temp;
    }

    public Map getHerbivores() {
        return herbivores;
    }
    public void addNonEdiblePlant (Trees a )
    {
        non_edible.add(a.getPlant_name());
    }

    public void checkEdibilityPlant (Trees a)
    {
        if(edible.contains(a.getPlant_name()) == true)
        {
            System.out.println("Растение съедобное");
            System.out.println("Происходит уничтожение растения");
            a = null;
        }
        else
            System.out.println("Растение несъедобное");
    }

    public void addEdiblePlant (Grass a )
    {
        edible.add(a.getPlant_name());
    }
    public void addNonEdiblePlant (Grass a )
    {
        non_edible.add(a.getPlant_name());
    }

    public void checkEdibilityPlant (Grass a)
    {
        if(edible.contains(a.getPlant_name()) == true)
        {
            System.out.println("Растение съедобное");
            System.out.println("Происходит уничтожение растения");
            a = null;
        }
        else
            System.out.println("Растение несъедобное");
    }

    public void CreateHerbivores()
    {
        System.out.println("Введите название нового травоядного");
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            while (herbivores.containsKey(line) ) {
                System.out.println("Такое животное существует, введите другое имя");
                line = reader.readLine();
            }
            setAnim_name(line);


            System.out.println("Введите размер нового животного цифрами");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            int size = parseInt(reader1.readLine());
            setAnim_size(size);
            herbivores.put(line, size);
            Date date = new Date();
            log.WriteToLog("Создано животное типа Herbivores" + " " + getAnim_name() + " " + date.toString() + "\n");
        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (NumberFormatException n)
        {
            System.out.println("Неверно написан размер животного");
        }
    }

    public void HerbivoresReadDatabase() {
        try {
            if (getFileHerbivores().createNewFile()) {
                //System.out.println(" Файл логов создан");
            } else {
                //System.out.println("Файл логов уже существует");
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(getFileNameHerbivores()))) {

                String line = reader.readLine();

                while (!line.isEmpty()) {

                    String[] strings;
                    String delimiter = ":"; //разделитель
                    strings = line.split(delimiter);
                    herbivores.put(strings[0], parseInt(strings[1]));
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException i) {
                return;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HerbivoresWriteDatabase()
    {
        try {
            PrintWriter pw = new PrintWriter(getFileNamePredators());   // чистим все, что было в базе данных для корректной записи новой базы
            pw.close();
            // create new BufferedWriter for the output file
            BufferedWriter bf = new BufferedWriter(new FileWriter(getFileNameHerbivores(), true)); // для последовательной записи в файл

            // iterate map entries
            for (Map.Entry<String, Integer> entry :
                    herbivores.entrySet()) {

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
    }
    public void PrintAllHerbivores() {
        ArrayList<String> values = new ArrayList<>(herbivores.keySet());
        System.out.println("Все животные типа Herbivores:" + " " + values);
    }
}
