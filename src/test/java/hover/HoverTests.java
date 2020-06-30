package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickHovers();
        final HoversPage.FigureCaption figureCaption = hoversPage.hoversOverFigure(1);
        Assert.assertTrue(figureCaption.isCaptionDisplayed(),"Caption is not displayed");
        Assert.assertEquals(figureCaption.getTitle(),"name: user1", "Incorrect user");
        Assert.assertEquals(figureCaption.getLinkText(),"View profile","Incorrect Link Text");
        Assert.assertTrue(figureCaption.getLink().endsWith("/users/1"),"Incorrect Link");
    }
}
