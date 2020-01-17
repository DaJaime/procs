package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import entities.IContact;

public class AspectContact 
{
	
	public void beforeLog(IContact contact)
	{
		System.out.println("je suis " + contact.getFirstName() + " et je suis affiché grâce aux AOP(Before).");
	}
	
	public void aroundLog(ProceedingJoinPoint pjp, long id) throws Throwable
	{
		if(id != 1)
		{
			System.out.println("je supprime l'id: "+id+" (AOP around)");
			pjp.proceed();	
		}
		else
		{
			System.out.println("je supprime pas l'id: "+id+" (AOP around)");
		}
	}
	
}
