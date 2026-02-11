import java.util.Random;
public class random{
    private Random random;
    
    
    public random(){
        random = new Random();
    }
    
    
    public double generate_random_number(){
        return random.nextDouble();
    }
    
    public double generate_random_number_between_zeroPointTwo_zeroPointFive(){
        return ( ( ( ( this.generate_random_number() )*100)%31)*0.01) + 0.2; 
    }
}