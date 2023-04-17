package Section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	//@Test
	public void regular() {
	ArrayList<String> names = new ArrayList<String>();
	names.add("Rahul");
	names.add("Askahul");
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
	if(nameA.startsWith("A")) {
		
	count++;
	System.out.println(names.get(i));
	}
	}
	System.out.println("Total count is "+count);
}
	
	//@Test
	public void streamFilter() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Rahul");
		names.add("Akahul");
		names.add("Aahul");
		names.add("Mahul");
		names.add("Ardfahul");
		names.add("AcvbRahul");
		names.add("GHRahul");
		names.add("Gmnmahul");
		
		//now instead of writing logic, we will move arraylist to streams as below
		
		
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//s->s.startsWith("A")  --- this is lamda expresion
		//working with stream explained in 3 operation
		//1) create stream --> that we do [names.stream()] from ArrayList
		
		//2. Then perform intermediate operation on initial stream to tranform in into another stream
		//like we perform filter operation to filter all names starts with A and it create
		//another stream of names start with A only
		
		//3. perform terminal operation on final stream to get final result
		//count is that operation in above and datatype of count is Long here
		
		//there is no life of intermediate operation(filter), if there is no terminal op
		//terminal operation will execute only if intermediate op returns true
		//we can create stream as above and below
		//will learn how to use filter in stream API
		
	long d = Stream.of("Rahul", "Ardfahul", "Acvffahul", "GHRahul", "Gmnmahul").filter(s->
		{
		s.startsWith("A");
		return false;		
		}
	).count();
	System.out.println(d);
	
	
	//output of above is 0 .. even though there is terminal method count but if 
	//intermediate method return false, terminal method will not execute that proves in above

	//how to print names
	
	names.stream().filter(s->s.length()>7).forEach(s->System.out.println(s));
	System.out.println(names.stream().filter(s->s.length()>7).count());
	
	//now i want only one name length greater than 7
	
	names.stream().filter(s->s.length()>7).limit(1).forEach(s->System.out.println(s));
	}

	//@Test
	public void streamMap() {
		
		//print names which has last letter l and convert them to UPPERCASE
		
		Stream.of("Rahulas", "Ardfahul", "Acvffal", "GHRahulsdd", "Gmnmahul").filter(s->s.endsWith("l")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println("***************************************************************");
		// map is used to modify the string
		
		//next activity
		//print all names with first letter as a with uppercase and sorted
		
		List<String> names = Arrays.asList("Rahulas", "Ardfahul", "Acvffal", "GHRa", "Gmnd", "Aditya");
		
		names.stream().filter(s->s.startsWith("A"))
		.map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));;
		System.out.println("***************************************************************");
		List<String> names_set2 = Arrays.asList("Jacob", "Lala", "Forest", "Benjamine");
		
		//concate above 2 List in stream
		//merging 2 different lists
		Stream<String> Finalstream = Stream.concat(names.stream(), names_set2.stream());
		//To print all names in final stream
		
		//very important..once stream is modified you cannot use previous stream hence commented below line 
		//to perform anyMatch method
		//Finalstream.sorted().forEach(s->System.out.println(s));
		
		//find if Jacob present in finalstream or not
		
		boolean flag =  Finalstream.anyMatch(s->s.equalsIgnoreCase("lala"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
		// collect method take the list ..convert to stream.. do modifications and convert back to list
		
	List<String> newList = Stream.of("Rahulas", "Ardfahul", "Acvffal", "GHRahulsdd", "Gmnmahul").filter(s->s.endsWith("l")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
	
	//newList.stream().forEach(s->System.out.println(s));
	newList.stream().limit(1).forEach(s->System.out.println(s));
	
	//have an array
	Integer[] nums = {3,2,2,7,5,1,9,7};
	List<Integer> numbers = Arrays.asList(nums);
	
	//print unique number from list
	//sort the array
	
	numbers.stream().sorted().forEach(s->System.out.println(s));
	System.out.println("**************************************************");
	numbers.stream().distinct().sorted().forEach(s->System.out.println(s));
			
	List<Integer> newValues=numbers.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println("**************************************************");
	System.out.println(newValues.get(2));
	}

}


