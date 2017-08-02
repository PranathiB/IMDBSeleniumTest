import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }
}
