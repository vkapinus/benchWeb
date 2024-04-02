import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultPage;

public class HomePageTest extends AbstractTest {

    private static final String QUERY = "apple";

    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        SearchResultPage searchResultPage = homePage.searchQuery(QUERY);
        searchResultPage.assertPageOpened();
    }

    @Test
    public void addProductToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        SearchResultPage searchResultPage = homePage.searchQuery(QUERY);
        searchResultPage.assertPageOpened();
        String expectedItemName = searchResultPage.getItemName(1);
        searchResultPage.addProductToCartByIndex(1);
        CartPage cartPage = searchResultPage.openCart();
        cartPage.assertPageOpened();
        String actualName = cartPage.getItemName();
        Assert.assertEquals(expectedItemName, actualName, "Product in cart is not the same that was added!");
    }

    @Test
    public void openCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        CartPage cartPage = homePage.openCart();
        Assert.assertTrue(cartPage.isEmptyCartMessagePresent(), "'Cart is empty' message is not present");
    }
}
