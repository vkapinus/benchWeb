package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h2[text() = 'Корзина пуста']")
    private ExtendedWebElement cartIsEmptyMessage;

    @FindBy(xpath = "//a[contains(@class, 'BasketItem_title')]")
    private ExtendedWebElement itemName;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.21vek.by/order/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public boolean isEmptyCartMessagePresent() {
        return cartIsEmptyMessage.isPresent();
    }


}
