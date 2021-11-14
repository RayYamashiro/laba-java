package modules_for_the_program;

import java.io.*;
import java.util.*;
import java.io.IOException;
;

public class Logs extends Prog {
    private ArrayList<String> ArrayOfLogs ;

    public void setArrayOfLogs(ArrayList temp) {
        this.ArrayOfLogs = temp;
    }
    public ArrayList<String> getArrayOfLogs() {
        return ArrayOfLogs;
    }

    public void WriteToLog(String infAboutLog)
    {
        try {
            FileOutputStream l = new FileOutputStream(getFileName());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(l));
            writer.write(infAboutLog);
            writer.close();
        } catch (IOException e)
        {

            e.printStackTrace();
        }
    }





}

