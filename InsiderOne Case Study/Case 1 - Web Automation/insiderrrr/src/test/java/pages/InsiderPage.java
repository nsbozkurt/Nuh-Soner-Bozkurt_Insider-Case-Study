package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InsiderPage {
    public InsiderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "career-our-location")
    public WebElement locationsBlock;

    @FindBy(id = "navigation")
    public WebElement navigationBar;

    @FindBy(id = "footer")
    public WebElement footer;

}