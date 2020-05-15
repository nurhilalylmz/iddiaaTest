package methods;

import org.testng.Assert;
import test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
    protected  WebDriver driver = BaseTest.driver;
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    public BaseMethods(WebDriver driver) {
        super();
    }

    //Wrapper methodu gözükene kadar bekler.
    protected void waitElementToClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void logMessage(String text) {
        System.out.println(text);
    }

    protected void clickElement(WebElement element) {
        try {
            element.click();
            waitSeconds(1);
            logMessage(element.getText() + " elementine tıklandı.");
        } catch (Exception e) {
            logMessage("Elemente tıklanamadı. Element: " + element + " Hata: " + e.getMessage());
        }

    }

    protected void writeText(WebElement element, String text) {
        try {
            if (element.getText().equals("")) {
                element.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            }
            element.sendKeys(text);

        } catch (Exception e) {
            logMessage("İlgili elemente yazı yazılırken hata oluştu. Element:"+ element +"Hata: " + e.getMessage());
        }
    }

    protected void waitSeconds(int seconds) {
        try {
            logMessage(seconds + " saniye kadar bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logMessage(e.getMessage());
        }
    }

    //Sayfayı belirli bir element yüklenene kadar bekletir.
    protected void waitForPageLoad(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean controllEmailTurkishCharacter(String textValue){
        boolean isTurkishCharacter=false;
        if(textValue.toLowerCase().contains("ş")||textValue.contains("ç")||textValue.contains("ğ")||textValue.contains("ı")||textValue.contains("ö")||textValue.contains("ü")){
            isTurkishCharacter=true;
        }
        return isTurkishCharacter;
    }

    protected void controlEmailAndClick(String textValue,WebElement elementIgnore){
        if(controllEmailTurkishCharacter(textValue)){
            Assert.fail("Mail adresinde türkçe karakterler bulunmakta kontrol ediniz.");
            clickElement(elementIgnore);
        }
    }
    protected void controlErrorAndClick(String textError,WebElement textElementError,WebElement buttonIgnore){
        if(!textError.isEmpty()){
            Assert.assertEquals(textElementError.getText(),textError);
            clickElement(buttonIgnore);
        }
    }

}