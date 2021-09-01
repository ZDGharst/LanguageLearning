package business;
import java.util.ArrayList;

public class UserAccountManager {
	
	public static final String NOINPUTERROR = "";
	
    private ArrayList<UserAccount> userAccounts;
    
    public UserAccountManager() {
        userAccounts = new ArrayList<UserAccount>();
    }

    public String registerNewUser(String userName, String password, String reenteredPassword, 
    		String firstName, String lastName, String email, String phone){
    		UserAccount newAccount = new UserAccount();
    		setAccountProfile(newAccount, userName, password, firstName, lastName, email, phone);

			String error = "";
			error += newAccount.checkInputError(userName, password, firstName, lastName, email, phone);
			if(doesUserNameExist(userName))
				error += "Username already exists.\n";

			if(!password.equals(reenteredPassword))
				error += "Reentered password doesn't match original password.\n";

			if(error.equals(NOINPUTERROR))
				userAccounts.add(newAccount);

    	    return error;
    }

    private void setAccountProfile(UserAccount userAccount, String userName, String password, String firstName, String lastName, String email, String phone){
		userAccount.setUserName(userName);
		userAccount.setPassword(password);
		userAccount.setFirstName(firstName);
		userAccount.setLastName(lastName);
		userAccount.setEmail(email);
		userAccount.setPhoneNumber(phone);
    }
    
    // return the user account if the given userName and password are correct
    // otherwise null
    public UserAccount login(String userName, String password) {
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.isValidCredential(userName, password))    
    				return userAccount;
    		return null;
    }
    
    public boolean doesUserNameExist(String userName){
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.matchUserName(userName))   
    				return true;   
    		return false;
    }
    
}
