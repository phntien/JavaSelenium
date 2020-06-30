package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTests {
    @Test
    public void testWysiwyg(){

        var editorPage = homePage.clickWYSIWYGEditorLink();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        Assert.assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor is incorrect");
    }
}
