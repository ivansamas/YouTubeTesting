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
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class YouTubeMainPage
{
    private static final String HOMEPAGE_URL = "https://www.youtube.com/";
    private WebElement searchInput;
    @FindBy(xpath = "   //*[@id=\"thumbnail\"]/yt-image/img")
    private WebElement firstVideo;
    @FindBy(xpath = "//*[@id=\"search-form\"]")
    private WebElement searchLineToClick;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/div/div[2]/input")
    private WebElement searchLine;
    @FindBy(xpath = "//*[@id=\"section-items\"]/ytd-guide-collapsible-entry-renderer")
    private WebElement openListPlaylist;
    @FindBy(xpath = "//*[@id=\"button-shape\"]/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement buttonShowOtherOptions;
    @FindBy(xpath = "//*[@id=\"items\"]/ytd-menu-service-item-renderer[5]")
    private WebElement buttonDeletePlaylist;
    @FindBy(xpath = "//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement buttonConfirm;

    private final WebDriver driver;
    public YouTubeMainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public YouTubeMainPage confirmDeletePlaylist(){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        buttonConfirm.click();
        return this;
    }
    public YouTubeMainPage deletePlaylist(){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "//*[@id=\"items\"]/ytd-menu-service-item-renderer[5]")));
        buttonDeletePlaylist.click();
        return this;
    }
    public YouTubeMainPage showOtherOptionForPlaylist(){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "//*[@id=\"button-shape\"]/button/yt-touch-feedback-shape")));
        buttonShowOtherOptions.click();
        return this;
    }
    public YouTubeMainPage clickOnNamePlaylist(String NameOfPlaylist){

        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "//*[@id=\"section-items\"]/ytd-guide-collapsible-entry-renderer")));
        String pathTOPlaylist = MessageFormat.format("//a[@title=\"{0}\"]", NameOfPlaylist);
        driver.findElement(By.xpath(pathTOPlaylist)).click();
        return this;

    }
    public YouTubeMainPage openListPlaylist()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(   "//*[@id=\"section-items\"]/ytd-guide-collapsible-entry-renderer")));
        openListPlaylist.click();
        return this;
    }
    public YouTubeMainPage openPage()
    {
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
    public SearchPage SearchVideoOrChanel(String nameChanelOrVideo) throws InterruptedException {
        searchLineToClick.click();
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/div/div[2]/input")));
        searchLine.sendKeys(nameChanelOrVideo);
        sleep(50);
        searchLine.sendKeys(Keys.RETURN);
        return new SearchPage(driver);
    }

}
