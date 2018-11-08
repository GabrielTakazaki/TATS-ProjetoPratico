package com.mycompany.tatslychee;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LycheeBasePage extends BasePage {

    @FindBy(xpath = "/html/body/header/div[1]/a[2]")
    WebElement title;

    @FindBy(xpath = "/html/body/header/div[1]/a[3]")
    WebElement infopage;

    @FindBy(id = "button_signin")
    WebElement buttonsign;

    @FindBy(name = "username")
    WebElement user;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "basicModal__action")
    WebElement buttonEnter;

    @FindBy(id = "basicModal__cancel")
    WebElement buttonCancel;

    @FindBy(xpath = "/html/head/title")
    WebElement newPage;

    @FindBy(xpath = "/html/body/div[7]/div")
    WebElement error;

    public LycheeBasePage(WebDriver driver) {
        super(driver);
        driver.get("http://192.168.0.110/");
    }

    public LycheeBasePage setLogin(String login) {
        user.clear();
        user.sendKeys(login);
        return this;
    }

    public LycheeBasePage setPassw(String passw) {
        password.clear();
        password.sendKeys(passw);
        return this;
    }

    public void LoginEntry() {
        buttonsign.click();
    }

    public void entryInfoPage() {
        infopage.click();
    }

    public void login() {
        buttonEnter.click();
    }

    public void cancel() {
        buttonCancel.click();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLogin() {
        return user.getText();
    }

    public String getPassw() {
        return password.getText();
    }

    public String getError() {
        try {
            driver.wait(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LycheeBasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return error.getAttribute("class");
    }
}