package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import entities.GroupeContact;
import entities.IGroupeContact;
import util.HibernateUtil;

public class DAOGroupeContact 
{
	public void saveOrUpdateGroupeContact(IGroupeContact groupecontact)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(groupecontact);
		tx.commit();
	}
	
	public void deleteGroupe(long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		IGroupeContact gc = (IGroupeContact)session.get( GroupeContact.class, id );
		session.delete(gc);
		tx.commit();
	}
}
