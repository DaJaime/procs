package dao;

import java.util.List;

import entities.Contact;
import entities.IContact;
import entities.IGroupeContact;
import entities.IPhone;

public interface IDAOContact {

	void saveOrUpdateContact(IContact contact);

	void deleteContact(long id);

	IContact getContact(long id);

	// HQL : retourne une liste de contact filtre sur le firstName
	List<Contact> getListContactFilterFirstName(String firstName);

	// SQL : retourne une liste de contact filtre sur le lastName
	List getListContactFilterlastName(String lastName);

	// Criteria
	List getListContactFilterMail(String mail);

	/********************************************
	 **                 Phone                 ***
	 ********************************************/

	void saveOrUpdatePhone(IPhone phone);

	void deletePhone(long id);

	IPhone getPhone(long id);

	void saveOrUpdateGroupeContact(IGroupeContact groupecontact);

	void deleteGroupe(long id);

}