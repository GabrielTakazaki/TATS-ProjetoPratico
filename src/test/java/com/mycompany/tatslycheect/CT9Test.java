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


public class CT9Test {

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
    public void Ct9CriarAlbumTest() throws InterruptedException {
        lycheePage = new LycheeBasePage(driver);
        assertEquals("Albums", lycheePage.getTitle());
        lycheePage.LoginEntry();
        lycheeLogado = lycheePage
                .setLogin("teste1")
                .setPassw("12345")
                .login();
        Thread.sleep(1000);
        assertEquals("header__toolbar header__toolbar--public", lycheeLogado.getLogado());
        lycheeLogado.newAlbum("teste");
        Thread.sleep(1000);        
        assertEquals(lycheeLogado.getTitle(), "teste");
        lycheeLogado.renameAlbum("teste2");
        Thread.sleep(1000);        
        assertEquals(lycheeLogado.getTitle(), "teste2");
        lycheeLogado.deleteAlbum();
        Thread.sleep(1000);        
        assertEquals("header__toolbar header__toolbar--public", lycheeLogado.getLogado());
        
    }
}