package service;

import dao.DAOContact;
import entities.Contact;
import entities.Phone;

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
	
	/********************************************
	 **                 Phone                 ***
	 ********************************************/
	
	public void addPhone(Contact contact, Phone phone) {
		phone.setContact(contact);
		contact.getPhones().add(phone);
		dao.saveOrUpdateContact(contact);
		dao.saveOrUpdatePhone(phone);
	}
	
	public void saveOrUpdatePhone(Phone phone){
		dao.saveOrUpdatePhone(phone);
	}
	
	public void deletePhone(long id){
		dao.deletePhone(id);
	}
	
	public Phone getPhone(long id) {
		Phone p = dao.getPhone(id);
		return p;
	}
	
}
