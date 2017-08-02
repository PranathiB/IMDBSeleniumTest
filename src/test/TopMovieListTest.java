import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IMDbTop250Page;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TopMovieListTest {
    private static final int MINIMUM = 1;
    private static ChromeDriver driver;
    private IMDbTop250Page top250ResultsPage;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
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

    @After
    public void captureScreenShot() throws IOException {
        System.out.println("Take screenshot:"+"\n");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = UUID.randomUUID().toString();
        File targetFile = new File("src/test/reports/" + fileName + ".png");
        System.out.println(targetFile);
        FileUtils.copyFile(scrFile, targetFile);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
