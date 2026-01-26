public abstract class Asian extends People{
    //field omitted
    
    public Asian(String name){
        super(name);
    }
    
    
    @Override                   //abstract method in the abstract superclass must be completed in the subclass.
    public void move(){
        System.out.println("Asian move!");
    }
    
    public abstract void take();    //it can have abstract method again,but still need to be completed in the subclass of Asian.
}