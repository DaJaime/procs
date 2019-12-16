package service;

import dao.DAOContact;
import entities.Contact;
import entities.Phone;

public class ContactService 
{
	DAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();	
	}
	
	public void saveOrUpdateContact(Contact contact, Phone phone)
	{
		dao.saveOrUpdateContact(contact, phone);
	}
	
	public void deleteContact(long id)
	{
		dao.deleteContact(id);
	}
	
	public Contact getContact(long id)
	{
		Contact c = dao.getContact(id);
		return c;
	}
	
}
