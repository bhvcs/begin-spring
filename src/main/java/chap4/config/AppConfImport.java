package chap4.config;

import chap03.spring.MemberDao;
import chap03.spring.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConf2.class)//AppConf2도 설정파일로써 사용하겠다는 거고, 이거 하나만 ctx에 등록하면 AppConf2는 안해도됨
public class AppConfImport {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }



    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
}
//
//@Configuration
//@Import(AppConf1.class, AppConf2.class)//AppConf2도 설정파일로써 사용하겠다는 거고, 이거 하나만 ctx에 등록하면 AppConf2는 안해도됨
//public class AppConfImport {}
//이렇게 하면 설정 파일들이 추가 되더라도 최상위의 AppConfImport에만 수정하면 되니깐 편리하지 않겠냐