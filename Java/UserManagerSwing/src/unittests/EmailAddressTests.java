package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class EmailAddressTests extends TestCase {

	public void testValidEmailAddress() {
		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com"));
	}
	public void testInvalidNoAt() {
		assertFalse(UserAccount.isEmailValid("don.smith2gmail.com"));
	}
	public void testInvalidNoDomain() {
		assertFalse(UserAccount.isEmailValid("don.smith@gmailcom"));
	}

}
