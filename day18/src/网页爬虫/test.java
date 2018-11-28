package 网页爬虫;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    static String TIEBA_URL = "https://tieba.baidu.com/p/2256306796?red_tag=1781367364";
    static Pattern pattern = Pattern.compile("<img class=\"BDE_Image\" src=\"(.*?)\"");
    static final String SAVE_PREFIX = "D:\\IdeaProjects\\homework\\img";
    //
    //	爬虫地址：	https://tieba.baidu.com/p/2256306796?red_tag=1781367364
    public static void main(String[] args) throws IOException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //抓取网页
        String s = handle(TIEBA_URL);
        //找到匹配的照片
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            String group = matcher.group(1);
            pool.submit(()->{
                try {
                    download(group,SAVE_PREFIX);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();

    }

    private static void download(String group, String savePrefix) throws IOException{
        HttpURLConnection conn= (HttpURLConnection)
                new URL(group).openConnection();
        String path = savePrefix + group.substring(group.lastIndexOf("/") + 1);
        InputStream in = conn.getInputStream();
        FileOutputStream stream = new FileOutputStream(path);
        byte[] bytes = new byte[1024 * 8];
        while(true){
            int len = in.read(bytes);
            if(len==-1){
                break;
            }
            stream.write(bytes,0,len);
            stream.flush();
        }

    }

    private static String handle(String url) throws IOException {
        HttpURLConnection connection= (HttpURLConnection)
                new URL(url).openConnection();
        InputStream in = connection.getInputStream();
        //包装成字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        StringBuilder sb = new StringBuilder(1024 * 1024);
        //每次读一行
        while(true){
            String line = reader.readLine();
            if(line==null){
                break;
            }
            //System.out.println(line);
            sb.append(line);
        }
        return (sb.toString());
        
    }

}
