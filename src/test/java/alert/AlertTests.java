package alert;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {
    @Test
    public void testArlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickOnAlertsButton();
        alertPage.clickAcceptonAlertsPopup();
        Assert.assertEquals(alertPage.getResult(),"You successfuly clicked an alert", "The result not correct");
    }

    @Test
    public void testArlertConfirm(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickOnConfirmButton();
        String text = alertPage.getTextonConfirmPopup();
        alertPage.clickDismissPopup();
        Assert.assertEquals(text,"I am a JS Confirm", "The text not correct");
    }

    @Test
    public void testArlertPrompt(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.clickOnPromptButton();
        String text = "Tien Phan";
        alertPage.sendTextonPromptPopup(text);
        alertPage.clickAcceptonAlertsPopup();
        Assert.assertEquals(alertPage.getResult(),"You entered: "+text, "The text not correct");
    }
}
