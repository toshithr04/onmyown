package com.amazon.pages;

import com.amazon.Utils.ActionsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.latest.page.Page;

public class Pages {
    WebDriver driver;

    private LoginPage loginPage;
    private ActionsUtils actionsUtils;

    public Pages(WebDriver driver){
        this.driver = driver;

    }

    public LoginPage initLoginPage(){
        if (loginPage ==null){
            loginPage = new LoginPage(driver,actionsUtils);
        }
        return loginPage;
    }

    public ActionsUtils actionsUtils(){
        if (actionsUtils ==null){
            actionsUtils = new ActionsUtils(driver);
        }
        return actionsUtils;
    }
}
