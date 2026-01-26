public class Method_Searching_Way{
    /*
     * if we have object.method1();
     * 
     * 
     * then it will :
     *                  *first search whether method1() is in the dynamic class of object
     *                  *if not,search in the super class of the dynamic class
     *                  *until found method method1().
     *                  *( Override method in the subclass is first with the method in the super class )
     *  
     * 
     * 
     */
}