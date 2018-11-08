package com.mycompany.tatslycheect;

import com.mycompany.tatslychee.LycheeBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CT1Test {
    private WebDriver driver;
    private LycheeBasePage lycheePage;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
    }
    
    @After
    public void after() {
        driver.close();
    } 
    @Test
    public void Ct1InfoPageTest() {
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.entryInfoPage();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals("https://lychee.electerious.com/", driver.getCurrentUrl());
    }
    @Test
    public void Ct2InvalidLoginTest() {
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.LoginEntry();
        lycheePage.setLogin("erro");
        lycheePage.setPassw("erro");
        lycheePage.login();
        assertEquals("basicModal basicModal--shake", lycheePage.getError());
    }
}
