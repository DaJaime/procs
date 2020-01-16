package service;

import dao.DAOContact;
import dao.DAOGroupeContact;
import dao.IDAOContact;
import entities.Contact;
import entities.GroupeContact;
import entities.IContact;

public class GroupeService 
{
	
	DAOGroupeContact daoGroupe;
	IDAOContact daoContact;
	
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
	
	public void deleteContactGroupe(GroupeContact groupecontact, IContact contact)
	{		
		groupecontact.getContacts().remove(contact);
		contact.getGroupeContact().remove(groupecontact);
		//daoGroupe.saveOrUpdateGroupeContact(groupecontact);
		System.out.println("-------------------------------");
		daoContact.saveOrUpdateContact(contact);
	}

}
