package chap7;

import chap7.aspect.ExeTimeAspect;
import chap7.calc.RecCalculatorImpl;
import chap7.config.AppCtx;
import chap7.calc.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx.class);

        //Calculator cal = ctx.getBean("calculator", Calculator.class);//AppCtx에 등록된 빈 설정을 확인
        //Calculator cal = ctx.getBean("calculator", RecCalculatorImpl.class);//AppCtx에 등록된 빈 설정을 확인
        //AOP가 만드는 빈 객체의 클래스가 인터페이스를 상속 받았다면, 프록시 객체는 해당 인터페이스를 상속받아 생성된다.
        Calculator cal = ctx.getBean("calculator", RecCalculatorImpl.class);//AppCtx에 등록된 빈 설정을 확인
        //@EnableAspectJAutoProxy(proxyTargetClass = true)로 하면 프록시 객체 타입은 인터페이스가 아닌 클래스를 상속받아 생성됨
        System.out.println(ctx.getBean("exeTimeAspect", ExeTimeAspect.class));
        long fiveFact = cal.factorial(5);
        System.out.println("cal.factorial(5) = " + fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
