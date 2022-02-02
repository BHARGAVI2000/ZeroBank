package javaBasics;


class A{
int i=10;
}
class B extends A
{
	int i=20;
	
	
}

public class OutputofExtend {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		A a = new B();
		System.out.println(a.i);

	}

}
