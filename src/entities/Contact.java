package entities;

import java.util.HashSet;
import java.util.Set;

public class Contact implements IContact {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	Set <Phone> phones = new HashSet<Phone>();
	private long version;
	Set <GroupeContact> groupeContact = new HashSet<GroupeContact>();
	
	public Contact() {
	}
	
	public Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Set <Phone> getPhones() {
		return phones;
	}

	@Override
	public void setPhones(Set <Phone> phones) {
		this.phones = phones;
	}
	
	@Override
	public Set <GroupeContact> getGroupeContact() {
		return groupeContact;
	}

	@Override
	public void setGroupeContact(Set <GroupeContact> groupeContact) {
		this.groupeContact = groupeContact;
	}



	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", groupeContact=" + groupeContact + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}
	
	
		
}
