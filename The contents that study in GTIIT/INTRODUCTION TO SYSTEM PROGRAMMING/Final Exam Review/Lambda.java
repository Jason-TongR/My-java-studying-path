import java.util.List;
import java.util.ArrayList;
public class Lambda{
    private List<String> Example_list;
    
    
    public Lambda(){
        Example_list = new ArrayList<String>();
        
        Example_list.add("Paulo");
        Example_list.add("Jason");
        Example_list.add("naza");
        Example_list.add("rela");
        Example_list.add("Leadro");
        Example_list.add("Richar");
    }
    
    public void Printing_by_Lambda(){
        Example_list.forEach( n -> {System.out.println(n);});   // Example_list.forEach( n -> System.out.println(n);); this is also ok.                                                               
    }
    
}