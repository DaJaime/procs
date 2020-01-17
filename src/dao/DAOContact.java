package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entities.Contact;
import entities.IContact;
import entities.IPhone;
import entities.Phone;
import util.HibernateUtil;

public class DAOContact implements IDAOContact {

	@Override
	public void saveOrUpdateContact(IContact contact){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println(contact);
		session.saveOrUpdate(contact);
		tx.commit();
	}
	
	@Override
	public void deleteContact(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		IContact c = (IContact)session.get( Contact.class, id );
		session.delete(c);
		tx.commit();
	}
	
	@Override
	public IContact getContact(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		IContact c = (IContact) session.get(Contact.class, id);
		session.close();
		return c;
	}
	
	// HQL : retourne une liste de contact filtre sur le firstName
	@Override
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
	@Override
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
	
	// Criteria
	@Override
	public List getListContactFilterMail(String mail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List lst = (List) session.createCriteria(Contact.class).add(Restrictions.like("email", "la%")).list();
		if(!lst.isEmpty())
			return lst;
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see dao.IDAOContact#saveOrUpdatePhone(entities.Phone)
	 */
	
	@Override
	public void saveOrUpdatePhone(IPhone phone){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(phone);
		tx.commit();
	}
	
	@Override
	public void deletePhone(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		IPhone phone = (IPhone)session.get( Phone.class, id );
		session.delete(phone);
		tx.commit();
	}
	
	@Override
	public IPhone getPhone(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		IPhone phone = (IPhone) session.get(Phone.class, id);
		session.close();
		return phone;
	}
	
}
