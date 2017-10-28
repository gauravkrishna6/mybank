package bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class mytest {

	@Test
	public void chkLoginTest() {
		
		Database mydb = new Database();
		int value = mydb.chkLogin("gaurav", "krishna");
		assertFalse(value == 1111);
		assertEquals(11111 , value );
		
		
	}
	
	@Test
	public void getnameTest() {
		
		Database mydb1 = new Database();
		String myname = mydb1.getName(11111);
		assertEquals("gaurav krhna", myname );
		//assertEquals(11111 , value );
		
		
	}
	
	

}
