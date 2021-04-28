package utilities;

import exstensions.UIActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import workflows.WebFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {


    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void initBrowser(String browserType) {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid BrowserType");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        driver.get(getData("url"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        ManagePages.initMaccbiHealthCare ();
        action = new Actions(driver);
        js = (JavascriptExecutor)driver;
        date = new Date();
    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("appiumServer")), dc);
        } catch (Exception e) {
            System.out.println("can not connect to appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("Timeout")));
    }

    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic("admin","admin");
    }


    public void startSession ()
    {
        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else
            throw new RuntimeException("Invalid Platform Name");
    }


    public void closeSession(){
        if (platform.equalsIgnoreCase("web"))
                driver.quit();
            else
                mobileDriver.quit();
        }

    @AfterMethod
    public void AfterMethod () {
        closeSession();
    }

    @Parameters({"PlatformName"})
    @BeforeMethod
        public void BeforeMethod (Method method, String PlatformName){
        platform = PlatformName;
        startSession();
        if(platform.equalsIgnoreCase("web")) {
            driver.get(getData("url"));
            WebFlows.Login("4242", "123456");
            UIActions.UnReadMessages(MaccbiMain.UnreadMessagesBtn);
        }
            if (!platform.equalsIgnoreCase("api")) {
                try {
                    monteScreenRecorder.startRecord(method.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }