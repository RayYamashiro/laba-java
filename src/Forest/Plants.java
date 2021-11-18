package Forest;

import java.io.File;
import java.util.ArrayList;

public abstract class Plants
{
    private String plant_name;
    private String fileNameTrees = "Trees.txt";
    private File fileTrees = new File(getFileNameTrees() );
    private String fileNameGrass = "Grass.txt";
    private File fileGrass = new File(getFileNameGrass() );

    public String getFileNameTrees ()
    {
        return fileNameTrees ;
    }
    public String getFileNameGrass ()
    {
        return fileNameGrass ;
    }
    public File getFileGrass()
    {
        return  fileGrass;
    }
    public File getFileTrees()
    {
        return  fileTrees;
    }
    public void setPlant_name(String name)
    {
        this.plant_name = name;
    }
    public String getPlant_name()
    {
        return plant_name;
    }

}
