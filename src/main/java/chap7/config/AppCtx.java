package chap7.config;

import chap7.aspect.CacheAspect;
import chap7.calc.Calculator;
import chap7.calc.RecCalculatorImpl;
import chap7.aspect.ExeTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)//@Aspect를 붙인 클래스를 공통 기능으로 적용하려면 @EnableAspectJAutoProxy가 필요함, @Enable 류의 에노테이션은 복잡한 스프링 설정을 대신해주는 기능을 가진다
public class AppCtx {
    @Bean
    public ExeTimeAspect exeTimeAspect(){
        return new ExeTimeAspect();
    }

    @Bean
    public CacheAspect cacheAspect(){ return new CacheAspect(); }

    @Bean
    public Calculator calculator(){
        return new RecCalculatorImpl();
    }
}
