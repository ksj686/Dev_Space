package app.labs.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // 모든 클래스의 모든 메서드에 적용되는 Pointcut
    @Pointcut("execution(* app.labs..*(..))")
    public void anyMethod() {}  // 빈 메서드, Pointcut을 지정하는 역할

    // Around Advice: 메서드 실행 전후에 로깅을 출력
    @Around("anyMethod()")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();  // 메서드 이름 가져오기
        System.out.println("[Log] Executing method: " + methodName);

        long startTime = System.nanoTime();  // 메서드 실행 전 시간 기록
        try {
            // 실제 메서드 실행
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.nanoTime();  // 메서드 실행 후 시간 기록
            System.out.println("[Log] Method " + methodName + " executed in " + (endTime - startTime) + " ns");
        }
    }
}