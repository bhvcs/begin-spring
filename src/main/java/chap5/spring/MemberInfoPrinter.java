package chap5.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("infoPrinter")//이 값은 빈으로 등록할 때 사용할 이름이다.
public class MemberInfoPrinter {
    private MemberDao memberDao;//세터에서 의존성 주입
    private MemberPrinter printer;

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            System.out.println("데이터 없음\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired//메서드에 @Autowired를 적용하면 해당 메서드의 파라미터 타입의 빈을 자동 주입해주는 것이다.
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
