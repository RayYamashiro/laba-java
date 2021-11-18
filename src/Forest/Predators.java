package Forest;

import modules_for_the_program.Logs;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Predators extends Animals
{
    private Map<String, Integer> predators = new HashMap<String, Integer>();
    private Map<String, Integer> herbivores = new HashMap<String, Integer>();
    //private Herbivores h = new Herbivores();
    private Logs log = new Logs();
    public Predators()
    {
    }
    public Predators(String name , Integer size)
    {
        setAnim_name(name);
        setAnim_size(size);
    }
    public void setPredators(HashMap temp) {
        predators= temp;
    }

    public Map getPredators() {
        return predators;
    }
    public void anihilationAnimals ()
    {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите название хищника");
            line = reader.readLine();
            if (predators.containsKey(line)) {
                System.out.println("Введите название травоядного");
                String line1 = reader.readLine();
                if (herbivores.containsKey(line)) {
                    if(predators.get(line) > herbivores.get(line1))
                    {
                        System.out.println("Произошло уничтожение травоядного.");
                        herbivores.remove(line1);
                        Date date = new Date();
                        log.WriteToLog("Произошло уничтожение травоядного" + " " + line1 + " " + date.toString() + "\n");
                    }
                    else
                        System.out.println("Размер хищника равен или меньше размера травоядного. Уничтожения не произошло.");
                }else
                    System.out.println("Такого травоядного нет");
            }
            else
                System.out.println("Такого хищника нет");
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void CreatePredator()
    {
        System.out.println("Введите название нового хищника");
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            while (predators.containsKey(line) ) {
                System.out.println("Такое животное существует, введите другое имя");
                line = reader.readLine();
            }
            setAnim_name(line);


            System.out.println("Введите размер нового животного цифрами");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            int size = parseInt(reader1.readLine());
            setAnim_size(size);
            predators.put(line, size);
            Date date = new Date();
            log.WriteToLog("Создано животное типа Predator" + " " + getAnim_name() + " " + date.toString() + "\n");
        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (NumberFormatException n)
        {
            System.out.println("Неверно написан размер животного");
        }
    }

    public void PredatorsReadDatabase() {
        try {
            if (getFilePredators().createNewFile()) {
                //System.out.println(" Файл логов создан");
            } else {
                //System.out.println("Файл логов уже существует");
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(getFileNamePredators()))) {

                String line = reader.readLine();

                while (!line.isEmpty()) {

                    String[] strings;
                    String delimiter = ":"; //разделитель
                    strings = line.split(delimiter);
                    predators.put(strings[0], parseInt(strings[1]));
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

    public void PredatorsWriteDatabase()
    {
        try {
            PrintWriter pw = new PrintWriter(getFileNamePredators());   // чистим все, что было в базе данных для корректной записи новой базы
            pw.close();
            // create new BufferedWriter for the output file
            BufferedWriter bf = new BufferedWriter(new FileWriter(getFileNamePredators(), true)); // для последовательной записи в файл

            // iterate map entries
            for (Map.Entry<String, Integer> entry :
                    predators.entrySet()) {

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
    public void PrintAllPredators() {
        ArrayList<String> values = new ArrayList<>(predators.keySet());
        System.out.println("Все животные типа Predators:" + " " + values);
    }
}
