package entities;

import java.util.HashSet;
import java.util.Set;

public class GroupeContact 
{
	private long id;
	private String name;
	private String description;
	private Set <Contact> contacts;
	
	public GroupeContact()
	{
		
	}
	
	public GroupeContact(String name, String description)
	{
		this.name = name;
		this.description = description;
		contacts = new HashSet<Contact>();
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getDescription()
	{
		return this.description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void setDescription(String value)
	{
		this.description = value;
	}

	public void addGroupeContact(Contact c)
	{
		this.contacts.add(c);
	}
	
	public void deleteGroupeContact(Contact c)
	{
		this.contacts.remove(c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupeContact other = (GroupeContact) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupeContact [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	

}
