package Forest;

public class Predators extends Animals
{
    public Predators()
    {
    }
    public Predators(String name , double size)
    {
        setAnim_name(name);
        setAnim_size(size);
    }
    public void anihilationAnimals (Predators a , Herbivores b)
    {
        if(a.getAnim_size() > b.getAnim_size())
        {
            b = null;
            System.out.println("Произошло уничтожение травоядного.");
        }
        else
            System.out.println("Размер хищника равен или меньше размера травоядного. Уничтожения не произошло.");
    }
}
