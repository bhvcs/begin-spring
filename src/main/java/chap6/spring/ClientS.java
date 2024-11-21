package chap6.spring;

import lombok.Setter;

@Setter
public class ClientS{

    private String host;

    public void close(){
        System.out.println("Client2.close() 실행");
    }

    public void connect() {
        System.out.println("Client2.connect() 실행");
    }
    
    public void send(){
        System.out.println("Client2.send() to " + host);
    }
    //빈 객체가 InitializingBean을 상속하면 구현한 afterPropertiesSet() 메서드가,
    //DisposableBean을 상속하면 destroy 메서드가 실행된다. 각각 초기화, 소멸 과정에서 호출됨
}
