public class Dog extends Animal{
    private String breed;
    
    public Dog(String name , int age , String breed ){
        super(name ,age);           //we need to add super(... , ...) to use the super class's constructor.
        this.breed = breed;
    }
    
    
    public void bark(){
        System.out.println(age + "'s " + breed + " barking:" + " my name is:" + " " + name );
    }
}