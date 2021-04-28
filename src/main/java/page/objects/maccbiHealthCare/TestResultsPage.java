package page.objects.maccbiHealthCare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestResultsPage {

    @FindBy(xpath = "//div[@class='dropdown']/button")
    public WebElement ListTestFilterBtn;

    @FindBy(xpath = "//div[@data-hook='DropdownItem__FilterItem__category-ממוגרפיה__desktop']/button")
    public WebElement MemoFilterSelectedBtn;

    @FindBy(xpath = "//div[@class='TimeLineItem-module__header--3myWUcQq5-SZ8bG TimeLineCat__header--NIyrsu5cMgQVwIs pl-2']")
    public WebElement MemoTitle;

}
