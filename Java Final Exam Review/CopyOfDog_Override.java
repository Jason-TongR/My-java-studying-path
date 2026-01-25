public class CopyOfDog_Override extends CopyOfAnimal{
    private String breed;
    
    public CopyOfDog_Override(String name , int age , String breed ){
        super(name ,age);           //we need to add super(... , ...) to use the super class's constructor.
        this.breed = breed;
    }
    
    
    @Override               //this is the Override of the eat method in the subclass
    public void eat(){
        super.eat();        //we can use super to use eat method in the super class
        System.out.println("Dog like eating bone");         
    }
    
    /**
     *      if a method with final 
     *                  with static
     *                  with private
     *      
     *      then this method can't be Override in the subclass!
     *      
     *      
     *      notice: if a method is with protected
     *              then it can Override in the subclass
     */
}
