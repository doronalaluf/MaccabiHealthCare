package page.objects.maccbiHealthCare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//li[@class='col-6 nav-item']")
    public WebElement btn_EnterWithPassword;

    @FindBy(xpath = "//input[@id='identifyWithPasswordCitizenId']")
    public WebElement txt_UserID;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txt_Password;

    @FindBy(xpath = "//button[@class='submit validatePassword']")
    public WebElement btn_login;
}
