
public class CorejavaBrushup3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String is an Object that represent sequence of characters and if value is same, the variable points to same memory location
		
		// two ways of representing string .. //string litral and with new keyword
		String s1 = "Nandini Learning   platform";
		String s2 = "Nandini Learning   platform";
		
		for(int i=0; i < s1.length(); i++) {
			System.out.print(s1.charAt(i)+" ");
		}
		System.out.println("**************Reverse order***********************");
		//create new keyword
		
		for(int i=s1.length()-1; i >= 0; i--) 
		{
			System.out.print(s1.charAt(i)+" ");
		}
		
		System.out.println("*****************");
		
		String S3 = new String("Welcome");
		String S4 = new String("Welcome");

		String[] splitstring = s1.split(" ");
		System.out.println(splitstring[0]);
		System.out.println(splitstring[1]);
		System.out.println(splitstring[2]);
		System.out.println(splitstring[3]);
		
		for (int i=0; i < splitstring.length; i++) 
		{
			//System.out.println(splitstring[i]);
		}
		
		System.out.println("Elements with advance for loop method");
		
		for (String st: splitstring) 
		{
			//System.out.println(st);
		}
		
		String[] splitstring1 = s1.split("Learning");
		System.out.println(splitstring1[0]);
		System.out.println(splitstring1[1]);
		
		System.out.println(splitstring1[1].trim());
	}

}
