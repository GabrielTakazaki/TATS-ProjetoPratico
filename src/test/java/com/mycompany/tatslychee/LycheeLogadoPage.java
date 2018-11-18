package com.mycompany.tatslychee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LycheeLogadoPage extends BasePage {

    @FindBy(xpath = "/html/body/header/div[1]")
    WebElement logado;
    
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
    @FindBy(xpath = "/html/body/div[2]/div[1]")
    WebElement imgClass;

    @FindBy(xpath = "//*[@id=\"button_trash\"]")
    WebElement trash;
    @FindBy(xpath = "//*[@id=\"button_trash_album\"]")
    WebElement trashAlbum;
    @FindBy(xpath = "//*[@id=\"basicModal__action\"]")
    WebElement confirm;

    @FindBy(xpath = "//*[@id=\"button_settings\"]")
    WebElement config;

    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[1]")
    WebElement config1;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[1]/input")
    WebElement oldPassword;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[2]/input[1]")
    WebElement newUser;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/p[2]/input[2]")
    WebElement newPassw;

    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[9]")
    WebElement signOut;

    @FindBy(xpath = "/html/body/header/div[3]/a[2]")
    WebElement title;
    @FindBy(xpath = "//*[@id=\"button_back_home\"]")
    WebElement backPage;

    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[7]/td")
    WebElement album;

    @FindBy(xpath = "/html/body/div[6]/div/table/tbody/tr[1]/td")
    WebElement albumRename;

    public LycheeLogadoPage(WebDriver driver) {
        super(driver);
    }
    public void shareAlbum (String senha) throws InterruptedException {
        Thread.sleep(500);
        newAlbum("shareAlbum");
        shareAlbum.click();
        Thread.sleep(500);
        hidden.click();
        download.click();
        Thread.sleep(500);
        protect.click();
        inputPass.clear();
        inputPass.sendKeys(senha);
        confirm.click();
        alterarDescricao("topicos em teste");
    }
    public void alterarDescricao (String nome) throws InterruptedException {
        Thread.sleep(500);
        tela.click();
        infoAlbum.click();
        editDesc.click();
        inputName.clear();
        inputName.sendKeys(nome);
        confirm.click();
    }
    public String getDescricao () {
        return descricao.getText();
    }
    
    public void newAlbum(String nome) {
        addPhotos.click();
        album.click();
        inputName.clear();
        inputName.sendKeys(nome);
        confirm.click();
    }

    public void deleteAlbum() {
        trashAlbum.click();
        confirm.click();
    }

    public void renameAlbum(String nome) {
        title.click();
        config1.click();
        inputName.clear();
        inputName.sendKeys(nome);
        confirm.click();
    }

    public void changeLogin(String oldPass, String newUs, String newPa) {
        config.click();
        config1.click();
        oldPassword.clear();
        oldPassword.sendKeys(oldPass);
        newUser.clear();
        newUser.sendKeys(newUs);
        newPassw.clear();
        newPassw.sendKeys(newPa);
        confirm.click();
    }

    public void sair() {
        config.click();
        signOut.click();
    }

    public void clickAddPhotoLink(String urlPhoto) {
        addPhotos.click();
        addLink.click();
        inputName.clear();
        inputName.sendKeys(urlPhoto);
        confirm.click();
    }

    public String getErrorPhoto() {
        return errorMsg.getText();
    }

    public void apagarFoto() {
        imgClass.click();
        trash.click();
        confirm.click();
    }

    public String getClassPhoto() {
        return imgClass.getAttribute("class");
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLogado() {
        return logado.getAttribute("class");
    }

    public void clickUnsorted() {
        unsorted.click();
    }

    public void clickPublico() {
        publico.click();
    }

    public void clickStarred() {
        starred.click();
    }

    public void clickRecent() {
        recent.click();
    }

    public void clickBackPage() {
        backPage.click();
    }
}
