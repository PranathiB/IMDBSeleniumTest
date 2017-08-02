import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TopMovieListTest {
    private static ChromeDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
//        driver.quit();
    }

    @Test
    public void shouldHaveAtLeastOneMovieOnTopShowsPage(){
        driver.get("http://www.imdb.com/chart/top");
        List<WebElement> moviesList = driver.findElements(By.cssSelector(".lister-list tr"));
        Assert.assertTrue("At least one movie is expected in the list",moviesList.size() >= 1);
    }
}
