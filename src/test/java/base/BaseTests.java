package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    //private EventFiringWebDriver driver;
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //driver = new ChromeDriver(getChromeOptions());
        //driver.register(new EventReporter());
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        goToHomePage();
        //setCookie();
    }

    //    public void setUp() {
    //        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //        driver = new ChromeDriver();
    //        //driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
    //        //driver = new ChromeDriver(getChromeOptions());
    //        //driver.register(new EventReporter());
    //        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //        goToHomePage();
    //        //setCookie();
    //    }


    @BeforeMethod
    public void goToHomePage() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123").domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }
}
