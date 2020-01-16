package entities;

import java.util.Set;

public interface IContact {

	long getId();

	void setId(long id);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getEmail();

	void setEmail(String email);

	Set<Phone> getPhones();

	void setPhones(Set<Phone> phones);

	Set<GroupeContact> getGroupeContact();

	void setGroupeContact(Set<GroupeContact> groupeContact);

	String toString();

	int hashCode();

	boolean equals(Object obj);

}