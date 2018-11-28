package testPro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientURL {
    public static void main(String[] args) throws IOException {
        HttpURLConnection connection= (HttpURLConnection)
                new URL("http://192.168.3.123:80/img/chrome.png").openConnection();
        InputStream in = connection.getInputStream();
        FileOutputStream out = new FileOutputStream("e:\1.png");
        byte[] bytes = new byte[1024 * 8];
        while (true){
            int len = in.read(bytes);
            if(len==-1){
                break;
            }
            out.write(bytes,0,len);
            out.flush();
        }
        in.close();
        out.close();
        connection.disconnect();

    }
}
