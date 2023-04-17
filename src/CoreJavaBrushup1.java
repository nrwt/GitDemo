
public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//data type in java
		//int, String, char

		int num = 6;
		String name = "nandini";
		char ch = 'd';
		double d = 5.99;
		boolean b = true;
		
		System.out.println(num+" "+name+" "+ch+" "+d+" "+b);
		
		//Arrays can store multiple values in single variable
		
		int[] arr1 = {};
		int[] arr = new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		String names [] = {"rani", "narnia", "rahul", "gaury"};
		
		//OR
		
		int[] arr2 = {1,2,3,4,6, 10, 122, 17, 16};
		
		for(int i = 0; i<arr2.length; i++)
		{
			
			System.out.println(arr2[i]);
		}
		
		for (String s: names) 
		{
			System.out.println(s);
		}
		
	}

}
