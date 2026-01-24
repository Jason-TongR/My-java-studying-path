import java.util.List;
import java.util.ArrayList;

public class Stream{
    private List<Integer> number_list;
    
    public Stream(){
        number_list = new ArrayList<Integer>();
        
        number_list.add(3);
        number_list.add(1);
        number_list.add(3);
        number_list.add(1);
        number_list.add(4);
        number_list.add(5);
    }
    
    
    public void filter_GreaterOrEqual_3(){
        number_list.stream().filter( n -> (n >= 3) ).forEach( n -> System.out.println(n));
        /*
         * number_list.stream()   is create a stream
         * number_list.stream().filter( n -> (n >= 3) ) is to do a filter
         * number_list.stream().filter( n -> (n >= 3) ).forEach( n -> System.out.println(n)); is printing all the elements after filter
         */        
    }
    
    
    public void map_All_Elemtn_Plus_One(){
        number_list.stream().map( n -> n+1 ).forEach( n -> System.out.println(n));
    }
    
    
    public void reduce_Sum(){
        int sum = number_list.stream().reduce(0,(n,m) -> n+m );
        System.out.println( sum );
    }
    
    
    public void Stream_Mix_Together(){
        int sum = number_list.stream().filter( n -> (n >= 3) ).map( n -> n+1).reduce(0 , (n,m) -> n+m );
        System.out.println(sum);    //expect 19
    }
}