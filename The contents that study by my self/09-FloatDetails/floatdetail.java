public class floatdetail{
	public static void main(String[] args){
		/*
		 * float  = 4byte
		 * double = 8byte	(always)
		 */


		/*  float = 1.1;  (incorrect)
		 *  float = 1.1F; (correct)
		 *  double = 1.1F; (correct)
		 */


		/*
		 * double n = 0.12;    is equivalent to double n = .12;
		 */
		System.out.println(5.12e2); //512.0   (since 5.12 is double)
		System.out.println(5.12E-2);//0.0512
		

		
		double n1 = 1.212643947683;
		float n2 = 1.212643947683F;
		System.out.println(n1);  //1.212643947683
		System.out.println(n2);  //1.212644   
					 //double is more precise
		




		double n3 = 2.7;      //2.7
		double n4 = 8.1 / 3;  //2.69999999999
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(Math.abs(n3 - n4));
	       	if( n3 == n4 )                              //not good
			System.out.println("equal");
		else
			System.out.println("not equal");
		




		if(Math.abs(n3 - n4) < 0.00000001)          //good way . The number is depended by actual situation.
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
