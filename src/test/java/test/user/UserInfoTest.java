package test.user;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.user.UserInfoPage;
import test.BaseTest;
import test.LoginTest;

public class UserInfoTest extends BaseTest {
    UserInfoPage userInfoPage;
    LoginTest logintest = new LoginTest();

    String phone="";

    @Description("Kullanıcı login olur ve profil sayfasına gidilir.")
    @Test
    public void goToProfilePage() {
        userInfoPage = new UserInfoPage(driver);
        logintest.successLogin();
        userInfoPage.goToProfilePage();
    }

    @Description("Profil sayfasında default gelen text alanları kontrol edilir.")
    @Test
    public void controlDefaultText() {
        userInfoPage
                .controlDefaultTextMyInfo(
                        "BİLGİLERİM",
                        "Kişisel Bilgilerim",
                        "Adınız",
                        "Soyadınız",
                        "Düzenle")
                .controlDefaultTextContactInfo(
                        "İletişim Bilgilerim",
                        "E-posta",
                        "Cep Telefonu",
                        "E-posta ve SMS ile güncel kampanyalardan haberdar olmak istiyorum.")
                .controlDefaultTextDealerInfo(
                        "Kayıtlı Bayi Bilgileri",
                        "Bayi Numarası",
                        "Bayi Adı",
                        "Bayi Adresi")
                .controlDefaultTextMyMoneyInfo(
                        "Bakiye",
                        "Kalan günlük yükleme limit",
                        "* Tek seferde maksimum 1000 TL bakiye yükleyebilirsiniz.")
                .controlDefaultTextSettings(
                        "AYARLAR",
                        "Şifre Değiştir");
    }

    @Description("Profil sayfasında kullanıcı bilgilerinin doğruluğu kontrol edilir.")
    @Test
    public void controlPersonInfoText() {
        userInfoPage
                .controlTextMyInfo(
                        "Hilal",
                        "Yılmaz")
                .controlTextContactInfo(
                        "@gmail.com",
                        phone)
                .controlTextDealerInfo(
                        "110319",
                        "MEHMET MANGIR",
                        "HAN MAH. NURİ EROĞLU SOK. NO:3/A 10050 SUSURLUK / BALIKESİR")
                .controlTextMyMoneyInfo(
                        "Hilal Yılmaz",
                        "14991 TL",
                        "15000 TL");
    }
}
