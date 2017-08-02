import helper.ScreenshotHelperClass;
import org.junit.*;
import org.junit.rules.TestRule;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IMDbTop250Page;

public class TopMoviesPageTest {
    private static final int MINIMUM_RESULTS = 1;
    private static final int MAXIMUM_RESULTS = 1;
    private IMDbTop250Page top250ResultsPage;

    private static ChromeDriver driver;

    @Rule
    public TestRule screenshotTaker = new ScreenshotHelperClass((TakesScreenshot) driver);

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void openBrowserWithURL(){
        top250ResultsPage = new IMDbTop250Page(driver);
        top250ResultsPage.go();
    }

    @Test
    public void shouldHaveAtLeastOneMovieOnTopRatedMoviesPage(){
        assertThatAtLeastOneMovieResultIsDisplayed();
        assertMaximunResultsCount();
    }
//
//    @Test
//    public void shouldHaveAtLeastOneMovieWhenSortedByReleaseDate(){
//        top250ResultsPage.sortMoviesBy("Release Date");
//        assertThatAtLeastOneMovieResultIsDisplayed();
//        assertMaximunResultsCount();
//    }
//
//    @Test
//    public void shouldHaveAtLeastOneMovieWhenSortedByImdbRating(){
//        top250ResultsPage.sortMoviesBy("IMDb Rating");
//        assertThatAtLeastOneMovieResultIsDisplayed();
//        assertMaximunResultsCount();
//    }
//
//    @Test
//    public void shouldHaveAtLeastOneMovieWhenSortedByNumberOfRatings(){
//        top250ResultsPage.sortMoviesBy("Number of Ratings");
//        assertThatAtLeastOneMovieResultIsDisplayed();
//        assertMaximunResultsCount();
//    }
//
//    @Test
//    public void shouldHaveAtLeastOneMovieWhenSortedByRanking(){
//        top250ResultsPage.sortMoviesBy("Ranking");
//        assertThatAtLeastOneMovieResultIsDisplayed();
//        assertMaximunResultsCount();
//    }
//
//    @Test
//    public void shouldHaveAtLeastOneMovieWhenSortedByYourRating(){
//        top250ResultsPage.sortMoviesBy("Your Rating");
//        assertThatAtLeastOneMovieResultIsDisplayed();
//        assertMaximunResultsCount();
//    }

    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM_RESULTS);
    }

    private void assertMaximunResultsCount() {
        Assert.assertTrue("At max 250 movies are expected in the list",
                top250ResultsPage.getMoviesCount() <= MAXIMUM_RESULTS);
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
