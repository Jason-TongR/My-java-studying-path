public interface Example_Interface_One{
    public int a = 1; 
    
    /*
     * in the field of the interface:
     *      the following are all correct:
     *                                      int a = 10;                    public static final
     *                                      public int b = 20;              
     *                                      static int c = 30;               
     *                                      final int d = 40;                
     *                                      public static int e = 50;       
     *                                      public final int f = 60;         
     *                                      static final int g = 70;          
     *                                      public static final int h = 80; 
     *
     *      
     *      the following are not correct:
     *                                      private int i = 90;             should be public
     *                                      protected int j = 100;          should be public
     *                                      int k;                          should be initialized
     *                                      final int l;                    should be initialized
     *                                      abstract int m = 110;           should be public , not abstract
     */
    
    
    
    
    /**
     *          WE DON'T HAVE CONSTRUTOR IN INTERFACE!!!        
     */
    
    
    
    /**
     *  in interface , only abstract method is allowed. But it should be completed in the subclass!
     */
    public abstract void method_one();
    
    
    public abstract int method_two();
    
    
    
}