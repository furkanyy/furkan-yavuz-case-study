package com.example.automation.tests;

import com.example.automation.pages.HomePage;
import com.example.automation.pages.CareerPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCareerPageTest extends BaseTest {
    @Test
    public void testHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageDisplayed(), "Home page should be displayed");
        WebElement companyNavItem = homePage.getCompanyNavItem();
        Assert.assertNotNull(companyNavItem, "Company item in navbar is not displayed");
        WebElement careerSubItem = homePage.getCareerSubItemFromCompanyDropdown();
        Assert.assertNotNull(careerSubItem, "Career subitem in Company dropdown is not displayed");
        careerSubItem.click();

        CareerPage careerPage = new CareerPage(driver);
        Assert.assertTrue(careerPage.isPageDisplayed(), "Career page is not displayed!");
        Assert.assertTrue(careerPage.isLocationsSectionDisplayed(), "Locations section is not displayed!");
        Assert.assertTrue(careerPage.isTeamsSectionDisplayed(), "Teams section is not displayed!");
        Assert.assertTrue(careerPage.isLifeAtInsiderSectionDisplayed(), "Life at Insider section is not displayed!");
    }
} 