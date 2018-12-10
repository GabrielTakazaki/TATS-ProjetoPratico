package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;

public class HomePage extends InicioBasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("http://192.168.0.16/");
    }
}
