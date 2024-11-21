package chap7.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CacheAspect {//cache기능을 구현한 공통 기능으로써, ExeTimeAspect와 함께 두가지의 공통 기능이 동시에 적용될 수 있는 지 확인하기
    private Map<Long, Object> cache = new HashMap<>();

    //@Pointcut("execution(public * chap7.calc..*(long))")//1
//    public void cacheTarget() {
//    }

    //@Around("cacheTarget()")
////    @Around("execution(public * chap7.calc..*(long))")//2
//    @Around("ExeTimeAspect.publicTarget()")
    @Around("CommonPointcut.commonTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        Long num = (Long) joinPoint.getArgs()[0];//joinPoint는 대상이 되는 메서드인게 아닐까, 지금은 거기서 파라미터를 확인하는거지`
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect: Cache에서 구함[%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();//CacheAspect의 대상 객체는 ExeTimeAspect의 measure이고, Exe~의 대상 객체는 실제 대상 객체인 Rec~
        cache.put(num, result);
        System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
        return result;
    }
}
