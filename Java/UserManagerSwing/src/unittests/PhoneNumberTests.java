package unittests;

import business.UserAccount;
import junit.framework.TestCase;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218"));
	}
	public void testInvalidLength() { assertFalse(UserAccount.isPhoneNumberValid("81623562")); }
	public void testInvalidAlpha() { assertFalse(UserAccount.isPhoneNumberValid("8162aaa218"));
	}

}
