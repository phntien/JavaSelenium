package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;
    private By newTitle = By.xpath("//h3");
    public WindowManager(WebDriver driver){
        this.driver=driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goToUrl(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for(String window : windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public String switchToTabandgetName(String tabTitle){
        String textVar = "";
        var windows = driver.getWindowHandles();
        for(String window : windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                textVar = driver.findElement(newTitle).getText();
            }
        }
        return textVar;
    }
}
