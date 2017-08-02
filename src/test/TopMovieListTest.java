import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IMDbTop250Page;

import java.util.List;

public class TopMovieListTest {
    public static final int MINIMUM = 1;
    private static ChromeDriver driver;
    private static WebDriverWait wait;
    private IMDbTop250Page top250ResultsPage;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Before
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250Page(driver);
        top250ResultsPage.go();
    }

    @Test
    public void shouldHaveAtLeastOneMovieOnTopShowsPage(){
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM);
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByReleaseDate(){
        top250ResultsPage.sortMoviesByRanking();
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM);
    }
}
