package entities;

public interface IPhone {

	long getId();

	void setId(long id);

	String getNumber();

	String getDesc();

	void setNumber(String numero);

	void setDesc(String description);

	IContact getContact();

	void setContact(IContact contact);

	int hashCode();

	boolean equals(Object obj);

}