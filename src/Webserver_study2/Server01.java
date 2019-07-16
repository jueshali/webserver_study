package Webserver_study2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 项目名：webserver_study
 * 描述：目标封装相应信息
 *
 * @author : Lpc
 * @date : 2019-07-16 21:30
 **/
public class Server01 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server01 server01 =new Server01();
        server01.start();
        server01.receive();
    }

    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }

    }
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            InputStream is =client.getInputStream();

            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
            Response response = new Response(client);
            StringBuilder content = new StringBuilder();
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("success");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("This is the data you get from service");
            response.print("</body>");
            response.print("</html>");

           response.pushToBrower(200);


        } catch (IOException e) {
            System.out.println("客户端错误");
            e.printStackTrace();
        }
        System.out.println("一个客户端建立了连接");
    }
    public void end(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
