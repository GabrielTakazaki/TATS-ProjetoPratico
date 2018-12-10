package com.mycompany.tatslychee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuLogadoPage extends InicioBasePage {

    @FindBy(xpath = "/html/body/header/div[1]")
    WebElement logado;
    @FindBy(xpath = "/html/body/header/div[3]/a[2]")
    WebElement title;

    @FindBy(xpath = "/html/body/div[2]/div[2]")
    WebElement unsorted;
    @FindBy(xpath = "/html/body/div[2]/div[3]")
    WebElement publico;
    @FindBy(xpath = "/html/body/div[2]/div[4]")
    WebElement starred;
    @FindBy(xpath = "/html/body/div[2]/div[5]")
    WebElement recent;

    @FindBy(xpath = "/html/body/header/div[2]/a[5]")
    WebElement addPhotos;
    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[3]")
    WebElement addLink;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p/input")
    WebElement inputName;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div/div/p")
    WebElement errorMsg;
    @FindBy(xpath = "//*[@id=\"basicModal__action\"]")
    WebElement confirm;

    @FindBy(xpath = "/html/body/div[2]/div[1]")
    WebElement imgClass;
    
    @FindBy(xpath = "//*[@id=\"button_settings\"]")
    WebElement config;
    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[1]")
    WebElement changeUser;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[1]/input")
    WebElement oldPassword;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[2]/input[1]")
    WebElement newUser;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[2]/input[2]")
    WebElement newPassw;
    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[9]")
    WebElement signOut;
    @FindBy(xpath = "//*[@id=\"basicModal__action\"]")
    WebElement confirmChange;

    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[7]/td")
    WebElement album;

    public MenuLogadoPage(WebDriver driver) {
        super(driver);
    }

    public String getLogado() {
        return logado.getAttribute("class");
    }

    public AlbumPage clickUnsorted() {
        clickMenuOption(unsorted);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("Lychee - Unsorted"));
        return new AlbumPage(driver);
    }

    public AlbumPage clickPublico() {
        clickMenuOption(publico);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("Lychee - Public"));
        return new AlbumPage(driver);
    }

    public AlbumPage clickStarred() {
        clickMenuOption(starred);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("Lychee - Starred"));
        return new AlbumPage(driver);
    }

    public AlbumPage clickRecent() {
        clickMenuOption(recent);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("Lychee - Recent"));
        return new AlbumPage(driver);
    }

    public void clickMenuOption(WebElement menuOption) {

        menuOption.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
    }

    public void clickAddPhotoLink(String urlPhoto) {
        addPhotos.click();
        addLink.click();
        inputName.clear();
        inputName.sendKeys(urlPhoto);
        clickMenuOption(confirm);
    }

    public String getClassPhoto() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("photo")));
        return imgClass.getAttribute("class");
    }

    public String getErrorPhoto() {
        return errorMsg.getText();
    }
    public void changeLogin(String oldPass, String newUs, String newPa) {
        config.click();
        changeUser.click();
        oldPassword.clear();
        oldPassword.sendKeys(oldPass);
        newUser.clear();
        newUser.sendKeys(newUs);
        newPassw.clear();
        newPassw.sendKeys(newPa);
        confirmChange.click();
    }
    public HomePage sair() {
        config.click();
        signOut.click();
        return new HomePage(driver);
    }
    public AlbumPage newAlbum(String nome) throws InterruptedException {
        addPhotos.click();
        Thread.sleep(1000);
        album.click();
        inputName.clear();
        inputName.sendKeys(nome);
        confirm.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.titleIs("Lychee - "+nome));
        return new AlbumPage(driver);
    }
    
}
