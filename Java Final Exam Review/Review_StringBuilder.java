public class Review_StringBuilder{
    //field ommitted
    
    //constructor ommitted
    
    
    
    public void Print_HelloWorld_by_Using_StringBuilder(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello").append(" ").append("World");
        System.out.println(builder);
    }
    
    public void Print_From_One_To_Hundred_by_Using_StringBuilder(){
        StringBuilder result = new StringBuilder();
        for( int i = 1 ; i < 101 ; i++ ){
            result.append(i).append("\n");
        }
        
        System.out.println(result);
    }
}