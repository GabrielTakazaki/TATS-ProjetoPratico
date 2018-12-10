package com.mycompany.tatslychee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlbumPage extends MenuLogadoPage {

    @FindBy(xpath = "/html/body/header/div[3]/a[2]")
    WebElement title;

    @FindBy(xpath = "//*[@id=\"button_back_home\"]")
    WebElement backPage;

    @FindBy(xpath = "//*[@id=\"button_trash\"]")
    WebElement trash;

    @FindBy(xpath = "/html/body/div[2]")
    WebElement imagemZoom;

    @FindBy(xpath = "/html/body/div[6]")
    WebElement tela;
    @FindBy(xpath = "/html/body/div[4]/div[2]/table[1]/tbody/tr[2]/td[2]/span")
    WebElement descricao;
    @FindBy(xpath = "//*[@id=\"button_info_album\"]")
    WebElement infoAlbum;
    @FindBy(xpath = "//*[@id=\"edit_description\"]/svg")
    WebElement editDesc;
    @FindBy(xpath = "//*[@id=\"button_share_album\"]")
    WebElement shareAlbum;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/form/div[1]/label/span[1]")
    WebElement hidden;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/form/div[2]/label/span[1]")
    WebElement download;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/form/div[3]/label/span[1]")
    WebElement protect;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/form/div[3]/input")
    WebElement inputPass;

    public AlbumPage(WebDriver driver) {
        super(driver);
    }

    public void apagarFoto() {
        imgClass.click();
        trash.click();
        confirm.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("photo")));
    }

    public String getImagemApagada() {
        return imagemZoom.getAttribute("class");
    }

    public String getTitle() {
        return title.getText();
    }

    public MenuLogadoPage clickBackPage() {
        clickMenuOption(backPage);
        return new MenuLogadoPage(driver);
    }

    public void shareAlbum(String senha) throws InterruptedException {
        clickMenuOption(shareAlbum);
        clickMenuOption(hidden);
        clickMenuOption(download);
        clickMenuOption(protect);
        inputPass.clear();
        inputPass.sendKeys(senha);
        confirm.click();
        alterarDescricao("topicos em teste");
    }

    public void alterarDescricao(String nome) throws InterruptedException {
        clickMenuOption(tela);
        clickMenuOption(infoAlbum);
        clickMenuOption(editDesc);
        inputName.clear();
        inputName.sendKeys(nome);
        clickMenuOption(confirm);
    }
    public String getDescricao () {
        return descricao.getText();
    }
}
