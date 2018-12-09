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

public class CT5Test {

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
    public void Ct5ImagemErroTest() throws InterruptedException {
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5s5B2ZSvM4aXXK9c1VTZl3L-b7T6GqIpfIft50lz5GWpcxH9K9A";
        String errorUrl = "The import has been finished, but returned warnings or errors. Please take a look at the log (Settings -> Show Log) for further details.";
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.LoginEntry();
        lycheePage.setLogin("teste");
        lycheePage.setPassw("utfpr");
        lycheePage.login();
        lycheeLogado = new LycheeLogadoPage(driver);
        Thread.sleep(1000);
        assertEquals("header__toolbar header__toolbar--public",lycheeLogado.getLogado());
        lycheeLogado.clickAddPhotoLink(url);
        assertEquals(errorUrl, lycheeLogado.getErrorPhoto());
    }
}
