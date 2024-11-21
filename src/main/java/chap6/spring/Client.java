package chap6.spring;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
public class Client implements InitializingBean, DisposableBean {

    private String host;
    
    @Override
    public void destroy() throws Exception {
        System.out.println("Client.destroy() 실행");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Client.afterPropertiesSet() 실행");
    }
    
    public void send(){
        System.out.println("Client.send() to " + host);
    }
    //빈 객체가 InitializingBean을 상속하면 구현한 afterPropertiesSet() 메서드가,
    //DisposableBean을 상속하면 destroy 메서드가 실행된다. 각각 초기화, 소멸 과정에서 호출됨
}
