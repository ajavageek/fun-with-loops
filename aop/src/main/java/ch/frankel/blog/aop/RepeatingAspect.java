package ch.frankel.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RepeatingAspect {

    @Pointcut("@annotation(repeat) && call(* *(..))")
    public void callAt(Repeat repeat) {
    }

    @Around("callAt(repeat)")
    public Object around(ProceedingJoinPoint pjp, Repeat repeat) throws Throwable {
        for (int i = 0; i < repeat.times(); i++) {
            pjp.proceed();
        }
        return null;
    }
}
