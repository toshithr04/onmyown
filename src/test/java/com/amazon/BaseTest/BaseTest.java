package com.amazon.BaseTest;

import com.amazon.Base.Base;
import com.amazon.CommonUtils.CreateFolderUtil;
import com.amazon.Utils.ActionsUtils;
import com.amazon.Utils.WaitUtils;
import com.amazon.pages.Pages;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public class BaseTest extends Base {

    protected ActionsUtils actionsUtils;
    protected WaitUtils waitUtils;

    @BeforeSuite
    public void beforeSuiteSetup() throws IOException {
        CreateFolderUtil.createMainFolder();

    }

    @BeforeMethod
    public void setupdriver(){
        setDriverThreadLocaldriver();
        actionsUtils = new ActionsUtils(getDriver());
        waitUtils = new WaitUtils(getDriver());
        setPages();


    }

//    @AfterMethod
//    public void teardown1(){
//        teardown();
//    }
}
