public class force_convert{
	public static void main(String[] args){
		// I.
			int n1 = (int)1.9;
			System.out.println("n1 = " + n1);	// n1 = 1
		

			int n2 = 2000;
			byte b1 = (byte)n2;
			System.out.println("b1 = " + b1);	// gabage
		
		// II.
			/*
			 * int y = (int)10*3.5 + 6*1.5;		incorrect .it is((int)10) * 10 ......    double cant give to int
			 * System.out.println(y);
			 */
			int y = (int)(10*3.5 + 6*1.5);
			System.out.println(y);
		
		// III.
			/*
			 * char c1 = 100;	correct
			 * int m = 100;		correct
			 * char c2 = m;		incorrect
			 * char c3 = (char)m;	corrcect
			 * System.out.prinln(c3);	ASCII ==>> 100
			 */
		
		// IIII.
			// byte short char   compute will change into int first.	
	}
}
