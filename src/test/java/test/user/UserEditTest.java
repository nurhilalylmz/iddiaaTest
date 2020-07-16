package test.user;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.user.UserEditPage;
import test.BaseTest;

public class UserEditTest extends BaseTest {
    UserEditPage userEditPage;

    @Description("Bütün alanlara değerler girilir ve kaydedilir.")
    @Test
    public void allInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .nameInputChangeValue("Nur Hilal")
                .surnameInputChangeValue("Öztürk")
                .emailInputChangeValue("@gmail.com")
                .clickCheckFormSubscribe()
                .clickSaveButton("", "");
    }

    @Description("Ad alanına değer girilmez ve kaydet butonuna tıklanır.")
    @Test
    public void emptyNameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .nameInputChangeValue("")
                .clickSaveButton("", "Bu alanın doldurulması zorunludur.");
    }

    @Description("Ad alanına tek harf girilir ve kaydet butonuna tıklanır.")
    @Test
    public void twoLetterRuleNameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .nameInputChangeValue("N")
                .clickSaveButton("", "Ad alanı minimum 2, maksimum 30 karakter içermelidir. Özel karakter içermemelidir.");
    }

    @Description("Ad alanına 30'dan fazla harf girilir ve kaydet butonuna tıklanır.")
    @Test
    public void thirtyLetterRuleNameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .nameInputChangeValue("NurHilalnurhilalnurhilalnurhila")
                .clickSaveButton("", "Maksimum 30 karakter olmalıdır");
    }

    @Description("Ad alanına özel karakter girilir ve kaydet butonuna tıklanır.")
    @Test
    public void specialCharacterNameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .nameInputChangeValue("hilal@")
                .clickSaveButton("", "Ad alanı minimum 2, maksimum 30 karakter içermelidir. Özel karakter içermemelidir.");
    }

    @Description("Soyad alanına değer girilmez ve kaydet butonuna tıklanır.")
    @Test
    public void emptySurnameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .surnameInputChangeValue("")
                .clickSaveButton("", "Bu alanın doldurulması zorunludur.");
    }

    @Description("Soyad alanına tek harf girilir ve kaydet butonuna tıklanır.")
    @Test
    public void twoLetterRuleSurnameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .surnameInputChangeValue("K")
                .clickSaveButton("", "Soyad alanı minimum 2, maksimum 30 karakter içermelidir. Özel karakter içermemelidir.");
    }

    @Description("Soyad alanına 30'dan fazla harf girilir ve kaydet butonuna tıklanır.")
    @Test
    public void thirtyLetterRuleSurnameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .surnameInputChangeValue("Karakarakarakarakarakarakarakark")
                .clickSaveButton("", "Maksimum 30 karakter olmalıdır");
    }

    @Description("Soyad alanına özel karakter girilir ve kaydet butonuna tıklanır.")
    @Test
    public void specialCharacterSurnameInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .surnameInputChangeValue("kara@")
                .clickSaveButton("", "Soyad alanı minimum 2, maksimum 30 karakter içermelidir. Özel karakter içermemelidir.");
    }

    @Description("Email alanına geçersiz değer girilir ve kaydet butonuna tıklanır.")
    @Test
    public void invalidRuleMailInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .emailInputChangeValue("@gmail.c")
                .clickSaveButton("", "Geçerli bir mail adresi giriniz");
    }

    @Description("Email alanına türkçe harf girilir ve kaydet butonuna tıklanır.")
    @Test
    public void specCharacterRuleMailInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .emailInputChangeValue("@gmail.com")
                .clickSaveButton("@gmail.com", "");
    }

    @Description("Numara alanına hatalı numara girilir ve kaydet butonuna tıklanır.")
    @Test
    public void invalidPhoneNumberInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .phoneInputChangeValue("5399199999")
                .clickSaveButton("",
                        "Lütfen geçerli bir telefon numarası giriniz. Telefon numarası başına 0 olacak şekilde 11 haneli olmalıdır.");
    }

    @Description("Numara alanına değer girilmez ve kaydet butonuna tıklanır.")
    @Test
    public void emptyPhoneNumberInputChangeValue() {
        userEditPage = new UserEditPage(driver);
        userEditPage
                .clickEditButton()
                .phoneInputChangeValue("")
                .clickSaveButton("", "Bu alanın doldurulması zorunludur.");
    }


}
