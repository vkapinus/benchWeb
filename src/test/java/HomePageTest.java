import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends AbstractTest {

    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.searchQuery("apple");
        pause(10);
    }
}
