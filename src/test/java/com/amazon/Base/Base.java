package com.amazon.Base;

import com.amazon.pages.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {

    // Safely reads system properties
    private static final String browser = System.getProperty("Browser", "firefox");

    // This is the ONLY variable that should hold your driver references
    private static final ThreadLocal<WebDriver> driverThreadLocaldriver = new ThreadLocal<>();
    private static final ThreadLocal<Pages> loadpages = new ThreadLocal<>();

    /**
     * Helper method to initialize the driver locally on the calling thread.
     * REMOVED the static 'driver' field to ensure absolute thread isolation.
     */
    private WebDriver createLocalDriverInstance() {
        WebDriver localDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            // Selenium 4 handles binary downloads automatically; no WebDriverManager needed!
            localDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new FirefoxDriver();
        }

        return localDriver;
    }

    /**
     * Securely sets the freshly spawned driver instance into the ThreadLocal registry.
     */
    public void setDriverThreadLocaldriver() {
        WebDriver isolatedDriver = createLocalDriverInstance();
        if (isolatedDriver != null) {
            driverThreadLocaldriver.set(isolatedDriver);
        }
    }

    /**
     * Thread-safe global getter used by your Page Objects and Test lifecycle steps.
     */
    public static WebDriver getDriver() {
        return driverThreadLocaldriver.get();
    }

    public static void setPages(){
        loadpages.set(new Pages(getDriver()));
    }


    public static Pages getPages(){
        return loadpages.get();
    }


    /**
     * Completely terminates the current thread's browser process and cleans up memory.
     */
    public void teardown() {
        WebDriver activeDriver = getDriver();
        Pages pages = getPages();
        if (activeDriver != null && pages != null) {
            activeDriver.quit();// Close the browser binary process
            driverThreadLocaldriver.remove();
            loadpages.remove();// Wipe the ThreadLocal memory slot
        }
    }
}
