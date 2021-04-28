package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static JavascriptExecutor js;
    protected static String platform;
    protected static Date date;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;


    //Page Objects - web
    protected static page.objects.maccbiHealthCare.LoginPage Maccbilogin;
    protected static page.objects.maccbiHealthCare.MainPage MaccbiMain;
    protected static page.objects.maccbiHealthCare.ActionAndInfoPage MaccbiActionAndInfo;
    protected static page.objects.maccbiHealthCare.VisitCardLessPage MaccbiVisitCardLess;
    protected static page.objects.maccbiHealthCare.TestResultsPage MaccbiTestResults;
    protected static page.objects.maccbiHealthCare.ObligationPage MaccbiObligation;

    //Page Objects - mobile
    protected static page.objects.mortgage.MainPage mortgageMain;

    }
