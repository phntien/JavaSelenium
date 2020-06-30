package alert;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends BaseTests {
    @Test
    public void testUploadFile()
    {
        var uploadPage = homePage.clickUploadLink();
        uploadPage.chooseFile("D:\\Working\\BenchTeam\\TestAutomationU\\resources\\chromedriver.exe");
        Assert.assertEquals(uploadPage.getUploadFile(),"chromedriver.exe","Unable to upload file ");
    }
}
