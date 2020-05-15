package contants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContantsMainPage
{
    final WebDriver driver;
    //Main Page
    @FindBy(how = How.LINK_TEXT,using = "GİRİŞ YAP")
    public WebElement buttonMainLogin;
    @FindBy(how = How.CSS,using = ".col-copy")
    public WebElement copyrightText;
    @FindBy (how = How.LINK_TEXT,using = "Profilim")
    public WebElement buttonProfilim;
    @FindBy(how = How.CSS,using = ".userbox-avatar-box")
    public WebElement wrapperProfile;

    public ContantsMainPage(WebDriver webDriver) {
        driver = webDriver;
    }
}
