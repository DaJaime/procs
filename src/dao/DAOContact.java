package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	
	// HQL : retourne une liste de contact filtre sur le firstName
	public List<Contact> getListContactFilterFirstName(String firstName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer requet = new StringBuffer();
		requet.append("select contact from Contact as contact where contact.firstName like '");
		requet.append(firstName);
		requet.append("%'");
		Query requete = session.createQuery(requet.toString());
		List<Contact> resultats = requete.list();
		
		if(!resultats.isEmpty())
			return resultats;
		else
			return null;
	}
	
	// SQL : retourne une liste de contact filtre sur le lastName
	public List getListContactFilterlastName(String lastName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer requet = new StringBuffer();
		requet.append("select ID_CONTACT from Contact where LASTNAME like '");
		requet.append(lastName);
		requet.append("%'");
		SQLQuery query = session.createSQLQuery(requet.toString());
		List lst = query.list();
		
		if(!lst.isEmpty())
			return lst;
		else
			return null;
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
