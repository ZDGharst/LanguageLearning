package acceptancetestsamples;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class UserAccountManagerTests extends TestCase {

	private UserAccountManager userAccountManager;
	
	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu", "9132835734");		
	}

	public void testSuccessfulRegistration(){
		String registrationResult = userAccountManager.registerNewUser("trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("trump", "@White0House"); 
		assertNotNull(userAccount);
		assertTrue(userAccount.getUserName().equalsIgnoreCase("trump"));
		assertTrue(userAccount.getEmail().equalsIgnoreCase("trump@gmail.com"));
	}
	
	// this test may fail if the isUserNameValid method is not completed
	public void testRegistrationWithInvalidUserName(){
		String registrationResult = userAccountManager.registerNewUser("2016trump", "@White0House", "@White0House", "Don", "Trump", "trump@gmail.com", "7024265734");
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
		assertFalse(userAccountManager.doesUserNameExist("2016trump"));
	}

}
