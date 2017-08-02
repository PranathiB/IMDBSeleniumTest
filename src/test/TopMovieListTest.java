import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IMDbTop250Page;

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
    public void shouldHaveAtLeastOneMovieOnTopRatedMoviesPage(){
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByReleaseDate(){
        top250ResultsPage.sortMoviesBy("Release Date");
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByImdbRating(){
        top250ResultsPage.sortMoviesBy("IMDb Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByNumberOfRatings(){
        top250ResultsPage.sortMoviesBy("Number of Ratings");
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByRanking(){
        top250ResultsPage.sortMoviesBy("Ranking");
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    @Test
    public void shouldHaveAtLeastOneMovieWhenSortedByYourRating(){
        top250ResultsPage.sortMoviesBy("Your Rating");
        assertThatAtLeastOneMovieResultIsDisplayed();
    }

    private void assertThatAtLeastOneMovieResultIsDisplayed() {
        Assert.assertTrue("At least one movie is expected in the list",
                top250ResultsPage.getMoviesCount() >= MINIMUM);
    }

}
