package acceptancetests;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class LoginTests extends TestCase{

    private UserAccountManager userAccountManager;

    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu", "9132835734");
    }

    /* Login should succeed. AC: 2.1 */
    public void testSuccessfulLogin() {
        UserAccount userAccount = userAccountManager.login("admin", "@umkcFH310");
        assertNotNull(userAccount);
        assertTrue(userAccount.getUserName().equalsIgnoreCase("admin"));
        assertTrue(userAccount.getEmail().equalsIgnoreCase("admin@umkc.edu"));
    }

    /* Login should be unsuccessful as user doesn't exist. AC: 2.2 */
    public void testInvalidUsername() {
        UserAccount userAccount = userAccountManager.login("JoeBiden2016", "JoeBiden@12");
        assertNull(userAccount);
    }

    /* Login should be unsuccessful as password isn't correct. AC: 2.3 */
    public void testInvalidPassword() {
        UserAccount userAccount = userAccountManager.login("admin", "@umkcFH");
        assertNull(userAccount);
    }

    /* Test login after a fresh registration. Should succeed. AC: 2.4 */
    public void testSuccessfulRegisterAndLogin() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
        UserAccount userAccount = userAccountManager.login("JoeBiden2016", "JoeBiden@12");
        assertNotNull(userAccount);
        assertTrue(userAccount.getUserName().equalsIgnoreCase("joebiden2016"));
        assertTrue(userAccount.getEmail().equalsIgnoreCase("joe@biden.com"));
    }
}
