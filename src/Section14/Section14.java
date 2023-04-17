package Section14;
import java.util.ArrayList;
import java.util.List;

public class Section14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//count the number of names starting with alphabet A in list
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Rahul");
		names.add("akahul");
		names.add("Aahul");
		names.add("Mahul");
		names.add("Ardfahul");
		names.add("AcvbRahul");
		names.add("GHRahul");
		names.add("Gmnmahul");
		int count =0;
		
		System.out.println("names starting with a or A are below ");
		
		for(int i =0; i < names.size(); i++) 
		{
		String nameA = names.get(i);
		char alphabet = names.get(i).charAt(0);
		/*if((alphabet=='a')|| (alphabet=='A')) 
		{
            count = count + 1;  
            System.out.println(names.get(i));
	    }*/
		
		if(nameA.startsWith("A")) {
			
		count++;
		System.out.println(names.get(i));
		}
		}
		System.out.println("Total count is "+count);
   }
	
}
