public class auto_convert{
	public static void main(String[] args){
		/* I.
		 *
		 *	 1.
		 * 		char ==>> int ==> long ==>> float ==>> double
		 *	 2.
		 * 		byte ==>> short ==>> int ==>> long ==>> float ==>> double
		 * 	 3.
		 * 	 	byte.short.char   cant change automaticly
		 * 	 4.
		 * 	 	byte short char   can compute together.they will change to int first.(even if only one appear)
		 * 	 5.
		 * 	 	boolean cant change .cant compute.
		 */
		int num = 'a';			// char => int
		double d1 = 80;			// int => double
		System.out.println(num);  	//97
		System.out.println(d1);		//80.0



		/* II.
		 * 
		 * Example 1:
		 *
		 * int n1 = 10;
		 * float d1 = n1 + 1.1;    it is double + double .cant give in float
		 *
		 * it is not correct.if we have different type of operation.it will automaticly change both into the bigger type.
		 *
		 * solution 1:
		 * 
		 * int n1 = 10;
		 * float d1 = n1 + 1.1;
		 *
		 * solution 2:
		 *
		 * int n1 =10;
		 * float d1 = n1 + 1.1F;
		 *
		 * Example 2:
		 *
		 * int n = 1.1;		incorrect. you give a double to int.
		 *
		 * Example 3:
		 *
		 * byte b1 = 10;	why it is correct? int ==>> byte ?  if assign to byte,we will first look if volue is inside byte.such as 'byte b1 = 1000;'is incorrect.
		 *
		 * Example 4:
		 *
		 * int n2 = 1;
		 * byte b2 = n2;	incorrect. int ==>>byte. if assign by varible, it will look the type.
		 *
		 * Example 5:
		 *
		 * byte b1 = 10;
		 * char c1 = b1;	incorrect. byte char short  cant antomaticly change each other.
		 *
		 * Example 6:
		 *
		 * byte b2 = 1;
		 * short s1 = 2;
		 * short s2 = b2 + s1;	incorrect. b2 + s1 is int .cant assign to short.  int s2 = b2 + s1 is correct.
		 *
		 * Test 1:
		 *
		 * byte b2 = 1;
		 * byte b3 = 2;
		 * byte b4 = b2 + b3;	incorrect. b2 + b3 is int.cant give to byte.
		 *
		 * Example 7:
		 *
		 * boolean pass = true;
		 * int num = pass;	incorrect. boolean cant change type.cant compute.
		 *
		 * Test 2:
		 *
		 * byte b4 = 1;
		 * short s3 = 100;
		 * int num200 = 1;
		 * double num300 = 1.1;
		 * ? k = b4 + s3 + num200 + num300;  	 (b4 + s3 + num200 + num300) is double.
		 *
		 * Test 3:
		 *
		 * byte b4 = 1;
                 * short s3 = 100;
                 * int num200 = 1;
		 * float num300 = 1.1F;
                 * int k = b4 + s3 + num200 + num300;	incorrect. float cant give in double.
		 */
	}
}
