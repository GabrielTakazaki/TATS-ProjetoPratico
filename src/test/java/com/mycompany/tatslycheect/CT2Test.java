package com.mycompany.tatslycheect;

import com.mycompany.tatslychee.LycheeBasePage;
import com.mycompany.tatslychee.LycheeLogadoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CT2Test {

    private LycheeBasePage lycheePage;
    private LycheeLogadoPage lycheeLogado;
    private WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void Ct2InvalidLoginTest() throws InterruptedException {
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.LoginEntry();
        lycheeLogado = lycheePage
                .setLogin("erro")
                .setPassw("erro")
                .login();
        Thread.sleep(1000);
        assertEquals("basicModal basicModal--shake", lycheePage.getError());
    }
}
