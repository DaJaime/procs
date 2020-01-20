package dao;

import entities.IGroupeContact;

public interface IDAOGroupeContact {

	void saveOrUpdateGroupeContact(IGroupeContact groupecontact);

	void deleteGroupe(long id);

}