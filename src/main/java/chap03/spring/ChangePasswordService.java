package chap03.spring;

import com.sun.security.jgss.GSSUtil;
import lombok.Setter;

@Setter
public class ChangePasswordService {
    private MemberDao memberDao; //@setter로 의존하는 memerDao객체를 주입받는다

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);

        if (member == null) {
            System.out.println("membernotfoundexception");
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);


    }
}
