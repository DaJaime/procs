package entities;

public class Phone implements IPhone {
	private long id;
	private String number;
	private String desc;
	private IContact contact = null;
	
	public Phone(){
	}
	
	public Phone(String numero, String description)
	{
		this.number = numero;
		this.desc = description;
	}
	
	@Override
	public long getId()
	{
		return this.id;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String getNumber()
	{
		return this.number;
	}
	
	@Override
	public String getDesc()
	{
		return this.desc;
	}
	
	@Override
	public void setNumber(String numero)
	{
		this.number = numero;
	}
	
	@Override
	public void setDesc(String description)
	{
		this.desc = description;
	}
	
	@Override
	public IContact getContact() {
		return contact;
	}

	@Override
	public void setContact(IContact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
