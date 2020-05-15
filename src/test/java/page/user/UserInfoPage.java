package page.user;

import contants.ContantsMainPage;
import contants.user.ContantsUserInfoPage;
import jdk.jfr.Description;
import methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserInfoPage extends BaseMethods {
    ContantsUserInfoPage userInfoPage = PageFactory.initElements(driver, ContantsUserInfoPage.class);
    ContantsMainPage mainPage = PageFactory.initElements(driver, ContantsMainPage.class);
    public UserInfoPage(WebDriver driver) {
        super(driver);
    }

    @Description("Profil sayfasına gidilmesini sağlar.")
    public UserInfoPage goToProfilePage() {
        waitElementToClickable(mainPage.wrapperProfile);
        clickElement(mainPage.wrapperProfile);
        waitElementToClickable(mainPage.buttonProfilim);
        clickElement(mainPage.buttonProfilim);
        return new UserInfoPage(driver);
    }

    @Description("Bilgilerim alanında bulunan default textleri kontrol eder.")
    public UserInfoPage controlDefaultTextMyInfo(String textBilgilerim,String textPersonInfo,String textName,String textLastName,String textEdit) {
        waitSeconds(1);
        Assert.assertEquals(userInfoPage.textMyInfo.getText(),textBilgilerim);
        Assert.assertEquals(userInfoPage.textPersonInfo.getText(),textPersonInfo);
        Assert.assertEquals(userInfoPage.textDefaultPersonName.getText(),textName);
        Assert.assertEquals(userInfoPage.textDefaultPersonLastName.getText(),textLastName);
        Assert.assertEquals(userInfoPage.textButtonEdit.getText(),textEdit);
        return new UserInfoPage(driver);
    }

    @Description("İletişim alanında bulunan default textleri kontrol eder.")
    public UserInfoPage controlDefaultTextContactInfo(String textContactInfo,String textEmail,String textPhone,String textInformed) {
        Assert.assertEquals(userInfoPage.textMyContactInfo.getText(),textContactInfo);
        Assert.assertEquals(userInfoPage.textDefaultContactPersonEmail.getText(),textEmail);
        Assert.assertEquals(userInfoPage.textDefaultPersonPhoneNumber.getText(),textPhone);
        Assert.assertEquals(userInfoPage.textInformedByMailPhone.getText(),textInformed);
        return new UserInfoPage(driver);
    }

    @Description("Bayi alanında bulunan default textleri kontrol eder.")
    public UserInfoPage controlDefaultTextDealerInfo(String textDealerInfo,String textDealerNumber,String textDealerName,String textDealerAddress) {
        Assert.assertEquals(userInfoPage.textMyDealerInfo.getText(),textDealerInfo);
        Assert.assertEquals(userInfoPage.textDefaultDealerNumber.getText(),textDealerNumber);
        Assert.assertEquals(userInfoPage.textDefaultDealerName.getText(),textDealerName);
        Assert.assertEquals(userInfoPage.textDefaultDealerAddress.getText(),textDealerAddress);
        return new UserInfoPage(driver);
    }

    @Description("Bakiye alanında bulunan default textleri kontrol eder.")
    public UserInfoPage controlDefaultTextMyMoneyInfo(String textMoneyInfo,String textDailyLimit,String textDailyLimitNote) {
        Assert.assertEquals(userInfoPage.textDefaultMoneyInfo.getText().substring(0,6),textMoneyInfo);
        Assert.assertEquals(userInfoPage.textDefaultDailyLimit.getText(),textDailyLimit);
        Assert.assertEquals(userInfoPage.textDailyLimitNote.getText(),textDailyLimitNote);
        return new UserInfoPage(driver);
    }

    @Description("Ayarlar alanında bulunan default textleri kontrol eder.")
    public UserInfoPage controlDefaultTextSettings(String textSettings,String textChangePassword) {
        Assert.assertEquals(userInfoPage.textSettings.getText(),textSettings);
        Assert.assertEquals(userInfoPage.textChangePassword.getText(),textChangePassword);
        return new UserInfoPage(driver);
    }

    @Description("Bilgilerim alanında bulunan kullanıcının bilgilerini kontrol eder.")
    public UserInfoPage controlTextMyInfo(String textName,String textLastName) {
        Assert.assertEquals(userInfoPage.textPersonName.getText(),textName);
        Assert.assertEquals(userInfoPage.textPersonLastName.getText(),textLastName);
        return new UserInfoPage(driver);
    }

    @Description("İletişim alanında bulunan kullanıcının bilgilerini kontrol eder.")
    public UserInfoPage controlTextContactInfo(String textEmail,String textPhone) {
        Assert.assertEquals(userInfoPage.textPersonEmail.getText(),textEmail);
        Assert.assertEquals(userInfoPage.textPersonPhoneNumber.getText(),textPhone);
        return new UserInfoPage(driver);
    }

    @Description("Bayi alanında bulunan kullanıcının bilgilerini kontrol eder.")
    public UserInfoPage controlTextDealerInfo(String textDealerNumber,String textDealerName,String textDealerAddress) {
        Assert.assertEquals(userInfoPage.textDealerNumber.getText(),textDealerNumber);
        Assert.assertEquals(userInfoPage.textDealarName.getText(),textDealerName);
        Assert.assertEquals(userInfoPage.textDealerAddress.getText(),textDealerAddress);
        return new UserInfoPage(driver);
    }

    @Description("Bakiye alanında bulunan kullanıcının bilgilerini kontrol eder.")
    public UserInfoPage controlTextMyMoneyInfo(String userName,String textMoneyInfo,String textDailyLimit) {
        Assert.assertEquals(userInfoPage.textUserName.getText(),userName);
        Assert.assertEquals(userInfoPage.textMoneyInfo.getText(),textMoneyInfo);
        Assert.assertEquals(userInfoPage.textDailyLimit.getText(),textDailyLimit);
        return new UserInfoPage(driver);
    }
}
