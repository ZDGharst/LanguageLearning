package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class LastNameTests extends TestCase {

	public void testValidFirstName() {
		assertTrue(UserAccount.isLastNameValid("Smith"));
	}
	public void testInvalidNumbers() {
		assertFalse(UserAccount.isLastNameValid("smith18"));
	}
	public void testInvalidSpaces() { assertFalse(UserAccount.isLastNameValid("mister smith")); }
	public void testInvalidEmpty() { assertFalse(UserAccount.isLastNameValid("")); }

}
