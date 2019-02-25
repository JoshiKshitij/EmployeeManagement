package application;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

	Logger logger = Logger.getLogger(this.getClass());

	// @Before("pointCut()")
	/*
	 * @After("within( application..* )") void AdviceFOrGetMEthod() {
	 * System.out.println("logging was called in aspect"); }
	 */

	
	 @Pointcut("within(application..*)") void pointCut() { }
	  
	@Around("pointCut()")
	Object getMethodAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature() + " " + Arrays.toString(joinPoint.getArgs()) + " result ->>"
				+ joinPoint.proceed());
		return joinPoint.proceed();
	}
}
