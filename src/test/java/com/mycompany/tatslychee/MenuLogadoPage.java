package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuLogadoPage extends LoginBasePage {
    
    
    @FindBy(xpath = "/html/body/header/div[1]")
    WebElement logado;
    
    
    @FindBy(xpath = "/html/body/div[2]/div[2]")
    WebElement unsorted;
    @FindBy(xpath = "/html/body/div[2]/div[3]")
    WebElement publico;
    @FindBy(xpath = "/html/body/div[2]/div[4]")
    WebElement starred;
    @FindBy(xpath = "/html/body/div[2]/div[5]")
    WebElement recent;
    
    

    public MenuLogadoPage(WebDriver driver) {
        super(driver);
    }
    public String getLogado() {
        return logado.getAttribute("class");
    }
    
    public AlbumPage clickUnsorted() {
        clickMenuOption(unsorted);
        return new AlbumPage(driver);
    }

    public AlbumPage clickPublico() {
        clickMenuOption(publico);
        return new AlbumPage(driver);
    }

    public AlbumPage clickStarred() {
        clickMenuOption(starred);
        return new AlbumPage(driver);
    }

    public AlbumPage clickRecent() {
        clickMenuOption(recent);
        return new AlbumPage(driver);
    }

}
