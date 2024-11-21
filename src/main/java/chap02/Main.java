package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("스프링");
        System.out.println(msg);

        //singleton
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println("g1 == g2 => " + (g1 == g2));

//        결과는 true이다. 별도의 설정을 하지 않는 경우 싱글톤이 적용되어 하나의 @Bean에 대해
//        하나의 객체만 만들 수 있기 때문이다
        ctx.close();
    }
}
