package entities;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	Set <Phone> phones = new HashSet<Phone>();
	private long version;
	
	public Contact() {
	}
	
	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set <Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set <Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
		
}
