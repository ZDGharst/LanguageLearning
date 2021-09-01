package business;

public class UserAccount {
	
	private String userName;
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public UserAccount() {	
	}
	
	public static String checkInputError(String userName, String password, String firstName, String lastName, String email, String phone){
		String errorMessage ="";
		if (!isUserNameValid(userName))
				errorMessage += "Invalid user name.\n";
		if (!isPasswordValid(password))
				errorMessage += "Invalid password.\n";	
		if (!isFirstNameValid(firstName))
			errorMessage += "Invalid first name.\n";
		if (!isLastNameValid(lastName))
			errorMessage += "Invalid last name.\n";
		if (!isEmailValid(email))
			errorMessage += "Invalid email.\n";
		if (!isPhoneNumberValid(phone))
			errorMessage += "Invalid phone number.\n";
		return errorMessage;
	}
	
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	// you need to complete this method
	public static boolean isUserNameValid(String userName){
		if (userName.length() == 0)
			return false;
		if (!Character.isLetter(userName.charAt(0)))
			return false;
		for (char c : userName.toCharArray())
			if (!Character.isLetter(c) && !Character.isDigit(c))
				return false;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public static boolean isPasswordValid(String password){
		boolean upperCaseLetter = false, lowerCaseLetter = false, digit = false, specialChar = false;
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c))
				upperCaseLetter = true;
			else if (Character.isLowerCase(c))
				lowerCaseLetter = true;
			else if (Character.isDigit(c))
				digit = true;
			else
				specialChar = true;
		}
		if (upperCaseLetter && lowerCaseLetter && digit && specialChar && password.length() >= 6)
			return true;
		return false;
	}

    public boolean isValidCredential(String userName, String password) {
         return matchUserName(userName) && matchPassword(password);
    }
    
    public boolean matchUserName(String userName) {
         return userName != null && userName.equalsIgnoreCase(this.userName);
    }
    
    private boolean matchPassword(String password) {
        return password != null && password.equals(this.password);
   }

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public static boolean isFirstNameValid(String firstName){
		if(firstName.length() == 0)
			return false;
		for (char c : firstName.toCharArray())
			if(!Character.isLetter(c))
				return false;
		return true;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public static boolean isLastNameValid(String lastName){
		if(lastName.length() == 0)
			return false;
		for (char c : lastName.toCharArray())
			if(!Character.isLetter(c))
				return false;
		return true;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public static boolean isEmailValid(String email){
		boolean atSymbol = false, period = false;
		for (char c : email.toCharArray()) {
			if (c == '@')
				atSymbol = true;
			if (c == '.' && atSymbol == true)
				period = true;
		}

		if (period && atSymbol)
			return true;
		return false;
	}

	public String getPhoneNumber(){
		return phone;
	}

	public void setPhoneNumber(String phone){
		this.phone = phone;
	}

	public static boolean isPhoneNumberValid(String phone){
		if (phone.length() != 10)
			return false;
		for (char c : phone.toCharArray())
			if (!Character.isDigit(c))
				return false;

		return true;
	}


}
