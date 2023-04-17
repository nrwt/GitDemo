import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int[] arr2 = {1,2,3,4,6, 10, 122, 17, 16};
		
		// write which are only multiples of 2
		//2, 4, 6, 10, 122, 16
		
		for (int i=0; i < arr2.length; i++) 
		{
			if (arr2[i]%2 == 0)
			{
				System.out.print(arr2[i]+" ");
			}
			
		}
		
		System.out.println();
		
		// ArrayList is one of the class in Java== it is dynamically growing Array
		List<String> a = new ArrayList<String>();
		
		a.add("nandini");
		a.add("Dhanpal");
		a.add("Aashita");
		a.add("Vedant");
		a.add("Rahul");
		
		System.out.println("Elements of arrayList below");
		for (int i=0; i < a.size(); i++) 
		{
			System.out.print(a.get(i)+" ");
		}
		
		System.out.println();
		System.out.println("Elements of arrayList below with advance for loop method");
		for(String val: a) {
			System.out.print(val+" ");
		}
		// check if items present in arrayList. contain method is used (it is not present in Array)
		System.out.println();
		System.out.println(a.contains("Rahul"));
		System.out.println(a.contains("RahulVaidya"));
		
		// now we can convert normal array into ArrayList using method asList in Arrays class as explained below
		String names [] = {"rani", "narnia", "rahul", "gaury"};
		
		System.out.println(names[2]);
		// after converting array names as arrayList , we need to capture it in one variable
		List<String> namesArraylist = Arrays.asList(names);
		
		//Now array name changed to List Datatype so we can dynamically grow the values and use its methods.
		System.out.println("--------------------");
		//namesArraylist.add("chickenBiryaani");
		
		//namesArraylist.contains("chickenBiryaani");
		
		System.out.println(namesArraylist.get(0));
		
		List<String> namesArraylist1 = new ArrayList<String>();
		namesArraylist1.add("abc");
		
		System.out.println(namesArraylist1.get(0));
		
		
		
	}

}
