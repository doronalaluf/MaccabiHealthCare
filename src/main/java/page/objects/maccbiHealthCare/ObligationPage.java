package page.objects.maccbiHealthCare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObligationPage {
    @FindBy(xpath = "//textarea[@inputclassname='TextArea-module__inputClassName--2O6fRdbiUOxAXHa']")
    public WebElement RequestTextField;

    @FindBy(xpath = "//button[@class='SingleDatePickerInput_calendarIcon SingleDatePickerInput_calendarIcon_1']")
    public WebElement ObligationDatePicker;

    @FindBy(xpath = "//*[contains(@class, 'today')]")
    public WebElement TodayDate;

    @FindBy (xpath = "//*[@data-hook='UploadBaseWrapper']//input")
    public WebElement AddFile;


}
