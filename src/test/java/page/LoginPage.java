package page;

import contants.ContantsLoginPage;
import contants.ContantsMainPage;
import jdk.jfr.Description;
import methods.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseMethods {

    ContantsLoginPage loginPage = PageFactory.initElements(driver, ContantsLoginPage.class);
    ContantsMainPage mainPage = PageFactory.initElements(driver, ContantsMainPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Description("Girilen bilgilerle birlikte kullanıcı login olur.")
    public LoginPage login(String phoneNumber, String password) {
        waitForPageLoad(mainPage.copyrightText);
        writeText(loginPage.phoneNumber, phoneNumber);
        writeText(loginPage.password, password);
        clickElement(loginPage.buttonLogin);
        return new LoginPage(driver);
    }

    @Description("Kullanıcının hangi sayfada olduğu kontrol edilir.")
    public LoginPage checkUserMainPage(String expectingUrl) {
        waitForPageLoad(mainPage.copyrightText);
        Assert.assertEquals(driver.getCurrentUrl(), expectingUrl, "İstenen sayfada olunmadığı görüldü");
        return new LoginPage(driver);
    }

    @Description("Girilen bilgilere göre hata mesajlarının verilmesi sağlanır.")
    public LoginPage checkTrueLogin(String phoneNumber, String password, String expectedText, String expectedURL) {
        if (phoneNumber.isEmpty()) {
            Assert.assertEquals(loginPage.loginError.getText(), expectedText);
        } else if (phoneNumber.isEmpty() && password.isEmpty()) {
            Assert.assertEquals(loginPage.loginError.getText(), expectedText);
        } else if (password.isEmpty()) {
            Assert.assertEquals(loginPage.loginError.getText(), expectedText);
        } else if ((!phoneNumber.isEmpty() && !password.isEmpty()) && driver.getCurrentUrl() != expectedURL) {
            Assert.assertEquals(loginPage.loginError.getText(), expectedText);
        }
        return new LoginPage(driver);
    }

}