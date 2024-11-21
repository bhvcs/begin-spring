package chap5.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    //@Autowired(required=false)
    // @Autowired + @Nullable
    //@Autowired + private Optional<DateTimeFormatter> dateTimeFormatter
    private DateTimeFormatter dateTimeFormatter;
    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf(
                    "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf(
                    "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    @Autowired(required = false)//true라면 DateTimeFormatter가 없을 경우 빈이 없다는 오류가 나겠지, but false라면 무조건 가져와야되는 것은 아니기에 null로써 존재해도 되는거지
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    /*@Autowired
    public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt){
        if (formatterOpt.isPresent()) {
            this.dateTimeFormatter = formatterOpt.get();
        }else{
            this.dateTimeFormatter = null;
        }
    } 빈이 있다면 Optional안에 해당하는 값이 들어가고, 없다면 값이 없는 Optional이 넘어오는 것임
     */
//    @Autowired
//    public void setDAteFormatter(@Nullable DateTimeFormatter dateTimeFormatter) { @Nullable : 빈이 존재하지 않다면 null로
//        this.dateTimeFormatter = dateTimeFormatter;
//    }
//    @Autowired-false는 빈이 없으면 세터 메서드의 호출자체를 안함, but @Nullable은 호출을 한다
}
