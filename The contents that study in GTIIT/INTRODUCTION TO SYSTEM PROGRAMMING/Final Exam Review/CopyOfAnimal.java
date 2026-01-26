public class CopyOfAnimal{                //Animal is a polymorphic variable
    protected String name;
    protected int age;
    
    public CopyOfAnimal( String name , int age ){
        this.name = name;
        this.age = age;
    }
    
    public void eat(){
        System.out.println(name + " is eating");
    }
    
    public void sleep(){
        System.out.println(name + " is sleeping");
    }
}
