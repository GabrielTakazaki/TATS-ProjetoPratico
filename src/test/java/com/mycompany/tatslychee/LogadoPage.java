package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogadoPage extends LycheeLogadoPage {

    public LogadoPage(WebDriver driver) {
        super(driver);
    }

    public AlbumPage abrirAlbum() {
        clickMenuOption(album);
        return new AlbumPage(driver);
    }

    private void clickMenuOption(WebElement menuOption) {

        menuOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }

}
