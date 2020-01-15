package service;

import dao.DAOContact;
import dao.DAOGroupeContact;
import entities.Contact;
import entities.GroupeContact;

public class GroupeService 
{
	
	DAOGroupeContact daoGroupe;
	DAOContact daoContact;
	
	public GroupeService()
	{
		daoGroupe = new DAOGroupeContact();
		daoContact = new DAOContact();
		
	}
	
	public void saveOrUpdateGroupeContact(GroupeContact groupecontact)
	{
		
		daoGroupe.saveOrUpdateGroupeContact(groupecontact);
	}
	
	public void addContactGroupe(GroupeContact groupecontact, Contact contact) 
	{
		groupecontact.getContacts().add(contact);
		contact.getGroupeContact().add(groupecontact);
		daoGroupe.saveOrUpdateGroupeContact(groupecontact);
		daoContact.saveOrUpdateContact(contact);	
	}
	
	public void deleteContactGroupe(GroupeContact groupecontact, Contact contact)
	{		
		groupecontact.getContacts().remove(contact);
		contact.getGroupeContact().remove(groupecontact);
		//daoGroupe.saveOrUpdateGroupeContact(groupecontact);
		System.out.println("-------------------------------");
		daoContact.saveOrUpdateContact(contact);
	}

}
