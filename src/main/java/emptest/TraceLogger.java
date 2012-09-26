package emptest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TraceLogger {
	
	private static final Logger LOG = Logger.getLogger(TraceLogger.class);

	@Pointcut("execution(* emptest.EmployeeServiceImpl.*(..))")
	public void empTrace() {
	}

	@Before("empTrace()")
	public void log(JoinPoint joinPoint) {
		LOG.info("Before calling " + joinPoint.getSignature().getName()
				+ " with argument " + joinPoint.getArgs()[0]);
	}
	

}