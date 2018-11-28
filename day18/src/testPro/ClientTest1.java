package testPro;

import java.io.*;
import java.net.Socket;

public class ClientTest1 {
    public static void main(String[] args) throws IOException {
        //新建SOCKET对象
        Socket socket = new Socket("192.168.3.123", 80);
        //发送数据输出流
        OutputStream out = socket.getOutputStream();
        //按照http协议请求格式发送请求
        out.write("GET /index.html HTTP/1.1\n".getBytes());
        out.write("Host: localhost\n".getBytes());
        out.write("\n".getBytes());
        out.write("\n".getBytes());
        //客户端接收响应输入流
        InputStream in = socket.getInputStream();
        //包装成字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        //每次读一行
        while(true){
            String line = reader.readLine();
            if(line==null){
                break;
            }
            System.out.println(line);
        }
        socket.close();

    }
}
