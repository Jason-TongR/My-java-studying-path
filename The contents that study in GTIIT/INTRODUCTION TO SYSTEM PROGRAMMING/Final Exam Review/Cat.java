public class Cat extends Animal{
    private String breed;
    
    public Cat(String name , int age , String breed ){
        super(name ,age);           //we need to add super(... , ...) to use the super class's constructor.
        this.breed = breed;
    }
    
    
    public void Miaoing(){
        System.out.println(age + "'s " + breed + " Miaoing:" + " my name is:" + " " + name );
    }
}