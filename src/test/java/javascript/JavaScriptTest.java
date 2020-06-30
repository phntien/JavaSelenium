package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTest extends BaseTests {
    @Test
    public void testScrolltoView(){
       String text =  homePage.clickLargeAndDeepDom().getText();
    }
}
