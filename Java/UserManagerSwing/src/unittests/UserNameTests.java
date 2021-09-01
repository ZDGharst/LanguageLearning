package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin"));
	}
	public void testValidUserName2() {
		assertTrue(UserAccount.isUserNameValid("admin12"));
	}
	public void testValidUserName3() {
		assertTrue(UserAccount.isUserNameValid("Administr8tor"));
	}
	public void testInvalidUserName() {
		assertFalse(UserAccount.isUserNameValid("admin$"));
	}
	public void testInvalidUserName2() { assertFalse(UserAccount.isUserNameValid("11admin")); }

}
