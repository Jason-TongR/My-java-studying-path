public class chardetail{
	public static void main(String[] args){
		char c1 = 'a';
		char c2 = '\t';
		char c3 = 97;    //ASCII code   it is 'a'
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);  	// a
		System.out.println(107);
		System.out.println('a' + 10);



		/*
		 * 1.
		 * 	char n = 'a';   	correct
		 * 	char n = '9';  	correct	
		 * 	char n = "9"; 	incorrect     "" is string.
		 *
		 *
		 *
		 * 2.
		 * 	char k = '\n'; 	correct;
		 *
		 *
		 *
		 * 3.
		 * 	char c = 'a';
		 * 	System.out.println((int)c);    we can use (int)...  to change char to ASCII code. it is 9.
		 *
		 *
		 *
		 * 4.
		 * 	System.out.println('a' + 10)  =====>>   System.out.println(97 + 10);
		 *
		 *
		 *
		 * 5.test:
		 * 	char c5 = 'b' + 1;
		 * 	System.out.println((int)c5);
		 * 	System.out.println(c5);
		 *
		 *
		 *
		 * 	=======>>>
		 *
		 * 	it will output:
		 * 	99
		 * 	c
		 *
		 *
		 */	

	}			
}
