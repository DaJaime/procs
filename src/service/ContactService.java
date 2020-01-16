package service;

import java.util.List;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.DAOContact;
import dao.IDAOContact;
import entities.Contact;
import entities.Phone;

public class ContactService 
{
	IDAOContact dao;
	
	public ContactService()
	{
		dao = new DAOContact();
		ApplicationContext appContext = new FileSystemXmlApplicationContext("File:/Users/haseeb/Documents/procs/WebContent/WEB-INF/applicationContext.xml");
		IDAOContact idaocontact=(IDAOContact)appContext.getBean("idDaoContact");
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
