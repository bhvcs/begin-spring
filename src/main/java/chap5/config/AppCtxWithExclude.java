package chap5.config;

import chap5.spring.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "chap5.spring",//지정하는 것이 두개 이상일 떄 집합기호 쓰는겨
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))//MemberDao 제외
public class AppCtxWithExclude {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
}

//@Configuration
//@ComponentScan(basePackages = "chap5.spring",.
//        excludeFilters = { @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao")),//MemberDao 제외
//                           @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MemberDao.class)}
//public class AppCtxWithExclude {
//    @Bean
//    public MemberDao memberDao(){
//        return new MemberDao();
//    }
//}