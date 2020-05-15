package contants.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsUserPasswordPage
{
    final WebDriver driver;

    //Default gelen text alanları
    @FindBy(how = How.CSS,using = ".dFTevO.sc-fjdhpX")
    public WebElement textDefaultChangePassword;
    @FindBy(how = How.CSS,using = ".keLVqX.sc-jzJRlG")
    public WebElement textDefaultChangeMyPassword;
    @FindBy(how = How.CSS,using = "div:nth-of-type(1) > .gpnEEN.sc-kgoBCf")
    public WebElement textDefaultCurrentPassword;
    @FindBy(how = How.CSS,using = "div:nth-of-type(2) > .gpnEEN.sc-kgoBCf")
    public WebElement textDefaultNewPassword;
    @FindBy(how = How.CSS,using = "div:nth-of-type(3) > .gpnEEN.sc-kgoBCf")
    public WebElement textDefaultConfirmNewPassword;

    // Input alanları
    @FindBy(how = How.NAME,using = "currentPassword")
    public WebElement inputCurrentPassword;
    @FindBy(how = How.NAME,using = "newPassword")
    public WebElement inputNewPassword;
    @FindBy(how = How.NAME,using = "confirmNewPassword")
    public WebElement inputConfirmNewPassword;

    //Buttonlar
    @FindBy(how = How.CSS,using = ".eZZTHf")
    public WebElement buttonSave;
    @FindBy(how = How.CSS,using = ".eGhXCq.sc-hMqMXs")
    public WebElement buttonIgnore;

    //Error
    @FindBy(how = How.CLASS_NAME,using = "form-error")
    public WebElement textError;
    @FindBy(how = How.XPATH,using = "/html//div[@id='root']/div/div[2]/div[@class='row']/div[@class='col-8']/div/form//div[@class='col-9 col-xl-8']/div[1]/div[2]/div/div[@class='form-error']")
    public WebElement textFirstİnputError;
    @FindBy(how = How.CSS,using = ".iohaHW.sc-kpOJdX")
    public WebElement textAfterSaveButtonError;

    @FindBy(how = How.CLASS_NAME,using = "policy-popup__close")
    public WebElement buttonClosePopup;

    public ContantsUserPasswordPage(WebDriver webDriver) {
        driver = webDriver;
    }
}
