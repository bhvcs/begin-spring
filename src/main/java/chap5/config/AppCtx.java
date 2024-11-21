package chap5.config;

import chap5.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chap5.spring")//spring패키지와 그 하위에 속한 클래스 중 scan 대상이 되는 애들만 ComponentScan하겠다.
public class AppCtx {

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
    //    @Bean
//    public MemberDao memberDao(){
//        return new MemberDao();
//    }
//    @Bean
//    public MemberRegisterService memberRegisterService(){
//        return new MemberRegisterService();
//    }
//    @Bean
//    public ChangePasswordService changePasswordService(){
//        //ChangePasswordService changePasswordService = new ChangePasswordService();
//        //changePasswordService.setMemberDao(memberDao());  @Autowired로 주입시킴
//        return new ChangePasswordService();
//    }
//    @Bean
//    public MemberListPrinter listPrinter() {
//        return new MemberListPrinter();
//    }
//    @Bean
//    public MemberInfoPrinter infoPrinter(){
////        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
////        infoPrinter.setMemberDao(memberDao());
////        infoPrinter.setPrinter(memberPrinter()); 세터에 @Autowired를 붙인 경우
//        return new MemberInfoPrinter();
//    }
}
