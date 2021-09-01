package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class FirstNameTests extends TestCase {

	public void testValidFirstName() {
		assertTrue(UserAccount.isFirstNameValid("john"));
	}
	public void testInvalidNumbers() {
		assertFalse(UserAccount.isFirstNameValid("John18"));
	}
	public void testInvalidSpaces() { assertFalse(UserAccount.isFirstNameValid("frank boy")); }
	public void testInvalidEmpty() { assertFalse(UserAccount.isFirstNameValid("")); }

}
