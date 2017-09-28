import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.List;

/**
 * Created by Splayd on 30.04.2017.
 */
@Aspect
public class LogAspect {
    @AfterReturning(pointcut = "execution( * Executor.getValidResults()))",
            returning = "result")
    public void onExecute(List result) throws Throwable {
//    @Before("execution( * Executor.*(Task))&& args(task))")
//    public void onExecute(Task task) throws Throwable {
//        System.out.println(task.toString());
//    @Around("execution( * Executor.*(..))")
//    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("LogAspect: Before execution of: " + pjp.getSignature().getName());
//        Object result = pjp.proceed();
//        System.out.println("LogAspect: After execution of: " + pjp.getSignature().getName());
//        return result;
        System.out.println("AOP results after returning: " + result.toString());
    }
}
