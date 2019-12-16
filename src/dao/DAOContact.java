package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import entities.Phone;
import util.HibernateUtil;

public class DAOContact {

	public void saveOrUpdateContact(Contact contact){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(contact);
		tx.commit();
	}
	
	public void deleteContact(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Contact c = (Contact)session.get( Contact.class, id );
		session.delete(c);
		tx.commit();
	}
	
	public Contact getContact(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Contact c = (Contact) session.get(Contact.class, id);
		session.close();
		return c;
	}
	
	/********************************************
	 **                 Phone                 ***
	 ********************************************/
	
	public void saveOrUpdatePhone(Phone phone){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(phone);
		tx.commit();
	}
	
	public void deletePhone(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Phone phone = (Phone)session.get( Phone.class, id );
		session.delete(phone);
		tx.commit();
	}
	
	public Phone getPhone(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Phone phone = (Phone) session.get(Phone.class, id);
		session.close();
		return phone;
	}
	
}
