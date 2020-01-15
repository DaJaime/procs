package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import entities.GroupeContact;
import util.HibernateUtil;

public class DAOGroupeContact 
{
	public void saveOrUpdateGroupeContact(GroupeContact groupecontact)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(groupecontact);
		tx.commit();
	}
	
	public void deleteGroupe(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		GroupeContact gc = (GroupeContact)session.get( GroupeContact.class, id );
		session.delete(gc);
		tx.commit();
	}
}
