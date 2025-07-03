package com.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private static final String URL = "https://useinsider.com/";
    private static final By HOME_BODY_SELECTOR = By.cssSelector("body[class^='home']");
    private static final By NAVBAR_DROPDOWN_MENU_LINK = By.id("navbarDropdownMenuLink");
    private static final By NAVBAR_CAREER = By.xpath("//a[contains(text(), 'Career')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement body = wait.until(
                ExpectedConditions.visibilityOfElementLocated(HOME_BODY_SELECTOR)
            );
            return body.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getCompanyNavItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> navItems = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(NAVBAR_DROPDOWN_MENU_LINK)
        );
        for (WebElement item : navItems) {
            if (item.getText().trim().contains("Company")) {
                return item;
            }
        }
        return null;
    }

    public WebElement getCareerSubItemFromCompanyDropdown() {
        WebElement companyNavItem = getCompanyNavItem();
        if (companyNavItem == null) {
            return null;
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(companyNavItem).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(NAVBAR_CAREER));
        } catch (Exception e) {
            return null;
        }
    }
} 