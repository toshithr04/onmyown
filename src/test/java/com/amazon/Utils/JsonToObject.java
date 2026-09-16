package com.amazon.Utils;

import com.amazon.JsonPOJO;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JsonToObject {




    @DataProvider(name = "JSONData")
    public static Object[][] jsonToExcel(String filename) throws IOException {

        FileReader reader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(reader);
        Gson gson = new Gson();
        JsonPOJO[] pojo = gson.fromJson(bufferedReader, JsonPOJO[].class);

        int len = pojo.length;

        Object[][] data = new Object[len][1];
        Map<String,String> map =null;

        for (int i = 0; i < len; i++) {
            map = new HashMap<>();

            map.put("Username", pojo[i].getUsername());
            map.put("Password", pojo[i].getPassword());

            data[i][0] = map;
        }

        return data;


    }

}
