package com.mycompany.tatslycheect;

import com.mycompany.tatslychee.HomePage;
import com.mycompany.tatslychee.MenuLogadoPage;
import com.mycompany.tatslychee.LoginBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavegationTest {

    private WebDriver driver;
    private String login = "teste1";
    private String senha = "12345";
            
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
    public void testInfoPageCt1() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.infoPage();
        assertEquals("https://lychee.electerious.com/", title);
    }
    @Test
    public void testLoginErrorCt2() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.loginPage();
        loginPage.setLogin("erro");
        loginPage.setSenha("erro");  
        String error = loginPage.loginError();
        assertEquals("basicModal basicModal--shake", error);
    }
    @Test
    public void testLoginOkCt3() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
    }
    
    @Test
    public void testAlbunsCt4() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
        
        logadoPage.clickUnsorted();
        assertEquals(logadoPage.getTitle(), "Unsorted");
        logadoPage.clickBackPage();
        logadoPage.clickPublico();
        assertEquals(logadoPage.getTitle(), "Public");
        logadoPage.clickBackPage();
        logadoPage.clickRecent();
        assertEquals(logadoPage.getTitle(), "Recent");
        logadoPage.clickBackPage();
        logadoPage.clickStarred();
        assertEquals(logadoPage.getTitle(), "Starred");
        logadoPage.clickBackPage();
    }
    @Test
    public void testImagemErroCt5() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
    }
}
