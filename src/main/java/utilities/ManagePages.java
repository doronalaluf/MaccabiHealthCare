package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initMaccbiHealthCare (){

        Maccbilogin = PageFactory.initElements(driver,page.objects.maccbiHealthCare.LoginPage.class);
        MaccbiMain = PageFactory.initElements(driver, page.objects.maccbiHealthCare.MainPage.class);
        MaccbiActionAndInfo = PageFactory.initElements(driver, page.objects.maccbiHealthCare.ActionAndInfoPage.class);
        MaccbiVisitCardLess = PageFactory.initElements(driver, page.objects.maccbiHealthCare.VisitCardLessPage.class);
        MaccbiTestResults = PageFactory.initElements(driver, page.objects.maccbiHealthCare.TestResultsPage.class);
        MaccbiObligation = PageFactory.initElements(driver, page.objects.maccbiHealthCare.ObligationPage.class);
    }

    public static void initMortgage (){
        mortgageMain = new page.objects.mortgage.MainPage (mobileDriver);
    }
}
