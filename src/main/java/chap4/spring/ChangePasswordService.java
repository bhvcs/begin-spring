package chap4.spring;

//import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

//@Setter
public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

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
