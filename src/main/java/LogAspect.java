import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class LogAspect {

    public Object logging(MethodInvocationProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Start " + pjp.getSignature().getName() + " method ");
        Object result = pjp.proceed();
        System.out.println("Finish " + pjp.getSignature().getName() + " method");
        return result;
    }
}
