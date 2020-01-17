package entities;

import java.util.Set;

public interface IGroupeContact {

	long getId();

	void setId(long id);

	String getDescription();

	String getName();

	void setName(String name);

	Set<Contact> getContacts();

	void setContacts(Set<Contact> contacts);

	void setDescription(String value);

	void addGroupeContact(Contact c);

	void deleteGroupeContact(IContact c);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}