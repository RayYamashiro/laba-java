package Forest;

import java.util.ArrayList;

public class Herbivores extends Animals
{
    ArrayList<String> edible = new ArrayList<String>();
    ArrayList<String> non_edible = new ArrayList<String>();

    public Herbivores(String name , double size)
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
}
