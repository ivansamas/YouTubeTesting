package YouTubePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
public class YouTubeVideoPage
{

    private WebElement searchInput;


    @FindBy(xpath = "  //*[@id=\"segmented-like-button\"]/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement buttonLike;

    @FindBy(xpath = "  //*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement buttonShowOtherOptions;
    @FindBy(xpath = "  //*[@id=\"items\"]/ytd-menu-service-item-renderer[1]/tp-yt-paper-item")
    private WebElement buttonStartCrateNewClip;
    @FindBy(xpath = " //*[@id=\"textarea\"]")
    private WebElement textareaWithNameOfClip;
    @FindBy(xpath = "//input[@placeholder='Время начала']  ")       //*[@id="start"]
    private WebElement areaWithTimeOfStartClip;
    @FindBy(xpath = " //input[@placeholder='Время окончания'] ")  //*[@id="end"]
    private WebElement areaWithTimeOfEndClip;
    @FindBy(xpath = " //*[@id=\"share\"]/yt-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")  //*[@id="end"]
    private WebElement buttonCreateNewClip;
    @FindBy(xpath = " //*[@id=\"copy-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement buttonCopyLinkOnNewClip;
    @FindBy(xpath = " //*[@id=\"text\"]")
    private WebElement windowSuccessfulCopyLinkOnNewClip;
    private final WebDriver driver;
    public YouTubeVideoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public YouTubeVideoPage clickOnLikeButton()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "   //*[@id=\"segmented-like-button\"]/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        buttonLike.click();
        return this;
    }
    public YouTubeVideoPage clickOnButtonShowOtherOptions()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "  //*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]")));
        buttonShowOtherOptions.click();
        return this;
    }
    public YouTubeVideoPage clickOnButtonStartCrateNewClip()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( " //*[@id=\"items\"]/ytd-menu-service-item-renderer[1]/tp-yt-paper-item")));
        buttonStartCrateNewClip.click();
        return this;
    }
    public YouTubeVideoPage fillTextareaWithNameOfClip(String nameOfClip)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "  //*[@id=\"start\"]")));
        textareaWithNameOfClip.sendKeys(nameOfClip);;
        return this;
    }
    public YouTubeVideoPage fillAreaWithTimeOfStartClip(String timeOfStartClip)
    {
        areaWithTimeOfStartClip.sendKeys(timeOfStartClip);
        return this;
    }
    public YouTubeVideoPage fillAreaWithTimeOfEndClip(String timeOfEndClip)
    {
        areaWithTimeOfEndClip.sendKeys(timeOfEndClip);
        return this;
    }
    public YouTubeVideoPage clickOnButtonCreateNewClip()
    {
        buttonCreateNewClip.click();
        return this;
    }
    public YouTubeVideoPage clickOnButtonCopyLinkOnNewClip()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( " //*[@id=\"copy-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        buttonCopyLinkOnNewClip.click();
        return this;
    }
}
