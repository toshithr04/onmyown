package com.amazon.Utils;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;


public class DataFullProvider {


    @DataProvider(name = "data")
    public Object[][] excel(Method method) throws IOException {

        String test = method.getAnnotation(TestDataAnnotation.class).type();
        String path =  method.getAnnotation(TestDataAnnotation.class).value();

        if (test.equals("excel")){
            return ExcelReader.excelRead(path);
        }else {
            return JsonToObject.jsonToExcel(path);
        }

    }
}
