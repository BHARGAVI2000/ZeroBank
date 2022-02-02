package s1;

public class Animal {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
    Animal myAnimal = new Animal();  // Create a Animal object
  // Pig myPig = new Pig();
    Animal myPig = new Pig();  // Create a Pig object
    //Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    //myPig.hi();
    myPig.vehichleSound();
    
    
    myPig.animalSound();
    
   // myDog.animalSound();
  }


	

		  public void animalSound() {
		    System.out.println("The animal makes a sound");}
		  public void vehichleSound() {
		  System.out.println("The vehicle makes a sound");
		  }
		  
		}

		class Pig extends Animal {
		  public void animalSound() {
		    System.out.println("The pig says: wee wee");
		    
		  }
		    public void hi() {
		    	System.out.println("Hello");
		    
		    	
		    	
		    }
		  }
		

		class Dog extends Animal {
		  public void animalSound() {
		    System.out.println("The dog says: bow wow");
		  }
		


		}


 
	
		

