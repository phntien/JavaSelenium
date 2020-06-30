package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption() {
        String option = "Option 1";
        var dropDownPage = homePage.clickDropdown();
        dropDownPage.selectFromDropdown(option);
        var getSelectedOption = dropDownPage.getSelectedOptions();
        Assert.assertEquals(getSelectedOption.size(), 1, "Incorrect number option");
        Assert.assertTrue(getSelectedOption.contains(option), "Options not selected");

    }

    @Test
    public void testAddMultipleAttributeToDropdown() {

        var dropDownPage = homePage.clickDropdown();
        dropDownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropdown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        Assert.assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}

