package page.user;

import contants.user.ContantsUserEditPage;
import jdk.jfr.Description;
import methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserEditPage extends BaseMethods {
    public UserEditPage(WebDriver driver) {
        super(driver);
    }

    ContantsUserEditPage userEditPage = PageFactory.initElements(driver, ContantsUserEditPage.class);

    @Description("Düzenle sayfasına gidilmesini sağlar.")
    public UserEditPage clickEditButton() {
        clickElement(userEditPage.buttonEditWithInfo);
        return new UserEditPage(driver);
    }

    @Description("Kullanıcının isim alanının güncellenmesini sağlar.")
    public UserEditPage nameInputChangeValue(String inputName) {
        writeText(userEditPage.inputPersonName, inputName);
        return new UserEditPage(driver);
    }

    @Description("Kullanıcının soyisim alanının güncellenmesini sağlar.")
    public UserEditPage surnameInputChangeValue(String inputSurname) {
        writeText(userEditPage.inputSurname, inputSurname);
        return new UserEditPage(driver);
    }

    @Description("Kullanıcının email alanının güncellenmesini sağlar.")
    public UserEditPage emailInputChangeValue(String inputEmail) {
        writeText(userEditPage.inputEmail, inputEmail);
        return new UserEditPage(driver);
    }

    @Description("Kullanıcının subscribe alanının güncellenmesini sağlar.")
    public UserEditPage clickCheckFormSubscribe() {
        clickElement(userEditPage.clickCheckFormSubscribe);
        return new UserEditPage(driver);
    }

    @Description("Kullanıcının telefon alanının güncellenmesini sağlar.")
    public UserEditPage phoneInputChangeValue(String inputPhone) {
        writeText(userEditPage.inputPhoneNumber, inputPhone);
        return new UserEditPage(driver);
    }

    @Description("Verilen bilgileri doğruluğuna göre kontrol edip, kaydeder.")
    public UserEditPage clickSaveButton(String textValue, String textError) {
        try {
            clickElement(userEditPage.buttonSave);
            waitSeconds(1);
            controlErrorAndClick(textError, userEditPage.textError, userEditPage.buttonIgnore);
            controlEmailAndClick(textValue, userEditPage.buttonIgnore);
        } catch (Exception e) {
            Assert.fail("Belirtilen hata mesajı bulunamadı. Sayfadaki uyarı mesajları kontrol edilmeli.");
        }
        return new UserEditPage(driver);
    }

}
