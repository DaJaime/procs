package dao;

import java.util.List;

import entities.Contact;
import entities.Phone;

public interface IDAOContact {

	void saveOrUpdateContact(Contact contact);

	void deleteContact(long id);

	Contact getContact(long id);

	// HQL : retourne une liste de contact filtre sur le firstName
	List<Contact> getListContactFilterFirstName(String firstName);

	// SQL : retourne une liste de contact filtre sur le lastName
	List getListContactFilterlastName(String lastName);

	// Criteria
	List getListContactFilterMail(String mail);

	/********************************************
	 **                 Phone                 ***
	 ********************************************/

	void saveOrUpdatePhone(Phone phone);

	void deletePhone(long id);

	Phone getPhone(long id);

}