package chap8.config;

import chap8.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //@Transactional 애노테이션 활성화 설정, @Transaction이 붙은 빈 객체를 찾아서 알맞은 프록시 객체를 생성한다
public class AppCtx {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){//db connection 기능을 관장, db 연결 정보가 담겨있다
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/springUserfs?characterEncoding=utf8");
        ds.setUsername("springUser");
        ds.setPassword("spring");
        ds.setInitialSize(2); //미리 만들어 놓을 커넥션 개수
        ds.setMaxActive(10); //활성화 가능한(이용가능한) 커넥션 개수
        ds.setMaxIdle(10);
        ds.setTestWhileIdle(true); //유휴 커넥션 검사
        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); //최소 유휴 시간 3분
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); //10초 주기
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public MemberDao memberDao(){//bean 객체 설정에는 파라미터가 없는듯하다
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao());
        return changePasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        memberInfoPrinter.setMemberDao(memberDao());
        memberInfoPrinter.setPrinter(memberPrinter());
        return memberInfoPrinter;
    }
}
