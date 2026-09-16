package com.amazon.CommonUtils;

;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CreateFolderUtil {


    public static Map<String,String>  createMainFolder() throws IOException {
        HashMap<String,String> map = new HashMap<>();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String date = localDateTime.format(formatter);
        Path folderpath = Paths.get("C:\\Users\\vrtosh\\Videos\\OnmyOwn\\OnMyOwn\\src\\test\\Output", date);
        String name = Files.createDirectories(folderpath).toString();
        map.put("Report" , createReportFolder(name));
        map.put("ScreenShot" , createScreenShotFolder(name));
        System.out.println(map);
        return map;

    }

    private static String createReportFolder(String path) throws IOException {

        Path folderpath = Paths.get(path, "Report");
        String name = Files.createDirectories(folderpath).toString();
        return name;

    }

    private static String createScreenShotFolder(String path) throws IOException {

        Path folderpath = Paths.get(path, "Screenshot");
        String name = Files.createDirectories(folderpath).toString();
        return name;

    }


}
