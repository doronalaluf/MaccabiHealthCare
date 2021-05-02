package workflows;

import exstensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class WebFlows extends CommonOps {

   @Step("Business Flow: Login")
    public static void Login(String user, String password){
        UIActions.click(Maccbilogin.btn_EnterWithPassword);
        UIActions.updateText(Maccbilogin.txt_UserID, user);
        UIActions.updateText(Maccbilogin.txt_Password, password);
        UIActions.click(Maccbilogin.btn_login);
    }

    @Step("Business Flow: Visit With Out Card")
    public static void VisitWithOutCard (){
        UIActions.click(MaccbiMain.ActionAndInfoBtn);
        UIActions.click(MaccbiActionAndInfo.VisitCardLessBtn);
        UIActions.click(MaccbiVisitCardLess.ReasonBtn);
        UIActions.click(MaccbiVisitCardLess.ConferBtn);
    }

    @Step ("Business Flow: Filter Test Results")
    public static void TestResults () {
        UIActions.click(MaccbiMain.ResultsTestBtn);
        UIActions.click(MaccbiTestResults.ListTestFilterBtn);
        UIActions.MouseHover(MaccbiTestResults.MemoFilterSelectedBtn);
    }

    @Step ("Business Flow: Obligation Request")
    public static void ObligationNewRequest () throws InterruptedException {
        UIActions.click(MaccbiMain.ObligationRequestBtn);
        UIActions.updateText(MaccbiObligation.RequestTextField, "בקשה חדשה");
        UIActions.click(MaccbiObligation.ObligationDatePicker);
        UIActions.click(MaccbiObligation.TodayDate);
        WebElement attacheFile = driver.findElement(By.xpath("//*[@data-hook='UploadBaseWrapper']//input"));
        attacheFile.sendKeys("C:\\Users\\doronalaluf\\Desktop\\עתיד האוטומציה - חומרי קורס_files\\clickhere.png");
        Thread.sleep(3000);
        Thread.sleep(4000);
        }
    }

