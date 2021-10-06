package Forest;



public abstract class  Animals
{
    private String anim_name;
    private double anim_size;

    public void setAnim_name(String name)
    {
        this.anim_name = name;
    }
    public void setAnim_size(double size)
    {
        this.anim_size = size;
    }
    public Double getAnim_size()
    {
        return anim_size;
    }
    public String getAnim_name()
    {
        return anim_name;
    }
}
