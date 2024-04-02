package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import components.ItemComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Результаты поиска']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//li[contains(@class, 'result__item')]")
    private List<ItemComponent> items;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public void addProductToCartByIndex(int index) {
        items.get(index - 1).addToCart();
    }

    public String getItemName(int index) {
        return items.get(index - 1).getItemName();
    }


}
