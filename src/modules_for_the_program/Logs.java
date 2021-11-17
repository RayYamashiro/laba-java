package modules_for_the_program;

import java.io.*;
import java.util.*;
import java.io.IOException;
;

public class Logs extends Prog {
    private ArrayList<String> ArrayOfLogs = new ArrayList<>() ;

    public void setArrayOfLogs(ArrayList temp) {
        this.ArrayOfLogs = temp;
    }
    public ArrayList<String> getArrayOfLogs() {
        return ArrayOfLogs;
    }

    public void WriteToLog(String infAboutLog)
    {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter( getFileName() ,true )); // для последовательной записи в файл
            bf.write(infAboutLog);
            bf.close();
        } catch (IOException e)
        {

            e.printStackTrace();
        }
    }





}

