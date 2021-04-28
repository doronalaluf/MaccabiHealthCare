package exstensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;

public class UIActions extends CommonOps {

    @Step ("Click on Element")
    public static void click (WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("Update text Element")
    public static void updateText (WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step ("Update dropDown Element")
    public static void dropDown (WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select element = new Select(elem);
        element.selectByVisibleText(text);
    }

    @Step ("Close popup UnRead Messages From Doctor")
    public static void UnReadMessages (WebElement elem){
        try {
            Thread.sleep(1000);
            if (elem.isDisplayed())
                click(elem);
        }
        catch(Exception e)
        {
            System.out.println("No Popup UnRead Messages From Doctor");
        }
    }

    @Step ("Move To Element")
    public static void MouseHover (WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).click().build().perform();
    }

    @Step ("Scroll To Element")
    public static void ScrollToElement (WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    @Step ("Add File")
    public static void AddFile (WebElement elem , String path) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(path);
    }
}
