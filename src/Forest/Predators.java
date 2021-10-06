package Forest;

public class Predators extends Animals
{
    public Predators()
    {
        anim_name = "Vasyan" ;
        anim_size = 15;
    }
    public Predators(String name , double size)
    {
        this.anim_size = size;
        this.anim_name = name;
    }
    public void anihilationAnimals (Predators a , Herbivores b)
    {
        if(a.anim_size > b.anim_size)
        {
            b = null;
            System.out.println("Произошло уничтожение травоядного.");
        }
        else
            System.out.println("Размер хищника равен или меньше размера травоядного. Уничтожения не произошло.");
    }
}
