package Forest;


import java.io.File;

public abstract class  Animals
{
    private String anim_name;
    private Integer anim_size;
    private String fileNamePredators = "Predators.txt";
    private File filePredators = new File(getFileNamePredators() );
    private String fileNameHerbivores = "Herbivores.txt";
    private File fileHerbivores = new File(getFileNameHerbivores() );

    public String getFileNamePredators ()
    {
        return fileNamePredators ;
    }
    public String getFileNameHerbivores ()
    {
        return fileNameHerbivores ;
    }
    public File getFilePredators()
    {
        return  filePredators;
    }
    public File getFileHerbivores()
    {
        return  fileHerbivores;
    }
    public void setAnim_name(String name)
    {
        this.anim_name = name;
    }
    public void setAnim_size(Integer size)
    {
        this.anim_size = size;
    }
    public Integer getAnim_size()
    {
        return anim_size;
    }
    public String getAnim_name()
    {
        return anim_name;
    }
}
