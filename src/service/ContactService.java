package service;

import dao.DAOContact;
import entities.Contact;

public class ContactService {
	DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();	
	}
	
	public void saveOrUpdateContact(Contact contact){
		dao.saveOrUpdateContact(contact);
	}
	
	public void deleteContact(long id){
		dao.deleteContact(id);
	}
	
	public Contact getContact(long id){
		Contact c = dao.getContact(id);
		return c;
	}
}
