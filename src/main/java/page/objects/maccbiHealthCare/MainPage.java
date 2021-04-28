package page.objects.maccbiHealthCare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy (xpath = "//div[@class='profileInner']/span")
    public WebElement HelloText;

    @FindBy (id = "ctl00_ctl00_wcSiteHeaderLobby1_wcSiteHeaderNavigationMenu_rptNavigationMenuHeader_ctl03_lnkHref")
    public WebElement ActionAndInfoBtn;

    @FindBy (id = "ctl00_ctl00_MainPlaceHolder_Body_wcHomeUserPersonalNavMenu_rptUserPersonalMenu_ctl02_imgOuter")
    public WebElement TestResultsBtn;

    @FindBy (xpath = "//button[@class='ui-button ui-widget ui-corner-all close_btn']")
    public WebElement UnreadMessagesBtn;

    @FindBy(id = "ctl00_ctl00_MainPlaceHolder_Body_wcHomeUserPersonalNavMenu_rptUserPersonalMenu_ctl02_lnkCatData")
    public WebElement ResultsTestBtn;

    @FindBy(id = "ctl00_ctl00_MainPlaceHolder_Body_wcHomeUserPersonalNavMenu_rptUserPersonalMenu_ctl03_imgOuter")
    public WebElement ObligationRequestBtn;

}
