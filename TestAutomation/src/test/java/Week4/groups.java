package Week4;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class groups {
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass () {
		System.out.println("Before Class");
		
		}
	@Test(groups= {"functional-group"})
	public void test1() {
		System.out.println("test1");
		}
	@Test(groups= {"functional-group"})
	public void test2() {
		System.out.println("test2");
		}
	@Test(groups={"functional-group", "smoke-groups"})
	public void test3() 
		{System.out.println("test3");
		}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		System.out.println("after class");
		}
	
}
