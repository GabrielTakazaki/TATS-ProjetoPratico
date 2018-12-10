package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;

public class InicioBasePage extends BasePage {

    MenuPage menu;
    public InicioBasePage(WebDriver driver) {
        super(driver);
        menu = new MenuPage(driver);
    }

    public MenuPage getMenu() {
        return menu;
    }
    
}
