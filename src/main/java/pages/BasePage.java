package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    @FindBy(id = "catalogSearch")
    private ExtendedWebElement searchInput;

    @FindBy(className = "headerCart")
    private ExtendedWebElement cartIcon;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchQuery(String query) {
        searchInput.type(query);
        searchInput.sendKeys(Keys.ENTER);
        pause(5);
        return new SearchResultPage(getDriver());
    }

    public CartPage openCart() {
        cartIcon.click();
        return new CartPage(getDriver());
    }
}
