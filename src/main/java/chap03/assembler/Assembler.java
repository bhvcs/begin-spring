package chap03.assembler;

import chap03.spring.ChangePasswordService;
import chap03.spring.MemberDao;
import chap03.spring.MemberRegisterService;
import lombok.Getter;


@Getter
public class Assembler {//조립기는 객체를 생성하고 의존 객체를 주입한다
    private MemberDao memberDao;
    private MemberRegisterService memberRegisterService;
    private ChangePasswordService changePasswordService;

    public Assembler(){
        memberDao = new MemberDao();//cacheMemberDao를 이용하고 싶다면 여기만 수정하면 됨
        memberRegisterService = new MemberRegisterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }
}
