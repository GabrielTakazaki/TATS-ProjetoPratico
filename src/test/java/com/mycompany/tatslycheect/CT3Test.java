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

public class CT3Test {

    private WebDriver driver;
    private LycheeBasePage lycheePage;
    private LycheeLogadoPage lycheeLogado;

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
    public void Ct3LogarContaValidaTest() throws InterruptedException {
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.LoginEntry();
        lycheeLogado = lycheePage
                .setLogin("teste")
                .setPassw("utfpr")
                .login();
        Thread.sleep(1000);
        assertEquals("header__toolbar header__toolbar--public", lycheeLogado.getLogado());
        
    }
}
