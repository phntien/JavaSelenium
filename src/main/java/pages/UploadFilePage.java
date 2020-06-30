package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {
    private WebDriver webDriver;
    private By choseFile = By.id("file-upload");
    private By fileUpload = By.id("file-submit");
    private By fileisUploaded = By.id("uploaded-files");
    public UploadFilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Provides path of file to the form then clicks Upload button
     * @param absolutePathOfFile The complete path of the file to upload
     */
    public void chooseFile(String absolutePathOfFile){
        webDriver.findElement(choseFile).sendKeys(absolutePathOfFile);
        clickUploadFile();
    }

    public void clickUploadFile(){
        webDriver.findElement(fileUpload).click();
    }

    public String getUploadFile(){
        return webDriver.findElement(fileisUploaded).getText();
    }
}
