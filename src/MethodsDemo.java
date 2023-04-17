
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodsDemo m = new MethodsDemo();
		m.getData();
		//m.getname();
		//String name = m.getname();
		System.out.println(m.getname());
		//System.out.println(name);
		System.out.println(m.getaddress());
		System.out.println(getData1());
		
		// call methods from other class
		
		OnlymethodsClass mc1 = new OnlymethodsClass();
		mc1.method1();
		
		System.out.println(mc1.method1());
	}
	
	// public method can be accessed by other classes as well
	public void getData() {
		
		System.out.println("Hello World");
		
	}
	
	//we access methods by creating object first, but in order to access methods without creating object, we can make it static
	
public static String getData1() {
		
		System.out.println("Static Method in print");
		return "static method";
		
	}

public String getname() {
		
		//System.out.println("GetName");
		return "nandini rawat";
		
	}

 private String getaddress() {
	return "HP10 0QG Private road , house number 21 Wokingham United Kingdom";
}
}
