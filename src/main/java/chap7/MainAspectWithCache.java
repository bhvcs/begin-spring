package chap7;

import chap7.aspect.ExeTimeAspect;
import chap7.calc.Calculator;
import chap7.calc.RecCalculatorImpl;
import chap7.config.AppCtx;
import chap7.config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class MainAspectWithCache {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
        Calculator cal = ctx.getBean("calculator", Calculator.class);
        cal.factorial(7);
        cal.factorial(7);
        cal.factorial(5);
        cal.factorial(5);

        ctx.close();
    }
}
