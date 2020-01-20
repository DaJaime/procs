package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.GroupeContact;
import entities.IContact;
import entities.IGroupeContact;
import util.HibernateUtil;

public class DAOGroupeContact implements IDAOGroupeContact 
{
private SessionFactory sessionFactory;
	
	public DAOGroupeContact(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdateGroupeContact(IGroupeContact groupecontact)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(groupecontact);
	}
	
	@Override
	public void deleteGroupe(long id){
		IGroupeContact gc = (IGroupeContact)sessionFactory.getCurrentSession().get( GroupeContact.class, id );
		sessionFactory.getCurrentSession().delete(gc);
	}
}
