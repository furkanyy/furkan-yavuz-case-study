package com.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CareerPage {
    private WebDriver driver;
    private static final String EXPECTED_TITLE = "Ready to disrupt? | Insider Careers";
    private static final String EXPECTED_URL = "https://useinsider.com/careers/";
    private static final By LOCATIONS_SECTION = By.id("career-our-location");
    private static final By TEAMS_SECTION = By.id("career-find-our-calling");
    private static final By LIFE_AT_INSIDER_SECTION = By.xpath("//h2[text()='Life at Insider']");

    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.titleIs(EXPECTED_TITLE));
            String actualTitle = driver.getTitle();
            String actualUrl = driver.getCurrentUrl();
            return actualTitle.equals(EXPECTED_TITLE) && actualUrl.startsWith(EXPECTED_URL);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLocationsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATIONS_SECTION));
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTeamsSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(TEAMS_SECTION));
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLifeAtInsiderSectionDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(LIFE_AT_INSIDER_SECTION));
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

} 