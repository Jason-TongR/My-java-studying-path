public abstract class People{
    /*
     * in field ,   *abstract class : can have int ,String,...whatever..
     *              *interface : only can have public(actually it is final staic)      
     */
    protected String name;              
    
    
    public People(String name){
        this.name = name;
    }
    
    public void see(){
        /*
         * in *abstract class,we can have method complement.
         *    *interface , we can't have this.  
         */
        System.out.println("I see!");
    }                                    
                                        
    public abstract void move();        //in abstract class,we can also have abstract method.BUT IT MUST BE COMPLETED IN THE SUBCLASS!!!
    
    
    
    /**
     * About declear:
     *                  1:      
     *                      *private People p1;
     *                      *p1 = new People();     wrong! because People is abstract , can  be declear , but can't be construct(instantiated)!
     *                      
     *                  2:
     *                      *private People p1;
     *                      *p1 = new Jason();      correct!
     *                     
     *                  3:
     *                      *private Jason p1;
     *                      *p1 = new Jason();      correct!
     *                      
     *                  4:
     *                      *private Jason p1;
     *                      *p1 = new People();     wrong! because People is not a subclass of Jason.
     *              
     */
}