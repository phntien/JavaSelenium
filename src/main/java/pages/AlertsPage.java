package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertsButton = By.xpath("//button[text()=\"Click for JS Alert\"]");
    private By triggerCofirmButton = By.xpath("//button[text()=\"Click for JS Confirm\"]");
    private By triggerPromptButton = By.xpath("//button[text()=\"Click for JS Prompt\"]");
    private By resultLabel = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAlertsButton(){
        driver.findElement(triggerAlertsButton).click();
    }

    public void clickOnConfirmButton(){
        driver.findElement(triggerCofirmButton).click();
    }

    public void clickOnPromptButton(){
        driver.findElement(triggerPromptButton).click();
    }

    public void clickAcceptonAlertsPopup(){
        driver.switchTo().alert().accept();
    }

    public void clickDismissPopup(){
        driver.switchTo().alert().dismiss();
    }

    public String getResult(){
        return driver.findElement(resultLabel).getText();
    }

    public String getTextonConfirmPopup(){
        return driver.switchTo().alert().getText();
    }

    public void sendTextonPromptPopup(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
