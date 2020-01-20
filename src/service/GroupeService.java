package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.DAOContact;
import dao.DAOGroupeContact;
import dao.IDAOContact;
import dao.IDAOGroupeContact;
import entities.Contact;
import entities.GroupeContact;
import entities.IContact;
import entities.IGroupeContact;

public class GroupeService 
{
	private static final String ha = "file:/Users/haseeb/Documents/procs/WebContent/WEB-INF/applicationContext.xml";
	private static final String da = "file:/Users/damjai/Desktop/MIAGE/M2/S1/Procs/workspace/procs/WebContent/WEB-INF/applicationContext.xml";
	
	IDAOGroupeContact daoGroupe;
	IDAOContact daoContact;
	
	public GroupeService()
	{
		ApplicationContext appContext = new FileSystemXmlApplicationContext(da);
		daoGroupe = (IDAOGroupeContact)appContext.getBean("idDaoGroupeContact");
		daoContact = (IDAOContact)appContext.getBean("idDaoContact");
		
	}
	
	public void saveOrUpdateGroupeContact(IGroupeContact groupecontact)
	{
		daoGroupe.saveOrUpdateGroupeContact(groupecontact);
	}
	
	//permet d'ajouter un contact dans un groupe
	public void addContactGroupe(GroupeContact groupecontact, Contact contact) 
	{
		groupecontact.getContacts().add(contact);
		contact.getGroupeContact().add(groupecontact);
		daoGroupe.saveOrUpdateGroupeContact(groupecontact);
		daoContact.saveOrUpdateContact(contact);	
	}
	
	//permet de supprimer un contact d'un groupe
	public void deleteContactGroupe(IGroupeContact groupecontact, IContact contact)
	{		
		groupecontact.getContacts().remove(contact);
		contact.getGroupeContact().remove(groupecontact);
		//daoGroupe.saveOrUpdateGroupeContact(groupecontact);
		System.out.println("-------------------------------");
		daoContact.saveOrUpdateContact(contact);
	}

}
