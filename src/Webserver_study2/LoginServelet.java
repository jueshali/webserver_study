package Webserver_study2;

/**
 * 项目名：webserver_study
 * 描述：实现service接口
 *
 * @author : Lpc
 * @date : 2019-07-16 17:59
 **/
public class LoginServelet implements Service {
    @Override
    public void service(){
        System.out.println("登录");
    }
}
