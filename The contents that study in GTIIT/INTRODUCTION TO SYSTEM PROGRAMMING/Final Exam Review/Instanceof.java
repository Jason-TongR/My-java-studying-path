public class Instanceof{
    private Animal Kandy; 
    private Animal Bob;
    
    
    public Instanceof(){
        Kandy = new Cat("Kandy" , 12 , "MianYin");
        Bob = new Dog("Bob" , 15 , "BianMu");
    }
    
    
    public  void show_Instanceof(){
        if( Kandy instanceof Cat ){
            System.out.println("Kandy is a Cat!");
        }
        
        if( !(Bob instanceof Cat) ){
            System.out.println("Bob is a Dog , not Cat!");
        }
    }
}