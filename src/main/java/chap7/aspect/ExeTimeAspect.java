package chap7.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {

//    @Pointcut("execution(public * chap7.calc..*(..))")//chap7과 그 하위의 패키지에 위치한 public 메서드를 Pointcut으로 설정
//    public void publicTarget() {//pointcut의 execution 명시자는 Advice를 적용할 메서드를 지정할 떄 사용됨
//    }//private으로 하면 measure에서만 지정한 pointcut에 접근 가능하고, public으로 하면 다른 클래스에서도 사용할 수 있어, 공통 pointcut으로써 사용 가능
//
//    @Around("publicTarget()")
    @Around("CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("dddddddddddddddd");
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        }finally{
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                            (finish-start));
        }
    }
}
