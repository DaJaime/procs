package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.IDAOContact;
import entities.Contact;
import entities.IContact;
import entities.IGroupeContact;
import entities.IPhone;
import service.ContactService;

public class InitDataBase 
{
	private static final String ha = "file:/Users/haseeb/Documents/procs/WebContent/WEB-INF/applicationContext.xml";
	private static final String da = "file:/Users/damjai/Desktop/MIAGE/M2/S1/Procs/workspace/procs/WebContent/WEB-INF/applicationContext.xml";

	public void init() 
	{
		ApplicationContext appContext = new FileSystemXmlApplicationContext(da);
		ContactService service = ContactService.getInstance();
		
		System.out.println("----------Test AROUND AOP------------------");
		IContact caop = new Contact("anthony", "nascimento", "antho@gmail.com");
		service.saveOrUpdateContact(caop);
		service.deleteContact(caop.getId());
		
		System.out.println("----------Peuplement data base------------------");
		
		IContact damien = (IContact)appContext.getBean("idContactDamien");
		IPhone damienPhone = (IPhone)appContext.getBean("idPhoneDamien");
		IContact haseeb = (IContact)appContext.getBean("idContactHaseeb");
		IPhone haseebPhone1 = (IPhone)appContext.getBean("idPhoneDamien");
		IPhone haseebPhone2 = (IPhone)appContext.getBean("idPhoneDamien");		
		service.saveOrUpdateContact(damien);
		service.saveOrUpdatePhone(damienPhone);
		service.saveOrUpdateContact(haseeb);
		service.saveOrUpdatePhone(haseebPhone1);
		service.saveOrUpdatePhone(haseebPhone2);
		
		IContact parisNanterre = (IContact)appContext.getBean("idEntrepriseParisNanterre");
		IPhone parisNanterrePhone = (IPhone)appContext.getBean("idPhoneParisNanterre");
		service.saveOrUpdateContact(parisNanterre);
		service.saveOrUpdatePhone(parisNanterrePhone);
		
		// Modif contact for test version
		damien.setFirstName("Modif1");
		service.saveOrUpdateContact(damien);
		damien.setFirstName("Modif2");
		service.saveOrUpdateContact(damien);
		damien.setFirstName("Dam");
		service.saveOrUpdateContact(damien);
		
		System.out.println("----------Test Cache------------------");
		IContact c = (Contact) service.getContact(1);
		System.out.println(c.getFirstName());
		
		IGroupeContact groupeMiageCll = (IGroupeContact)appContext.getBean("idGroupeMiageCll");
		IGroupeContact groupeMiageApp = (IGroupeContact)appContext.getBean("idGroupeMiageApp");
		service.saveOrUpdateGroupeContact(groupeMiageCll);
		service.saveOrUpdateGroupeContact(groupeMiageApp);
		
	}
}
