package YouTubeTests;
import YouTubePages.SearchPage;
import YouTubePages.YouTubeMainPage;
import YouTubePages.YouTubeVideoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class PressLike extends CommonCondition {
    @Test
    public void PressLikeButtonOnFirstVideo() throws FileNotFoundException, InterruptedException
    {
        YouTubeVideoPage pressLike = new YouTubeMainPage(driver)
                .openPage()
                .clickOnFirstVideo().clickOnLikeButton();
        sleep(5000);
    }
    @Test
    public void ShareWithNewClip() throws FileNotFoundException, InterruptedException
    {
        YouTubeVideoPage NewClip = new YouTubeMainPage(driver)
                .openPage()
                .clickOnFirstVideo()
                .clickOnButtonShowOtherOptions()
                .clickOnButtonStartCrateNewClip()
                .fillTextareaWithNameOfClip("TestingClip")
                .fillAreaWithTimeOfStartClip("5")
                .fillAreaWithTimeOfEndClip("10")
                .clickOnButtonCreateNewClip()
                .clickOnButtonCopyLinkOnNewClip();
        sleep(5000);
    }
    @Test
    public void Subscribe() throws FileNotFoundException, InterruptedException
    {
        SearchPage NewClip = new YouTubeMainPage(driver)
                .openPage()
                .SearchVideoOrChanel("sasuke sama")
                .ClickOnSubscribeButton();
        sleep(5000);
    }
    @Test
    public void UnSubscribe() throws FileNotFoundException, InterruptedException
    {
        SearchPage NewClip = new YouTubeMainPage(driver)
                .openPage()
                .SearchVideoOrChanel("sasuke sama")
                .ClickOnAdditionalActions()
                .ClickUnSubscribeButton()
                .ClickYesUnSubscribeButton();
        sleep(5000);
    }
    @Test
    public void CreateAndFillPlaylist() throws FileNotFoundException, InterruptedException
    {
        YouTubeVideoPage NewClip = new YouTubeMainPage(driver)
                .openPage()
                .SearchVideoOrChanel("Iron Maiden - Fear of the Dark (На русском языке | Cover by RADIO TAPOK)")
                .ClickOnFirstVideo()
                .clickOnButtonShowOtherOptions()
                .clickSaveButton()
                .clickNewPlaylist()
                .writeNameAndCreatePlaylist("NewPlaylistWithRadioTapok")
                ;
        sleep(5000);
    }
    @Test
    public void DeletePlaylist() throws FileNotFoundException, InterruptedException
    {
        YouTubeMainPage NewClip = new YouTubeMainPage(driver)
                .openPage()
                .openListPlaylist()
                .clickOnNamePlaylist("NewPlaylistWithRadioTapok")
                .showOtherOptionForPlaylist()
                .deletePlaylist()
                .confirmDeletePlaylist()
                ;
        sleep(5000);
    }
}
