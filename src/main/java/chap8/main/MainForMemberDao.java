package chap8.main;

import chap8.config.AppCtx;
import chap8.spring.Member;
import chap8.spring.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {
    private static MemberDao memberDao;//왜 static이지 my: 이 클래스 안의 static 메서드 안에서 사용하기 위함인듯(static 변수만 사용 가능하니깐)

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        memberDao = ctx.getBean("memberDao", MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        ctx.close();
    }

    private static void selectAll() {
        System.out.println("----- selectAll");
        int total = memberDao.count();;
        System.out.println("전체 데이터: " + total);
        List<Member> members = memberDao.selectAll();
        for (Member m : members) {
            System.out.println(m.getId() + ":" + m.getEmail() + ":" + m.getName());
        }
    }

    private static void updateMember(){
        System.out.println("----- updateMember");
        Member member = memberDao.selectByEmail("madvirus@naver.com");//memberDao: db와 스프링 프로그램을 연결시켜주는 창구 같음
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);

        memberDao.update(member);
        System.out.println("암호 변경: " + oldPw + " > " + newPw);
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");

    private static void insertMember(){
        System.out.println("----- insertMember");

        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(prefix + "@test.com",
                prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println(member.getId() + "데이터 추가");
    }
}
