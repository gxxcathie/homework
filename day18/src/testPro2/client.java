package testPro2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.56.1", 5234);
        OutputStream out = socket.getOutputStream();
        //out.write("好好学习java".getBytes());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner sc = new Scanner(System.in);
                    while(sc.hasNextLine()){
                        String s = sc.nextLine();
                        out.write(s.getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        InputStream in = socket.getInputStream();
        while(true){
            byte[] bytes = new byte[1024 * 8];
            int len = in.read(bytes);
            if(len==-1){
                break;
            }
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }

    }
}
