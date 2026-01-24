import java.util.List;
import java.util.ArrayList;

public class SomeMethodInStringClass{
    private List<String> test_list;
    
    
    
    public SomeMethodInStringClass(){
        test_list = new ArrayList<String>();
        
        test_list.add("Paulo");
        test_list.add("Jason");
        test_list.add("naza");
        test_list.add("rela");
        test_list.add("Leadro");
        test_list.add("Richar");
    }
    
    
    
    /*
     * in String class we have many good method
     * 
     * 1.startsWith( String prefix )
     * 2.contains
     * 3.indexOf
     * 4.substring
     * 5.trim
     * 6.Beware:string are immutable
     */
    public void Print_the_people_name_starts_with_P(){
        test_list.stream().filter( n -> ( n.startsWith("P") == true ) ).forEach( n -> System.out.println(n));
    }
}