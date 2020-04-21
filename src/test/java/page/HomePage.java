package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cc-banner-legacy__icon-close")
    private WebElement cookieButton;

    @FindBy(id = "imysearchstring")
    private WebElement chooseCity;

    @FindAll({@FindBy(css = ".lp__place")})
    private List<WebElement> correctAddress;

    public void CookiesButton(){
        cookieButton.click();
    }

    public void RandomCity(String address) {
        chooseCity.click();
        chooseCity.clear();
        chooseCity.sendKeys(address);
    }

    public List<WebElement> getCorrectAddress(){
        return correctAddress;
    }
}
