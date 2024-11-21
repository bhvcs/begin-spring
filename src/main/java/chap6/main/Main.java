package chap6.main;

import chap6.config.AppCtx;
import chap6.spring.ClientS;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        ClientS client = ctx.getBean(ClientS.class);
        client.send();

        ctx.close();
    }
}
