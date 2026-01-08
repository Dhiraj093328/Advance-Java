package test;

public class WrapperClassDemo {

	public static void main(String[] args) {
		int i=20;
		
		int a=30;
		
		Integer itr=Integer.valueOf(i);  //explicit conversion ---autoboxing
		
		Integer j=a; //aautoboxing compiler will write internally Integer.valueof(a)

		System.out.println("i: " +i+ " a: " +a);
		System.out.println("itr: " +itr+ " j: " +j);
		
		char c='c';
		
		Character c1=Character.valueOf(c);
		
		Integer s=new Integer(10);
		
		int x=s.intValue(); //unboxing
		
		int y=s; //unboxing
		
		System.out.println(x+" "+y);

	}

}
