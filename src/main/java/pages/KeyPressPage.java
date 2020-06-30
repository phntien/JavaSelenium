package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressPage {
    private WebDriver driver;
    private By textBoxKeyPress = By.id("target");
    private By resultKeyPress = By.id("result");

    public KeyPressPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(textBoxKeyPress).sendKeys(text);
    }

    public String getKeyEntered(){
        return driver.findElement(resultKeyPress).getText();
    }
}
