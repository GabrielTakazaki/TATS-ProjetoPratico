package com.mycompany.tatslycheect;

import com.mycompany.tatslychee.AlbumPage;
import com.mycompany.tatslychee.HomePage;
import com.mycompany.tatslychee.MenuLogadoPage;
import com.mycompany.tatslychee.LoginBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
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
    /*
    @Test
    public void InfoPageCt1test() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.getMenu().infoPage();
        assertEquals("https://lychee.electerious.com/", title);
    }
    @Test
    public void LoginErrorCt2test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin("erro");
        loginPage.setSenha("erro");  
        String error = loginPage.loginError();
        assertEquals("basicModal basicModal--shake", error);
    }
    @Test
    public void LoginOkCt3test() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
    }
    @Test
    public void AlbunsCt4test() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
        AlbumPage album;
        album = logadoPage.clickUnsorted();
        assertEquals("Unsorted", album.getTitle());
        album = album.clickBackPage().clickPublico();
        assertEquals("Public",album.getTitle());
        album = album.clickBackPage().clickRecent();
        assertEquals("Recent",album.getTitle());
        album = album.clickBackPage().clickStarred();
        assertEquals("Starred",album.getTitle());
    }
    @Test
    public void ImagemErroCt5test() {
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5s5B2ZSvM4aXXK9c1VTZl3L-b7T6GqIpfIft50lz5GWpcxH9K9A";
        String errorUrl = "The import has been finished, but returned warnings or errors. Please take a look at the log (Settings -> Show Log) for further details.";
        
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
        logadoPage.clickAddPhotoLink(url);
        assertEquals(errorUrl, logadoPage.getErrorPhoto());
    }
    @Test
    public void ImagemImportCt6test() {
        String url = "https://www.aprenderexcel.com.br//imagens/post/385/2901-1.jpg";
        String classImg = "photo";
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
        logadoPage.clickAddPhotoLink(url);
        assertEquals(classImg, logadoPage.getClassPhoto());
    }
    @Test
    public void ApagarFotoCt7test() {
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginPage = homePage.getMenu().loginPage();
        loginPage.setLogin(login);
        loginPage.setSenha(senha);  
        MenuLogadoPage logadoPage = loginPage.loginOk();
        assertEquals("header__toolbar header__toolbar--public", logadoPage.getLogado());
        AlbumPage album;
        album = logadoPage.clickUnsorted();
        assertEquals("Unsorted", album.getTitle());
        album.apagarFoto();
        assertNotEquals("content ui-sortable contentZoomIn view", album.getImagemApagada());
    }*/
}
