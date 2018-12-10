
package com.mycompany.tatslychee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlbumPage extends MenuLogadoPage{
    
    @FindBy(xpath = "/html/body/header/div[3]/a[2]")
    WebElement title;
    
    @FindBy(xpath = "//*[@id=\"button_back_home\"]")
    WebElement backPage;
    
    @FindBy(xpath = "//*[@id=\"button_trash\"]")
    WebElement trash;
    
    @FindBy(xpath = "/html/body/div[2]")
    WebElement imagemZoom;
    
    public AlbumPage(WebDriver driver) {
        super (driver);
    }
    public void apagarFoto() {
        imgClass.click();
        trash.click();
        confirm.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("photo")));
    }
    public String getImagemApagada () {
        return imagemZoom.getAttribute("class");
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public MenuLogadoPage clickBackPage() {
        clickMenuOption(backPage);
        return new MenuLogadoPage(driver);
    }
    
}
