package com.mycompany.tatslychee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginBasePage extends BasePage {

    @FindBy(name = "username")
    WebElement user;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "basicModal__action")
    WebElement buttonEnter;

    @FindBy(xpath = "/html/body/div[7]/div")
    WebElement error;

    public LoginBasePage(WebDriver driver) {
        super(driver);
    }

    public void setLogin(String login) {
        user.clear();
        user.sendKeys(login);
    }
    
    public void setSenha (String senha) {
        password.clear();
        password.sendKeys(senha);
    }

    public String login() {
        clickMenuOption(buttonEnter);
        if (getError().equals("basicModal basicModal--shake")) {
            return
        }
        return new LogadoPage(driver);
    }

    public String getError() {
        return error.getAttribute("class");
    }
     private void clickMenuOption(WebElement menuOption) {

        menuOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
}
