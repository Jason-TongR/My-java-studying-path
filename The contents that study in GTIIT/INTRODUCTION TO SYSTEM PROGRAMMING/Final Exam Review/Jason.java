public class Jason extends People{
    //field omitted
    
    public Jason(String name){
        super(name);
    }
    
    
    @Override                   //abstract method in the abstract superclass must be completed in the subclass.
    public void move(){
        System.out.println("Jason move!");
    }
}