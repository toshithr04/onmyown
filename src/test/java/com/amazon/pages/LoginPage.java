package com.amazon.pages;

import com.amazon.TestCases.Login;
import com.amazon.Utils.ActionsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListenerException;

public class LoginPage {

    WebDriver driver;
    ActionsUtils actionsUtils;

    LoginPage(WebDriver driver,ActionsUtils actionsUtils){
        this.driver = driver;
        this.actionsUtils = actionsUtils;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[text()= \"First Name \"]/following-sibling::input[@name=\"name\"][1]")
    WebElement firstName;

    @FindBy(xpath = "//label[text()= \"Last Name\"]/following-sibling::input[@name=\"name\"][1]")
    WebElement lastName;

    @FindBy(xpath = "//label[text()= \"Email\"]/following-sibling::input[1]")
    WebElement email;

    @FindBy(xpath = "//button[@id = \"confirmBox\"]")
    WebElement clickButton;

    public void enterFirstName(){
        firstName.sendKeys("Toshith");


    }

    public void clickAlert(){
        clickButton.click();
    }

    public void enterEmail(){
        email.sendKeys("Toshith");
    }

    public void enterLastName(){
        lastName.sendKeys("Toshith");

    }



}
