package com.event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

	private EmailValidator emailValidator;

	public UserRegistration() {		
		emailValidator = new EmailValidator();
	}

	public boolean validate( User u ) throws RegistrationException{
		validateEmailAddress( u.getEmail() );
		validateAge( u.getAge() );
		validateFirstName( u.getName() );
		return true;
	}

	public boolean validateFirstName(String firstName)  throws RegistrationException {
		if( firstName.trim().length() == 0 ) {
			throw new RegistrationException( "Firstname can not be empty" );
		}
		return true;
	}

	public boolean validateEmailAddress( String email ) throws RegistrationException {
		boolean isValid = emailValidator.validate( email );
		if( !isValid ) {
			throw new RegistrationException( "Invalid email address" );
		}
		return isValid;
	}

	public boolean validateAge( int age )  throws RegistrationException  {
		if( age < 18 ) {
			throw new RegistrationException( "Age must be 18 and above" );
		}
		return true;
	}

}

class RegistrationException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegistrationException( String message ) {
		super( message );
	}
}

class EmailValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}

class User {
	
	private String name;
	private String email;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}