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

import static java.lang.Thread.sleep;

public class SearchPage {

    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"subscribe-button\"]/ytd-subscribe-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement SubscribeButton;
    @FindBy(xpath = "//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement AdditionalActions;
    @FindBy(xpath = "//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]/tp-yt-paper-item/yt-formatted-string")
    private WebElement UnSubscribeButton;
    @FindBy(xpath = "//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")
    private WebElement YesUnSubscribeButton;
    @FindBy(xpath = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail/a/yt-image/img")
    private WebElement FirstVideo;
    public SearchPage(WebDriver driver)
        {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public SearchPage ClickOnAdditionalActions()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer-next/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        AdditionalActions.click();
        return this;
    }
    public SearchPage ClickYesUnSubscribeButton()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"confirm-button\"]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        YesUnSubscribeButton.click();
        return this;
    }
    public SearchPage ClickUnSubscribeButton()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]/tp-yt-paper-item/yt-formatted-string")));
        UnSubscribeButton.click();
        return this;
    }
    public SearchPage ClickOnSubscribeButton()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"subscribe-button\"]/ytd-subscribe-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        SubscribeButton.click();
        return this;
    }
    public YouTubeVideoPage ClickOnFirstVideo() throws InterruptedException {
        sleep(100);
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail/a/yt-image/img")));
        FirstVideo.click();
        return new YouTubeVideoPage(driver);
    }
}
