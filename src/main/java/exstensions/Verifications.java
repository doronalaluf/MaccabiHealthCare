package exstensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

public class Verifications {

    @Step("Verify Hello Text")
    public static void VerifyHelloText (WebElement elem , String ExpectedText){
        assertEquals (elem.getText().split(",")[0], ExpectedText);
    }

    @Step("Verify Text")
    public static void VerifyText (WebElement elem , String ExpectedText) {
        assertEquals(elem.getText(), ExpectedText);
    }

    @Step ("Verify Text on Text")
    public static void VerifyText (String actual , String expected){
        assertEquals(actual , expected);
    }
}
