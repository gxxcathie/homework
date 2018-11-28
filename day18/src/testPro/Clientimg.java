package testPro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Clientimg {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.3.123", 80);
        OutputStream out = socket.getOutputStream();
        out.write("GET /img/chrome.png HTTP/1.1\n".getBytes());
        out.write("Host: localhost\n".getBytes());
        out.write("\n".getBytes());
        out.write("\n".getBytes());
        InputStream in = socket.getInputStream();
        FileOutputStream stream = new FileOutputStream("e:/1.png");
        byte[] bytes = new byte[1024 * 8];
        while(true){
            int len = in.read(bytes);
            if(len==-1){
                break;
            }
            stream.write(bytes,0,len);
            stream.flush();
        }
        stream.close();
        socket.close();

    }
}
