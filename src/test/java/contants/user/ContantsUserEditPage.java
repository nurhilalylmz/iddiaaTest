package contants.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsUserEditPage {
    final WebDriver driver;

    //Kişisel Bilgilerimi Güncelle
    @FindBy(how = How.NAME,using = "name")
    public WebElement inputPersonName;
    @FindBy(how = How.NAME,using = "surname")
    public WebElement inputSurname;
    @FindBy(how = How.NAME,using = "email")
    public WebElement inputEmail;
    @FindBy(how = How.NAME,using = "phoneNumber")
    public WebElement inputPhoneNumber;
    @FindBy(how = How.ID,using = "formSubscribe")
    public WebElement clickCheckFormSubscribe;
    @FindBy(how = How.CSS,using = ".eZZTHf")
    public WebElement buttonSave;
    @FindBy(how = How.CSS,using = ".eGhXCq.sc-hMqMXs")
    public WebElement buttonIgnore;
    @FindBy(how = How.CSS,using = ".hddsMR.sc-cSHVUG")
    public WebElement buttonEditWithInfo;
    @FindBy(how = How.CSS,using = "h1 > svg[role='img']")
    public WebElement buttonEditWithUserInfo;
    @FindBy(how = How.CLASS_NAME,using = "form-error")
    public WebElement textError;



    public ContantsUserEditPage(WebDriver webDriver) {
        driver = webDriver;
    }
}
