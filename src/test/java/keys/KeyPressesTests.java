package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends BaseTests {
    @Test
    public void testKeyPress(){
        String text = Keys.chord(Keys.ALT,"p")+"=3.14";
        //String text = "A" + Keys.BACK_SPACE;
        var keypressPage = homePage.clickKeyPress();
        keypressPage.enterText(text);
       Assert.assertEquals(keypressPage.getKeyEntered(),"You entered: BACK_SPACE!","Text not contained");
    }
}
