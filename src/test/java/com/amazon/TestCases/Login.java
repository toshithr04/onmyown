package com.amazon.TestCases;

import com.amazon.BaseTest.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Login extends BaseTest {

//    @Test(dataProvider = "data", dataProviderClass = DataFullProvider.class)
//    @TestDataAnnotation(value = "C:\\Users\\vrtosh\\Videos\\OnmyOwn\\OnMyOwn\\src\\test\\resources\\Time.xlsx", type = "excel")
//    public void launchBrowser(Map<String,String> data){
//
//        System.out.println(data.get("Username"));
//        System.out.println(data.get("Password"));
//    }
//
//    @Test(, dataProvider = "data", dataProviderClass = DataFullProvider.class)
//    @TestDataAnnotation(value = "C:\\Users\\vrtosh\\Videos\\OnmyOwn\\OnMyOwn\\src\\test\\resources\\LoginJson.json", type = "json")
//    public void launchBrowser_1(Map<String,String> data){
//
//        System.out.println(data.get("Username"));
//        System.out.println(data.get("Password"));
//    }
//
//    @Test
//    public void test() throws InterruptedException {
//        getDriver().get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
//
//        getPages().initLoginPage().enterFirstName();
//        Thread.sleep(1000);
//        getPages().initLoginPage().enterLastName();
//        Thread.sleep(1000);
//        getPages().initLoginPage().enterEmail();
//        System.out.println("1");
//
//    }



    @Test
    public void test1() throws InterruptedException, AWTException {
        getDriver().get("https://www.hyrtutorials.com/p/alertsdemo.html");
        getPages().initLoginPage().clickAlert();
        Thread.sleep(2000);
        waitUtils.alerCheckBox();
        Thread.sleep(2000);
    }

    @Test
    public void testx() throws Exception{
        getDriver().get("https://www.amazon.in/");

        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//button[text() = \"Continue shopping\"]")).click();
        Thread.sleep(5000);
        getDriver().findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("pendrive");
        Thread.sleep(5000);
        List<WebElement> ele = getDriver().findElements(By.cssSelector("div.s-suggestion-container div[role = \"button\"]"));


        for (int i = 0; i < ele.size(); i++) {


            System.out.println(ele.get(i).getAttribute("aria-label"));
        }
    }

}
