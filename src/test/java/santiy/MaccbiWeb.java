package santiy;

import exstensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;
import java.util.List;


@Listeners(utilities.Listeners.class)
public class MaccbiWeb extends CommonOps {

    @Test (description = "test01 - Verify Login")
    @Description ("This Test Verify Login")
    public static void Test01_VerifyLogin() {
            Verifications.VerifyHelloText(MaccbiMain.HelloText, "שלום");
        }


    @Test (description = "test02 - Verify Visit With Out Card")
    @Description ("This Test Verify Visit With Out Card")
    public static void Test02_VerifyVisitWithOutCard(){
        WebFlows.VisitWithOutCard();
        Verifications.VerifyText(MaccbiVisitCardLess.SuccessText, "ביקור ללא כרטיס אושר בהצלחה");
    }

    @Test (description = "test03 - Verify Results Test")
    @Description ("This Test Verify Filter Test Results")
    public static void Test03_VerifyFilterTestResults (){
        WebFlows.TestResults();
        Verifications.VerifyText(MaccbiTestResults.MemoTitle.getText() , "ממוגרפיה");
        List<WebElement> Mamo = driver.findElements(By.xpath("//div[@class='TimeLineItem-module__header--3myWUcQq5-SZ8bG TimeLineCat__header--NIyrsu5cMgQVwIs pl-2']"));
        for (WebElement Mamos : Mamo) {
            Verifications.VerifyText(Mamos.getText(), "ממוגרפיה");
        }
    }

    @Test (description = "test04 - Verify Obligation Request")
    @Description ("This Test Verify Obligation Request")
    public static void Test04_VerifyObligationRequest () throws InterruptedException {
        WebFlows.ObligationNewRequest();
    }
}
