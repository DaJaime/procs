package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Phone;
import util.HibernateUtil;

public class DAOPhone {
	
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
		return phone;
	}
}
