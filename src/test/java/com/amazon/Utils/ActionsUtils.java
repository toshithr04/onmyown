package com.amazon.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    WebDriver driver;
    private final Actions actions;

    public ActionsUtils(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }




    public void doubleClickElement(WebElement element){
        actions.doubleClick(element).perform();
    }

    public void contextClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement destination){
        actions.dragAndDrop(source,destination).perform();
    }

    public void hover(WebElement element){
        actions.moveToElement(element).perform();
    }

    public void keyCombination(Keys key, String letter){
        actions.keyDown(key).sendKeys(letter).keyDown(key).perform();

    }

}
