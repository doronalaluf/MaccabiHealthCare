package page.objects.maccbiHealthCare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisitCardLessPage {
    @FindBy (xpath = "//div[@class='ButtonPicker-module__wrap--3rMHwWCQa3n1Yi_ mb-1 btn-group']/button")
    public WebElement ReasonBtn;

    @FindBy (xpath = "//button[@class='Button-module__btn--25h1qIR7QWxLzum Button-module__btn-primary--18i_AYoM_eDfiHS btn btn-primary']")
    public WebElement ConferBtn;

    @FindBy (xpath = "//h2[@class='Headline-module__h4--TqEHnFoXfWOl0lB mb-5']")
    public WebElement SuccessText;




}
