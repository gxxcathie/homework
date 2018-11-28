package testPro2;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建serverSocket
        ServerSocket server = new ServerSocket(5234);
        System.out.println("服务已启动，等待连接");
        //调用accept方法等待客户端连接
        while(true){
            Socket socket = server.accept();
            System.out.println("客户端已连接...");
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    //接收客户端读入
                    try {
                        handle(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();*/
            ExecutorService executorService = Executors.newFixedThreadPool(10);
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        handle(socket);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            executorService.submit(()->{
                try {
                    handle(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    private static void handle(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        //给客户返回信息，输出流向客户端写入
        OutputStream out = socket.getOutputStream();
        while (true){
            byte[] bytes = new byte[1024 * 8];
            int len = in.read(bytes);
            if(len==-1){
                break;
            }
            String s = new String(bytes, 0, len, "utf-8");
            System.out.println(s);
            //给客户返回信息，输出流向客户端写入
            out.write(("服务器回答：" + s).getBytes());

        }
    }

}
