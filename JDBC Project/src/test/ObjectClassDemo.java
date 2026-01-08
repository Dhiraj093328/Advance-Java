package test;

public class ObjectClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectClassDemo d1 = new ObjectClassDemo();
		
		System.out.println(d1.toString());
		
		Integer i=new Integer(10);
		Integer j=new Integer(20);
		
		System.out.println(i.equals(j));
		
		String s1 = new String("Ram");
		String s2 = new String("Ram");

		System.out.println(s1.equals(s2));
		
		System.out.println(s1.getClass().getName());
		System.out.println(d1.getClass().getName());
		System.out.println(d1.getClass().getPackageName());




	}

}
