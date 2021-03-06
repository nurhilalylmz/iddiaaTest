package page.user;

import contants.user.ContantsUserInfoPage;
import contants.user.ContantsUserPasswordPage;
import jdk.jfr.Description;
import methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserPasswordPage extends BaseMethods {
    ContantsUserPasswordPage userPasswordPage = PageFactory.initElements(driver, ContantsUserPasswordPage.class);
    ContantsUserInfoPage userInfoPage = PageFactory.initElements(driver, ContantsUserInfoPage.class);

    public UserPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Description("Şifrelerim alanında bulunan default textleri kontrol eder.")
    public UserPasswordPage controlDefaultTextMyPassword(String textDefaultChangePassword, String textDefaultMyPasswordInfo, String textDefaultCurrentPassword, String textDefaultNewPassword, String textDefaultConfirmNewPassword) {
        Assert.assertEquals(userPasswordPage.textDefaultChangePassword.getText(), textDefaultChangePassword);
        Assert.assertEquals(userPasswordPage.textDefaultChangeMyPassword.getText(), textDefaultMyPasswordInfo);
        Assert.assertEquals(userPasswordPage.textDefaultCurrentPassword.getText(), textDefaultCurrentPassword);
        Assert.assertEquals(userPasswordPage.textDefaultNewPassword.getText(), textDefaultNewPassword);
        Assert.assertEquals(userPasswordPage.textDefaultConfirmNewPassword.getText(), textDefaultConfirmNewPassword);
        return new UserPasswordPage(driver);
    }

    @Description("Mevcut şifre alanına veri girişini sağlar.")
    public UserPasswordPage currentPasswordInputChangeValue(String inputCurrentPassword) {
        writeText(userPasswordPage.inputCurrentPassword, inputCurrentPassword);
        return new UserPasswordPage(driver);
    }

    @Description("Yeni şifre alanına veri girişini sağlar.")
    public UserPasswordPage newPasswordInputChangeValue(String inputNewPassword) {
        writeText(userPasswordPage.inputNewPassword, inputNewPassword);
        return new UserPasswordPage(driver);
    }

    @Description("Yeni şifre(tekrar) alanına veri girişini sağlar.")
    public UserPasswordPage confirmNewPasswordInputChangeValue(String inputConfirmNewPassword) {
        writeText(userPasswordPage.inputConfirmNewPassword, inputConfirmNewPassword);
        return new UserPasswordPage(driver);
    }

    @Description("Girilen bilgileri kontrol edip, kayıt eder.")
    public UserPasswordPage clickSaveButton(String textError) {
        clickElement(userPasswordPage.buttonSave);
        waitSeconds(2);
        if (textError.contains("Eski şifrenizi hatalı girdiniz.")) {
            controlErrorAndClick(textError, userPasswordPage.textAfterSaveButtonError, userPasswordPage.buttonIgnore);
        } else {
            controlErrorAndClick(textError, userPasswordPage.textError, userPasswordPage.buttonIgnore);
        }
        return new UserPasswordPage(driver);
    }

    @Description("Şifre güncelleme sayfasına gidilmesini sağlar.")
    public UserPasswordPage goToChangePasswordPage() {
        clickElement(userInfoPage.textChangePassword);
        return new UserPasswordPage(driver);
    }

    @Description("Çıkan pop-up'ı kapatır.")
    public UserPasswordPage closePopup() {
        clickElement(userPasswordPage.buttonClosePopup);
        return new UserPasswordPage(driver);
    }

}
