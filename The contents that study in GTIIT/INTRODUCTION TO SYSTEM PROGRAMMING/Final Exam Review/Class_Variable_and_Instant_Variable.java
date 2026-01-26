public class Class_Variable_and_Instant_Variable{
    private int a;
    private int b;
    private String c;
    /*
     * ^^^^^
     * |||||
     * 
     * there are called instant variable,if there are different for different objects.
     * and not every object can share them
     */
    
    private static int d;
    private static String e;
    /*
     * ^^^^^
     * |||||
     * 
     * there are called Class variable,if they are the same for different objects.
     * and every object can share them.
     */
    
    
}