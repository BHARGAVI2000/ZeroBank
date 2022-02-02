package javaBasics;

public class SimpleInterest {

	public static void main(String[] args) {
		
		SimpleInterest S = new SimpleInterest();
		System.out.println(S.SInterest());
	}
				
		
		public static float SInterest() {
				float P=3000, R= 4, T=5;
				float SI=P*R*T/100; 
				return SI;
				
	}
	
	
	
	

}
