    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author MEU
 */
public class AlbumPage extends MenuLogadoPage{
    
    @FindBy(xpath = "/html/body/header/div[3]/a[2]")
    WebElement title;
    
    @FindBy(xpath = "//*[@id=\"button_back_home\"]")
    WebElement backPage;
     
    public AlbumPage(WebDriver driver) {
        super (driver);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public MenuLogadoPage clickBackPage() {
        clickMenuOption(backPage);
        return new MenuLogadoPage(driver);
    }
    
}
