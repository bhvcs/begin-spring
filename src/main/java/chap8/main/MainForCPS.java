package chap8.main;

import chap8.config.AppCtx;
import chap8.spring.ChangePasswordService;
import chap8.spring.MemberNotFoundException;
import chap8.spring.WrongPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        ChangePasswordService cps = ctx.getBean("changePasswordService", ChangePasswordService.class);
        try {
            cps.changePassword("madvirus@naver.com", "1234", "1111");
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (WrongPasswordException e) {
            System.out.println("암호가 올바르지 않습니다.");
        }

        ctx.close();
    }
}
