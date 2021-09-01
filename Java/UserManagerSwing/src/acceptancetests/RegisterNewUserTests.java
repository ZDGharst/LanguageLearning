package acceptancetests;

import business.UserAccount;
import business.UserAccountManager;
import junit.framework.TestCase;

public class RegisterNewUserTests extends TestCase{

    private UserAccountManager userAccountManager;

    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser("admin", "@umkcFH310", "@umkcFH310", "Scrum", "Master", "admin@umkc.edu", "9132835734");
    }

    /* Registration should succeed. AC: 1.20 */
    public void testSuccessfulRegistration() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
        UserAccount userAccount = userAccountManager.login("JoeBiden2016", "JoeBiden@12");
        assertNotNull(userAccount);
        assertTrue(userAccount.getUserName().equalsIgnoreCase("joebiden2016"));
        assertTrue(userAccount.getEmail().equalsIgnoreCase("joe@biden.com"));
    }

    /* Registration should fail because username doesn't start with a letter. AC: 1.2 */
    public void testInvalidUsernameNumberStart() {
        String registrationResult = userAccountManager.registerNewUser("2016JoeBiden", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("2016JoeBiden"));
    }

    /* Registration should fail because username doesn't consist of only letters/digits. AC: 1.3 */
    public void testInvalidUsernameSymbol() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden!!!", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden!!!"));
    }

    /* Registration should fail because username already exists. AC: 1.4 */
    public void testInvalidUsernameExists() {
        String registrationResult = userAccountManager.registerNewUser("admin", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
    }

    /* Registration should fail because password isn't long enough. AC: 1.6 */
    public void testInvalidPasswordShort() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "joey", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because password doesn't contain an uppercase letter. AC: 1.7 */
    public void testInvalidPasswordRequireUppercase() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "joebiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because password doesn't contain a lowercase letter. AC: 1.7 */
    public void testInvalidPasswordRequireLowercase() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JOEBIDEN@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because password doesn't contain a symbol. AC: 1.7 */
    public void testInvalidPasswordRequireSymbol() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because password doesn't contain a digit. AC: 1.7 */
    public void testInvalidPasswordRequireDigit() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because first name isn't purely letters. AC: 1.9 */
    public void testInvalidFirstName() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe 12", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because last name isn't purely letters. AC: 1.11 */
    public void testInvalidLastName() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden 12", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because email isn't valid. AC: 1.13 */
    public void testInvalidEmail() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe2biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because phone number isn't exactly 10 digits. AC: 1.15 */
    public void testInvalidPhoneNumber() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "70242657");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because phone number contains something other than digits. AC: 1.16 */
    public void testInvalidPhoneSymbols() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden@12", "Joe", "Biden", "joe@biden.com", "abcdefghjk");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }

    /* Registration should fail because passwords don't match. AC: 1.18 */
    public void testInvalidReenteredPassword() {
        String registrationResult = userAccountManager.registerNewUser("JoeBiden2016", "JoeBiden@12", "JoeBiden12", "Joe", "Biden", "joe@biden.com", "7024265734");
        assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
        assertFalse(userAccountManager.doesUserNameExist("JoeBiden2016"));
    }
}