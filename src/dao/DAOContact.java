package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entities.Contact;
import entities.GroupeContact;
import entities.IContact;
import entities.IGroupeContact;
import entities.IPhone;
import entities.Phone;
import util.HibernateUtil;

public class DAOContact implements IDAOContact {
	
	private SessionFactory sessionFactory;
	
	public DAOContact(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdateContact(IContact contact){
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}
	
	@Override
	public void deleteContact(long id){
		IContact c = (IContact)sessionFactory.getCurrentSession().get( Contact.class, id );
		sessionFactory.getCurrentSession().delete(c);
	}
	
	@Override
	public IContact getContact(long id) {
		IContact c = (IContact) sessionFactory.getCurrentSession().get(Contact.class, id);
		return c;
	}
	
	// HQL : retourne une liste de contact filtre sur le firstName
	@Override
	public List<Contact> getListContactFilterFirstName(String firstName) {
		StringBuffer requet = new StringBuffer();
		requet.append("select contact from Contact as contact where contact.firstName like '");
		requet.append(firstName);
		requet.append("%'");
		Query requete = sessionFactory.getCurrentSession().createQuery(requet.toString());
		List<Contact> resultats = requete.list();
		
		if(!resultats.isEmpty())
			return resultats;
		else
			return null;
	}
	
	// HQL : retourne une liste de contact
	@Override
	public List<Contact> getListContact() 
	{
		Query requete = sessionFactory.getCurrentSession().createQuery("select * from Contact;");
		List<Contact> resultats = requete.list();
		
		if(!resultats.isEmpty())
			return resultats;
		else
			return null;
	}
	
	// SQL : retourne une liste de contact filtre sur le lastName
	@Override
	public List getListContactFilterlastName(String lastName) {
		StringBuffer requet = new StringBuffer();
		requet.append("select ID_CONTACT from Contact where LASTNAME like '");
		requet.append(lastName);
		requet.append("%'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(requet.toString());
		List lst = query.list();
		
		if(!lst.isEmpty())
			return lst;
		else
			return null;
	}
	
	// Criteria
	@Override
	public List getListContactFilterMail(String mail) {
		List lst = (List) sessionFactory.getCurrentSession().createCriteria(Contact.class).add(Restrictions.like("email", "la%")).list();
		if(!lst.isEmpty())
			return lst;
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see dao.IDAOContact#saveOrUpdatePhone(entities.Phone)
	 */
	/*------------------Phones-----------------*/
	@Override
	public void saveOrUpdatePhone(IPhone phone){
		sessionFactory.getCurrentSession().saveOrUpdate(phone);
	}
	
	@Override
	public void deletePhone(long id){
		IPhone phone = (IPhone)sessionFactory.getCurrentSession().get( Phone.class, id );
		sessionFactory.getCurrentSession().delete(phone);
	}
	
	@Override
	public IPhone getPhone(long id) {
		IPhone phone = (IPhone) sessionFactory.getCurrentSession().get(Phone.class, id);
		return phone;
	}
	
	/*------------------Groupes-----------------*/
	
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
