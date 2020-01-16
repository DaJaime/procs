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
import entities.IContact;
import entities.Phone;

public class ContactService 
{
	IDAOContact dao;
	
	public ContactService()
	{
		ApplicationContext appContext = new FileSystemXmlApplicationContext(
				"file:/Users/damjai/Desktop/MIAGE/M2/S1/Procs/workspace/procs/WebContent/WEB-INF/applicationContext.xml");
		dao = (IDAOContact)appContext.getBean("idDaoContact");
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
