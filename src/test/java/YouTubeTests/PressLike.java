package YouTubeTests;
import YouTubePages.YouTubeMainPage;
import YouTubePages.YouTubeVideoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class PressLike
{
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void initChromeDriver()
    {
        var options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("user-data-dir=C:/UserData");
        driver = new ChromeDriver(options);

    }
    @Test
    public void PressLikeButtonOnFirstVideo() throws FileNotFoundException, InterruptedException
    {
        YouTubeVideoPage openFirstVideo = new YouTubeMainPage(driver)
                .openPage()
                .clickOnFirstVideo().clickOnLikeButton();
        sleep(10000);
    }
    @Test
    public void ShareWithNewClip() throws FileNotFoundException, InterruptedException
    {
        YouTubeVideoPage openFirstVideo = new YouTubeMainPage(driver)
                .openPage()
                .clickOnFirstVideo()
                .clickOnButtonShowOtherOptions()
                .clickOnButtonStartCrateNewClip().fillTextareaWithNameOfClip("TestingClip")
                .fillAreaWithTimeOfStartClip("5")
                .fillAreaWithTimeOfEndClip("10")
                .clickOnButtonCreateNewClip()
                .clickOnButtonCopyLinkOnNewClip();
        sleep(10000);
    }
    @AfterMethod(alwaysRun = true)
    public void exitDriver(){
        driver.quit();
    }

}
