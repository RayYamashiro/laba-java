import java.util.*;
import Forest.*;
public class Program
{
    public static void main (String [] args)
    {

        //Vector<String> vec_tor = new Vector();
        //vec_tor.add("Geeks");
        //vec_tor.addElement("Last");

        Forest.Herbivores a = new Forest.Herbivores("fff" , 12);
        Predators b = new Predators("dd" , 18);
        //b.anihilationAnimals(b , a);
        Grass m = new Grass ("Трава") ;
        a.addEdiblePlant(m);
        a.checkEdibilityPlant(m);
    }
}
