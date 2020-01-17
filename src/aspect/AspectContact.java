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
		if(id < 3)
		{
			System.out.println("je retourne à mon habitude. (AOP around)");
			pjp.proceed();	
		}
		else
		{
			System.out.println("je contourne. (AOP around)");
		}
	}
	
}
