package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House2"));
	}
	public void testInvalidPasswordLength() {
		assertFalse(UserAccount.isPasswordValid("1!aB"));
	}
	public void testInvalidPasswordLower() {
		assertFalse(UserAccount.isPasswordValid("WHITE!1HOUSE"));
	}
	public void testInvalidPasswordUpper() { assertFalse(UserAccount.isPasswordValid("thewhitehouse!!12")); }
	public void testInvalidPasswordSpecial() { assertFalse(UserAccount.isPasswordValid("TheWhiteHouse12")); }
	public void testInvalidPasswordDigit() { assertFalse(UserAccount.isPasswordValid("TheWhiteHouse!!")); }

}
