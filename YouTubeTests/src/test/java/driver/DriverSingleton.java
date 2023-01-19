package driver;

import YouTubePages.YouTubeVideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DriverSingleton
{
    private static WebDriver driver;
    public static WebDriver getDriver()
    {
        if(null == driver)
        {
                    var options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("user-data-dir=C:/UserData");
                    driver = new ChromeDriver(options);
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
