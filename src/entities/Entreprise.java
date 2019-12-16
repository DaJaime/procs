package entities;

public class Entreprise extends Contact{
	public String siret;
	
	public Entreprise() {
		
	}
	
	public Entreprise(String firstName, String lastName, String email, String siret) {
		super(firstName, lastName, email);
		this.siret = siret;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	@Override
	public String toString() {
		return super.toString() + "Entreprise [siret=" + siret + "]";
	}
	
	
}
