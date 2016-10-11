import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Start " + pjp.getSignature().getName() + " method");
        Object result = pjp.proceed();
        System.out.println("Finish " + pjp.getSignature().getName() + " method");
        return result;
    }
}
