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
}
