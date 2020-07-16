package test;

import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    String phone="";
    @Test
    public void successLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login(phone, "qwerty1")
                .checkUserMainPage("https://test.iddaa.com/");

    }

    @Test
    public void wrongInformationTextLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("", "")
                .checkTrueLogin("", "", "Telefon numarası veya şifre hatalı.", driver.getCurrentUrl());

    }

    @Test
    public void emptyPhoneLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("", "")
                .checkTrueLogin("", "", "Bu alanın doldurulması zorunludur.", "");
    }

    @Test
    public void emptyPasswordLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("456", "")
                .checkTrueLogin("4564", "", "Bu alanın doldurulması zorunludur.", "");
    }

    @Test
    public void emptyAllTextFieldsLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("", "")
                .checkTrueLogin("", "",
                        "Bu alanın doldurulması zorunludur.", "");
    }

    @Test
    public void invalidMinPhoneNumberLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("0919999999", "testhilaltest")
                .checkTrueLogin("0919999999", "testhilaltest",
                        "Lütfen geçerli bir telefon numarası giriniz. Telefon numarası başına 0 olacak şekilde 11 haneli olmalıdır.",
                        "");
    }

    @Test
    public void invalidMaxPhoneNumberLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("091999999999", "testhilaltest")
                .checkTrueLogin("091999999999", "testhilaltest",
                        "Lütfen geçerli bir telefon numarası giriniz. Telefon numarası başına 0 olacak şekilde 11 haneli olmalıdır.",
                        "");
    }

    @Test
    public void invalidWithoutZeroPhoneNumberLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("919999999999", "testhilaltest")
                .checkTrueLogin("991999999999", "testhilaltest",
                        "Lütfen geçerli bir telefon numarası giriniz. Telefon numarası başına 0 olacak şekilde 11 haneli olmalıdır.",
                        "");
    }

    @Test
    public void invalidMinPasswordLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("456", "testhi")
                .checkTrueLogin("456", "testhi",
                        "Şifre maksimum 20 minimum 6 karakter içermelidir ve en az bir harf ve bir sayı içermelidir.",
                        "");
    }

    @Test
    public void invalidMaxPasswordLogin() {
        loginPage = new LoginPage(driver);
        loginPage
                .login("456", "testhilaltesthilaltesthilal")
                .checkTrueLogin("456", "testhilaltesthilaltesthilal",
                        "Şifre maksimum 20 minimum 6 karakter içermelidir ve en az bir harf ve bir sayı içermelidir.",
                        "");
    }
}
