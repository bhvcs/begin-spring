package chap03.spring;

import lombok.Setter;

@Setter
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
}
