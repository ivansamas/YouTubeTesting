package YouTubeTests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonCondition {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void initChromeDriver()
    {

        driver = DriverSingleton.getDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void exitDriver(){
        DriverSingleton.closeDriver();
    }
}
