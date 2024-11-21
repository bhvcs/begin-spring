package chap4.config;

import chap03.spring.MemberDao;
import chap03.spring.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//->스프링 설정 클래스
public class AppConf1 {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }



    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

}
