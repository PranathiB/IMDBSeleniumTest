import helper.ScreenshotHelperClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IMDbTop250MovieResultsPage;

public class BaseTest {

    private static ChromeDriver driver;

    @Rule
    public TestRule screenshotTaker = new ScreenshotHelperClass((TakesScreenshot) driver);
    IMDbTop250MovieResultsPage top250ResultsPage;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250MovieResultsPage(driver);
        top250ResultsPage.go();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
