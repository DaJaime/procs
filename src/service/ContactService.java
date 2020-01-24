package service;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.DAOContact;
import dao.IDAOContact;
import entities.Contact;
import entities.GroupeContact;
import entities.IContact;
import entities.IGroupeContact;
import entities.IPhone;
import entities.Phone;

public class ContactService 
{
	private static final String ha = "file:/Users/haseeb/Documents/procs/WebContent/WEB-INF/applicationContext.xml";
	private static final String da = "file:/Users/damjai/Desktop/MIAGE/M2/S1/Procs/workspace/procs/WebContent/WEB-INF/applicationContext.xml";
	
	IDAOContact dao;
	private static ContactService INSTANCE = null;
	
	private ContactService()
	{
		ApplicationContext appContext = new FileSystemXmlApplicationContext(ha);
		dao = (IDAOContact)appContext.getBean("idDaoContact");
	}
	
	public static ContactService getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new ContactService(); 
        }
        return INSTANCE;
    }
	
	public void saveOrUpdateContact(IContact contact){
		dao.saveOrUpdateContact(contact);
	}
	
	public void deleteContact(long id){
		dao.deleteContact(id);
}
	
	public IContact getContact(long id){
		IContact c = dao.getContact(id);
		return c;
	}
	
	public List<Contact> getListContactFilterFirstName(String firstName) {
		List<Contact> listContact = dao.getListContactFilterFirstName(firstName);
		return listContact;
	}
	
	public List getListContactFilterlastName(String lastName) {
		List listContact = dao.getListContactFilterlastName(lastName);
		return listContact;
	}
	
	public List getListContactFilterMail(String mail) {
		List listContact = dao.getListContactFilterMail(mail);
		return listContact;
	}
	/********************************************
	 **                 Phone                 ***
	 ********************************************/
	
	public void addPhone(IContact contact, Phone phone) {
		phone.setContact(contact);
		contact.getPhones().add(phone);
		dao.saveOrUpdateContact(contact);
		dao.saveOrUpdatePhone(phone);
	}
	
	public void saveOrUpdatePhone(IPhone phone){
		dao.saveOrUpdatePhone(phone);
	}
	
	public void deletePhone(long id){
		dao.deletePhone(id);
	}
	
	public IPhone getPhone(long id) {
		IPhone p = dao.getPhone(id);
		return p;
	}
	
	/********************************************
	 **                 Groupe                ***
	 ********************************************/
	
	public void saveOrUpdateGroupeContact(IGroupeContact groupecontact)
	{
		dao.saveOrUpdateGroupeContact(groupecontact);
	}
	
	//permet d'ajouter un contact dans un groupe
	public void addContactGroupe(GroupeContact groupecontact, Contact contact) 
	{
		groupecontact.getContacts().add(contact);
		contact.getGroupeContact().add(groupecontact);
		dao.saveOrUpdateGroupeContact(groupecontact);
		dao.saveOrUpdateContact(contact);	
	}
	
	//permet de supprimer un contact d'un groupe
	public void deleteContactGroupe(IGroupeContact groupecontact, IContact contact)
	{		
		groupecontact.getContacts().remove(contact);
		contact.getGroupeContact().remove(groupecontact);
		System.out.println("-------------------------------");
		dao.saveOrUpdateContact(contact);
	}
	
}
