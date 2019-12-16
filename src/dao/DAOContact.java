package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import entities.Phone;
import util.HibernateUtil;

public class DAOContact {

	public void saveOrUpdateContact(Contact contact, Phone phone)
	{
		contact.getPhones().add(phone);
		phone.setContact(contact);
		contact.getPhones().add(phone);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(contact);
		session.saveOrUpdate(phone);
		tx.commit();
	}
	
	public void deleteContact(long id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Contact c = (Contact)session.get(Contact.class, id );
		session.delete(c);
		tx.commit();
	}
	
	public Contact getContact(long id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Contact c = (Contact) session.get(Contact.class, id);
		return c;
	}
	
}
