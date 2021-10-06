package Forest;

import java.util.ArrayList;

public class Herbivores extends Animals
{
    ArrayList<String> edible = new ArrayList<String>();
    ArrayList<String> non_edible = new ArrayList<String>();

    public Herbivores(String name , double size)
    {
        this.anim_name = name;
        this.anim_size = size;
    }
    public Herbivores()
    {
        anim_size = 12;
        anim_name = "Ivan";
    }
    public void addEdiblePlant (Trees a)
    {
        edible.add(a.plant_name);
    }
    public void addNonEdiblePlant (Trees a )
    {
        non_edible.add(a.plant_name);
    }

    public void checkEdibilityPlant (Trees a)
    {
        if(edible.contains(a.plant_name) == true)
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
        edible.add(a.plant_name);
    }
    public void addNonEdiblePlant (Grass a )
    {
        non_edible.add(a.plant_name);
    }

    public void checkEdibilityPlant (Grass a)
    {
        if(edible.contains(a.plant_name) == true)
        {
            System.out.println("Растение съедобное");
            System.out.println("Происходит уничтожение растения");
            a = null;
        }
        else
            System.out.println("Растение несъедобное");
    }
}
