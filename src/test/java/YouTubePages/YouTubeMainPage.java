package YouTubePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class YouTubeMainPage
{
    private static final String HOMEPAGE_URL = "https://www.youtube.com/";
    private WebElement searchInput;


    @FindBy(xpath = "   //*[@id=\"thumbnail\"]/yt-image/img")
    private WebElement firstVideo;


    private final WebDriver driver;
    public YouTubeMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public YouTubeMainPage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public YouTubeVideoPage clickOnFirstVideo()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "   //*[@id=\"thumbnail\"]/yt-image/img")));
        firstVideo.click();
        return new YouTubeVideoPage(driver);
    }
}
