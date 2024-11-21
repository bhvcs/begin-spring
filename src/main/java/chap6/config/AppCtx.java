package chap6.config;

import chap6.spring.Client;
import chap6.spring.ClientS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {
    @Bean
    @Scope("prototype") //bean 객체가 싱글톤이 아니게 하기(<-> @Scope("singleton"))
    public Client client(){
        Client client = new Client();
        client.setHost("host");
        return client;
    }/* 프로토타입의 빈은 싱클톤과 다르게 완전한 라이프사이클을 따르지 않음.
    스프링 컨테이너가 빈 객체의 생성, 프로퍼티를 설정, 초기화까지는 하는데 컨테이너가 종료할 때 빈 객체를 소멸을 주관하지 않음.
    그래서 프로토타입의 빈 소멸을 위한 코드를 직접 입력해야함*/

    @Bean(initMethod = "connect", destroyMethod = "close")
    public ClientS client2(){
        ClientS client = new ClientS();
        client.setHost("host");
        return client;
    }
}
