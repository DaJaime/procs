package service;

import dao.DAOPhone;
import entities.Phone;

public class PhoneService 
{
	private DAOPhone dao;
	
	public PhoneService()
	{
		dao = new DAOPhone();
	}
	
	public void saveOrUpdateContact(Phone phone)
	{
		dao.saveOrUpdatePhone(phone);
	}
	
	public void deletePhone(long id)
	{
		dao.deletePhone(id);
	}
	
	public Phone getPhone(long id)
	{
		Phone p = dao.getPhone(id);
		return p;
	}
}
