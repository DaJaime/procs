package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.IDAOContact;
import entities.Contact;
import entities.IContact;
import entities.IGroupeContact;
import entities.IPhone;
import service.GroupeService;

public class InitDataBase 
{
	private static final String ha = "file:/Users/haseeb/Documents/procs/WebContent/WEB-INF/applicationContext.xml";
	private static final String da = "file:/Users/damjai/Desktop/MIAGE/M2/S1/Procs/workspace/procs/WebContent/WEB-INF/applicationContext.xml";

	public void init() 
	{
		ApplicationContext appContext = new FileSystemXmlApplicationContext(da);
		IDAOContact dao = (IDAOContact)appContext.getBean("idDaoContact");
		
		System.out.println("----------Test AROUND AOP------------------");
		IContact caop = new Contact("anthony", "nascimento", "antho@gmail.com");
		dao.saveOrUpdateContact(caop);
		dao.deleteContact(caop.getId());
		
		System.out.println("----------Peuplement data base------------------");
		
		IContact damien = (IContact)appContext.getBean("idContactDamien");
		IPhone damienPhone = (IPhone)appContext.getBean("idPhoneDamien");
		IContact haseeb = (IContact)appContext.getBean("idContactHaseeb");
		IPhone haseebPhone1 = (IPhone)appContext.getBean("idPhoneDamien");
		IPhone haseebPhone2 = (IPhone)appContext.getBean("idPhoneDamien");		
		dao.saveOrUpdateContact(damien);
		dao.saveOrUpdatePhone(damienPhone);
		dao.saveOrUpdateContact(haseeb);
		dao.saveOrUpdatePhone(haseebPhone1);
		dao.saveOrUpdatePhone(haseebPhone2);
		
		IGroupeContact groupeMiageCll = (IGroupeContact)appContext.getBean("idGroupeMiageCll");
		IGroupeContact groupeMiageApp = (IGroupeContact)appContext.getBean("idGroupeMiageApp");
		GroupeService gs = new GroupeService();
		gs.saveOrUpdateGroupeContact(groupeMiageCll);
		gs.saveOrUpdateGroupeContact(groupeMiageApp);
		
		IContact parisNanterre = (IContact)appContext.getBean("idEntrepriseParisNanterre");
		IPhone parisNanterrePhone = (IPhone)appContext.getBean("idPhoneParisNanterre");
		dao.saveOrUpdateContact(parisNanterre);
		dao.saveOrUpdatePhone(parisNanterrePhone);
		
		// Modif contact for test version
		//damien.setFirstName("Modif1");
		//dao.saveOrUpdateContact(damien);
		//damien.setFirstName("Modif2");
		//dao.saveOrUpdateContact(damien);
		//damien.setFirstName("Dam");
		//dao.saveOrUpdateContact(damien);
		
		System.out.println("----------Test Cache------------------");
		IContact c = (Contact) dao.getContact(1);
		System.out.println(c.getFirstName());
		
	}
}
