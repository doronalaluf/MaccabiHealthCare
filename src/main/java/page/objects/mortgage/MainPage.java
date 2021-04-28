package page.objects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage (AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }


    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;

    @AndroidFindBy(id = "etTerm")
    public AndroidElement txt_Term;

    @AndroidFindBy(id = "etRate")
    public AndroidElement txt_Rate;

    @AndroidFindBy(id = "btnCalculate")
    public AndroidElement btn_Calculate;

    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement txt_Repayment;
}
