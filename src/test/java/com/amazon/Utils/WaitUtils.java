package com.amazon.Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class WaitUtils {


    WebDriver driver;
    WebDriverWait wait;


    public WaitUtils(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofMillis(10000));
    }

    public void clickWhenReady(WebElement element){
        WebElement elementReturn = wait.until(ExpectedConditions.elementToBeClickable(element));
        elementReturn.click();
    }

    public WebElement elementIsVisible(WebElement element, WebDriver driver, Duration duration){
        WebElement elementReturn = new WebDriverWait(driver,duration).until(ExpectedConditions.visibilityOf(element));

        return elementReturn;
    }

    public void alertAccept(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void alerSendKeys(String s){
       Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
       alert.sendKeys("Toshith");
       alert.accept();
    }

    public void alerCheckBox() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);


    }



    public void alertCancel(){
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }





}