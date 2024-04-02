package components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemComponent extends AbstractUIObject {

    @FindBy(xpath = ".//button[text() = 'В корзину']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//span[@class = 'result__name']")
    private ExtendedWebElement itemName;

    public ItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getItemName() {
        return itemName.getText();
    }
}
