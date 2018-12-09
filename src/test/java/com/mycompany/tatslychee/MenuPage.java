package com.mycompany.tatslychee;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    @FindBy(xpath = "/html/body/header/div[1]/a[2]")
    WebElement title;

    @FindBy(xpath = "/html/body/header/div[1]/a[3]")
    WebElement infopage;

    @FindBy(id = "button_signin")
    WebElement login;
    
    @FindBy(xpath = "/html/head/title")
    WebElement titleInfo;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public String infoPage() {
        clickMenuOption(infopage);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }
    public String titleInfo() {
        return titleInfo.getAttribute("title");
    }

    public LoginBasePage loginPage() {
        clickMenuOption(login);
        return new LoginBasePage(driver);
    }

    public void clickMenuOption(WebElement menuOption) {

        menuOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
    }

}
