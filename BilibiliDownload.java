import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BilibiliDownload {
    static String root = "/Users/bytedance/Documents/98766352/";

    static String target = "/Users/bytedance/Documents/MiaoSha/";
    public static void main(String[] args) {
        for (int i = 1; i <= 144 ; i++) {
            String title = null;
            try {
                title = getTitle(i);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            String audioName = root + i + "/64/audio.m4s";
            String videoName = root + i + "/64/video.m4s";
            String targetName = target + title + ".mp4";
            System.out.println("开始解析：" + title);
            parse(audioName, videoName, targetName);
            System.out.println(title);
            System.out.println("解析完成：" + targetName);
        }
    }


    public static void parse(String audioName, String videoName, String targetName)
    {
        //ffmpeg -i  video.m4s -i audio.m4s -vcodec copy -acodec copy 1.mp4
        String[] command = {"ffmpeg", "-i", videoName, "-i", audioName, "-vcodec",
                "copy", "-acodec", "copy", targetName};

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTitle(Integer i) throws IOException {
        String jsonLocation = root + i + "/entry.json";
        String content = new String(Files.readAllBytes(Paths.get(jsonLocation)));
        String page_date = JSON.parseObject(content).get("page_data").toString();
        String title = JSON.parseObject(page_date).get("part").toString();
        return title;
    }
}
